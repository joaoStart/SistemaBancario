package com.joao.dao;

import com.joao.banco.PessoaFisica;
import conection.ConectionF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisicaDAO {

    Connection con;

    public PessoaFisicaDAO() {
        con = ConectionF.getConnection();
    }

    public boolean registrarPessoaf(PessoaFisica pessoaFisica){

        String sqlPai = "INSERT INTO pessoa(TipoPessoa,NomePessoa,EnderecoPessoa,CepPessoa,TelefonePessoa,RendaPessoa,SituacaoPessoa)" +
                " VALUES(?,?,?,?,?,?,?);";
        String sqlFilha = "INSERT INTO pessoafisica (CpfPessoaFisica,RgPessoaFisica,IdadePessoaFisica,CodigoPessoaFisica) " +
                "VALUES(?,?,?,(select LAST_INSERT_ID()));";

        PreparedStatement stmtPai = null;
        PreparedStatement stmtFilho = null;

        try {
            con.setAutoCommit(false);
            stmtPai = con.prepareStatement(sqlPai);
            stmtFilho = con.prepareStatement(sqlFilha);

            stmtPai.setInt(1,1);
            stmtPai.setString(2,pessoaFisica.getNomePessoa());
            stmtPai.setString(3,pessoaFisica.getEnderecoPessoa());
            stmtPai.setLong(4,pessoaFisica.getCepPessoa());
            stmtPai.setString(5,pessoaFisica.getTelefonePessoa());
            stmtPai.setDouble(6,pessoaFisica.getRendaPessoa());
            stmtPai.setInt(7,pessoaFisica.getSituacaoPessoa());
            stmtPai.executeUpdate();

            stmtFilho.setString(1,pessoaFisica.getCpfPessoa());
            stmtFilho.setString(2,pessoaFisica.getRgPessoa());
            stmtFilho.setInt(3,pessoaFisica.getIdadePessoa());
            stmtFilho.executeUpdate();

            con.commit();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            ConectionF.closeConnection(con,stmtPai);
            try {
                assert stmtFilho != null;
                stmtFilho.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public PessoaFisica consultarPf(String cpf){

        String sqlConsulta = "SELECT P.NomePessoa AS nome,P.EnderecoPessoa AS endereco,P.TelefonePessoa AS tel,PF.RgPessoaFisica AS rg,PF.CpfPessoaFisica AS cpf FROM pessoa P INNER JOIN pessoafisica PF ON PF.CodigoPessoaFisica = P.CodigoPessoa WHERE PF.CpfPessoaFisica = (?);";

        PreparedStatement stmt = null;
        ResultSet           rs = null;

        try {
            stmt = con.prepareStatement(sqlConsulta);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();

            PessoaFisica pessoaFisica = new PessoaFisica();
            while (rs.next()){
                pessoaFisica.setNomePessoa(rs.getString("nome"));
                pessoaFisica.setEnderecoPessoa(rs.getString("endereco"));
                pessoaFisica.setTelefonePessoa(rs.getString("tel"));
                pessoaFisica.setRgPessoa(rs.getString("rg"));
                pessoaFisica.setCpfPessoa(rs.getString("cpf"));
            }

            return pessoaFisica;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }finally {
            ConectionF.closeConnection(con,stmt,rs);
        }

    }

}
