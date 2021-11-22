package com.joao.dao;

import conection.ConectionF;

import java.sql.Connection;

public class ContaComumDao {

    Connection con;

    public ContaComumDao() {
        con = ConectionF.getConnection();
    }


}
