package com.joao.banco;

import java.util.Date;

public class ContaComum {

    protected long numConta;
    protected Date aberturaConta;
    protected Date fechamentoConta;
    protected int senha;
    protected double saldo;

    public ContaComum() {
    }

    public ContaComum(long numConta, int senha, double saldo) {
        this.numConta = numConta;
        this.senha = senha;
        this.saldo = saldo;
    }

    public long getNumConta() {
        return numConta;
    }

    public void setNumConta(long numConta) {
        this.numConta = numConta;
    }

    public Date getAberturaConta() {
        return aberturaConta;
    }

    public void setAberturaConta(Date aberturaConta) {
        this.aberturaConta = aberturaConta;
    }

    public Date getFechamentoConta() {
        return fechamentoConta;
    }

    public void setFechamentoConta(Date fechamentoConta) {
        this.fechamentoConta = fechamentoConta;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long abrirConta(int senha){
        return 0;
    }

    public int consultarContar(long numConta){
        return 0;
    }

    public int validarSenha(int senha){
        return 0;
    }

    public void emitirSaldo(){
        System.out.println("Saldo: " + this.getSaldo());
    }

    public String emitirExtrato(Date dataInicial, Date dataFinal){
        return "";
    }

    public int sacarValor(double valor){
        return 0;
    }

    public int depositarValor(long numConta,double valor){
        return 0;
    }

    public void encerrarConta(long numConta){
    }

}
