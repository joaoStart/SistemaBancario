package com.joao.banco;

public class Pessoa {

    protected String nomePessoa;
    protected String enderecoPessoa;
    protected long cepPessoa;
    protected String telefonePessoa;
    protected double rendaPessoa;
    protected int situacaoPessoa = 1;

    public Pessoa() {
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public long getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(long cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public double getRendaPessoa() {
        return rendaPessoa;
    }

    public void setRendaPessoa(double rendaPessoa) {
        this.rendaPessoa = rendaPessoa;
    }

    @Override
    public String toString() {
        return "nomePessoa: " + nomePessoa + "\n" +
                "enderecoPessoa: " + enderecoPessoa + "\n" +
                "cepPessoa: " + cepPessoa + "\n" +
                "telefonePessoa: " + telefonePessoa + "\n" +
                "rendaPessoa: " + rendaPessoa +
                ']';
    }
}
