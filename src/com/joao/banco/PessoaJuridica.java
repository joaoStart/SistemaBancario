package com.joao.banco;

public class PessoaJuridica extends Pessoa {

    private long cnpjPessoa;

    public long getCnpjPessoa() {
        return cnpjPessoa;
    }

    public void setCnpjPessoa(long cnpjPessoa) {
        this.cnpjPessoa = cnpjPessoa;
    }

    public int registrarPessoa(){
        return 0;
    }

    public int validarCnpj(String cnpj){
        return 1;
    }

    public String consultarCnpj(String cnpj){
        return "";
    }

    @Override
    public String toString() {
        return "PessoaJuridica[" + "\n" +
                "cnpjPessoa: " + cnpjPessoa + "\n" + super.toString();
    }
}
