/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;

/**
 *
 * @author victor
 */
public class ConnectionFactory {
    
    //public static final String DRIVER = "com.postgresql.jdbc.Driver" ;
    public static final String URL = "jdbc:postgresql://localhost/TodoApp";
    public static final String USER = "postgres";
    public static final String PASS = "03111999";
    
    public static Connection getConnection() {
        try {
            //Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex){
            throw new RuntimeException("Erro na conexão com o banco de dados",
            ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        } catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com "
                    + "o banco de dados", 
            ex);
        }
    }
    
    public static void closeConnection(Connection connection, 
            PreparedStatement statement){
        try{
            if (connection != null){
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }    
        } catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", 
            ex);
        }
    }
    public static void closeConnection(Connection connection, 
            PreparedStatement statement, ResultSet resultSet){
        try{
            if (connection != null){
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
            if (resultSet != null) {
                    resultSet.close();
                }
        } catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", 
            ex);
        }
    }

}
