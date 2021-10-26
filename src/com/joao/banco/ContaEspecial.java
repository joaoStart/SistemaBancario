package com.joao.banco;

public class ContaEspecial extends ContaComum{

    private double limiteConta;

    public ContaEspecial(double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public long abrirConta(double valorInicial){
        return 0;
    }

    public int sacarValor(double valorSaque){
        return 0;
    }
}
