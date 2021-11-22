package com.joao.dao;

import com.joao.banco.PessoaJuridica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaJuridicaDAOTest {

    @Test
    void registrarPessoaj() {

        PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
        PessoaJuridica pj = new PessoaJuridica();

        pj.setNomePessoa("Maria vitoria de oliveira");
        pj.setEnderecoPessoa("Av.1456");
        pj.setCepPessoa(54756000);
        pj.setRendaPessoa(1500);
        pj.setTelefonePessoa("(81)9.9999-8888");

        pj.setCnpjPessoa("83806348000106");

        if (pjDao.registrarPessoaj(pj)){
            System.out.println("Cliente salvo com sucesso.");
        }else{
            fail("Erro ao salvar.");
        }

    }

    @Test
    void consultarPj(){
        PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
        PessoaJuridica pj = pjDao.consultarPj("838063480001");

            System.out.println("Nome: " + pj.getNomePessoa());
            System.out.println("Endereço: " + pj.getEnderecoPessoa());
            System.out.println("Cnpj: "+ pj.getCnpjPessoa());

    }
}