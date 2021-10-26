package com.joao.banco;

import java.util.Date;

public class ContaPoupanca extends ContaComum {

    private Date aniversarioConta;

    public Date getAniversarioConta() {
        return aniversarioConta;
    }

    public void setAniversarioConta(Date aniversarioConta) {
        this.aniversarioConta = aniversarioConta;
    }

    public double rendaConta(double taxa){
        return 0;
    }
}
