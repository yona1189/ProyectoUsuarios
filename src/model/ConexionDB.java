/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yona20
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    //private static final String Url = "jdbc:mysql://localhost:3600/prueba";
    private static final String Url = "jdbc:mysql://localhost:3306/prueba?useUnicode=true&characterEncoding=UTF-8";
    private static final String Usuario = "root";
    private static final String Clave = "Marian2016";
    
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(Url, Usuario, Clave);
    }
    
}
