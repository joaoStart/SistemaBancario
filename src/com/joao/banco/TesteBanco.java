package com.joao.banco;

public class TesteBanco {
    public static void main(String[] args) {

        PessoaFisica p1 = new PessoaFisica();

        p1.setNomePessoa("João Victor de Oliveira");
        p1.setEnderecoPessoa("Av.Doutor não te enteressa");
        p1.setCepPessoa(54731000);
        p1.setTelefonePessoa("(81)99999-8888");
        p1.setRendaPessoa(1343.56);
        p1.setCpfPessoa("20648694097");
        p1.setRgPessoa("8450960");

        System.out.println(p1.registrarPessoa(p1));




    }
}
