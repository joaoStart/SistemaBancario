package com.joao.banco;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class PessoaFisica extends Pessoa {

    private String cpfPessoa;
    private String rgPessoa;
    private int idadePessoa;
    ArrayList<Pessoa> pf = new ArrayList<>();

    public PessoaFisica() {
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public int getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(int idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public int registrarPessoa(PessoaFisica pessoaF){

        if (pessoaF.validadorCpf(getCpfPessoa())){
            pf.add(pessoaF);
            return 1;
        }
        return 0;
    }

    public boolean validadorCpf(String cpf){
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)){
            return false;
        }

        char dig10;
        char dig11;
        int sm, i, r, num, peso;

        try{
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++){
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)){
                dig10 = '0';
            } else{
                dig10 = (char)(r + 48);
            }

            sm = 0;
            peso = 11;

            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)){
                dig11 = '0';
            }else{
                dig11 = (char)(r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return (true);
            } else {
                return(false);
            }

        }catch (InputMismatchException e){
            return false;
        }

    }

    public String consultarCpf(String cpf){

        if (getCpfPessoa() != null && getCpfPessoa() != " "){
            pf.contains(cpf);
            return "Número de Cpf válido pertence á :  " + getNomePessoa() ;
        }

        return "Número de Cpf não encontrado.";
    }

    @Override
    public String toString() {
        return "PessoaFisica[" + "\n" +
                "cpfPessoa: " + cpfPessoa + "\n" +
                "rgPessoa: " + rgPessoa + "\n" +
                "idadePessoa: " + idadePessoa + "\n" +
                super.toString();
    }
}
