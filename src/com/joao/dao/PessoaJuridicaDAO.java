package com.joao.dao;

import com.joao.banco.PessoaJuridica;
import conection.ConectionF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaJuridicaDAO {

    Connection con;

    public PessoaJuridicaDAO() {
        con = ConectionF.getConnection();
    }

    public boolean registrarPessoaj(PessoaJuridica pessoaJuridica){

        String sqlPai = "INSERT INTO pessoa(TipoPessoa,NomePessoa,EnderecoPessoa,CepPessoa,TelefonePessoa,RendaPessoa,SituacaoPessoa)" +
                " VALUES(?,?,?,?,?,?,?);";
        String sqlFilha = "INSERT INTO PessoaJuridica (CnpjPessoaJuridica,CodigoPessoaJuridica) " +
                "VALUES(?,(select LAST_INSERT_ID()));";

        PreparedStatement stmtPai = null;
        PreparedStatement stmtFilho = null;

        try {
            con.setAutoCommit(false);
            stmtPai = con.prepareStatement(sqlPai);
            stmtFilho = con.prepareStatement(sqlFilha);

            stmtPai.setInt(1,2);
            stmtPai.setString(2,pessoaJuridica.getNomePessoa());
            stmtPai.setString(3,pessoaJuridica.getEnderecoPessoa());
            stmtPai.setLong(4,pessoaJuridica.getCepPessoa());
            stmtPai.setString(5,pessoaJuridica.getTelefonePessoa());
            stmtPai.setDouble(6,pessoaJuridica.getRendaPessoa());
            stmtPai.setInt(7,pessoaJuridica.getSituacaoPessoa());
            stmtPai.executeUpdate();

            stmtFilho.setString(1,pessoaJuridica.getCnpjPessoa());
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

    public PessoaJuridica consultarPj(String cnpj){

        String sqlConsulta = "SELECT P.NomePessoa AS nome,P.EnderecoPessoa AS endereco,P.TelefonePessoa AS tel,PJ.CnpjPessoaJuridica AS cnpj FROM pessoa P INNER JOIN pessoajuridica PJ ON Pj.CodigoPessoaJuridica = P.CodigoPessoa WHERE PJ.CnpjPessoaJuridica = (?);";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlConsulta);
            stmt.setString(1,cnpj);
            rs = stmt.executeQuery();

            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            while (rs.next()){
                pessoaJuridica.setNomePessoa(rs.getString("nome"));
                pessoaJuridica.setEnderecoPessoa(rs.getString("endereco"));
                pessoaJuridica.setTelefonePessoa(rs.getString("tel"));
                pessoaJuridica.setCnpjPessoa(rs.getString("cnpj"));
            }
            return pessoaJuridica;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            ConectionF.closeConnection(con,stmt,rs);
        }

    }
}
