package com.mycompany.reportes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionPool {
    private Connection conn;
    
    public ConexionPool() {
        conn = null;
    }        
    
    public void conectar(){
        try {            
            Context initCtx;     
            initCtx = new InitialContext();
            DataSource ds = (DataSource)initCtx.lookup("java:app/jdbc/myDatasource");  
            conn=ds.getConnection();
            
        }catch(NamingException | SQLException e){
            System.out.println("db: " + e.getMessage());                         
        }         
    }   
    
    public Connection getConexion(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

