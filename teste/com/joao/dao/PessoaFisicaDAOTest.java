package com.joao.dao;

import com.joao.banco.Pessoa;
import com.joao.banco.PessoaFisica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaFisicaDAOTest {

    public PessoaFisicaDAOTest() {

    }

    @Test
    void registrarPessoaf() {
        PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
        PessoaFisica pf = new PessoaFisica();

        pf.setNomePessoa("Thayna Carla Monteiro Ferreira");
        pf.setEnderecoPessoa("Av.123");
        pf.setCepPessoa(54730-000);
        pf.setRendaPessoa(1500);
        pf.setTelefonePessoa("(81)9.9999-0987");

        pf.setCpfPessoa("08692524451");
        pf.setRgPessoa("9420693");
        pf.setIdadePessoa(19);

        if (pfDao.registrarPessoaf(pf)){
            System.out.println("Cliente salvo com sucesso.");
        }else{
            fail("Erro ao salvar.");
        }
    }

    @Test
    void consultarPf(){
        PessoaFisicaDAO pfDao1 = new PessoaFisicaDAO();
        PessoaFisica pf1 = pfDao1.consultarPf("08692524459");

        System.out.println("Nome: " + pf1.getNomePessoa());
        System.out.println("Endereço: " + pf1.getEnderecoPessoa());
        System.out.println("CPF: "+ pf1.getCpfPessoa());


    }

}