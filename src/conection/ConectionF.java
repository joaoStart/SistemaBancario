package conection;

import java.sql.*;

public class ConectionF {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_banco";
    private static final String USER = "root";
    private static final String PASS = "15133119";


    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER, PASS);
        } catch (ClassNotFoundException | SQLException  e) {
            throw new RuntimeException("Erro na conexão: ", e);
        }

    }
    public static void closeConnection(Connection con){
        try{
            if (con != null){
                con.close();
            }
        }catch (SQLException ex){
            System.err.println("Erro: "+ ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){

        try{
            if (stmt != null){
                stmt.close();
            }
        }catch (SQLException ex){
            System.err.println("Erro: "+ ex);
        }

        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){

        try{
            if (rs != null){
                rs.close();
            }
        }catch (SQLException ex){
            System.err.println("Erro: "+ ex);
        }

        closeConnection(con,stmt);
    }

}