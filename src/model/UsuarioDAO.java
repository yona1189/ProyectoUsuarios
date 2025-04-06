/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yona20
 */

import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    private Connection con;
    
    public UsuarioDAO(Connection con) {
        this.con = con;
    }
    
    //funcion para insertar un nuevo Usuario usando un objeto de tipo usuario como parametro
    public void insertar(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuarios (nombre, correo, contraseña) VALUES"
                + "(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getCorreo());
        stmt.setString(3, usuario.getContrasenia());
        stmt.execute();
    }
    
    //funcion para obtener los usuario de la base de datos
    public List<Usuario> obtenerTotos() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {
            //Se crea un objeto u de tipo usuario para agregar cada campo en un array llmado lista
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setContrasenia(rs.getString("contraseña"));
            lista.add(u);
        }
        return lista;
    }
    
    //funsicion para actualuzar el nombre y correo de  un usuario por medio de su id
    public void actualizar (Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getCorreo());
        stmt.setInt(3, usuario.getId());
        stmt.executeUpdate();
    } 
    
    public void eliminar (int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
    
}
