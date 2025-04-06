/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Yona20
 */

import model.*;
import view.*;
import java.sql.*;
import java.util.*;


public class UsuarioControlador {
    private UsuarioDAO dao;
    private UsuarioVista vista;
    
    public UsuarioControlador(UsuarioDAO dao, UsuarioVista vista){
        this.dao = dao;
        this.vista = vista;
    }
    
    //Controlamos el CRUD desde la clase usuario Contolador CON sus funciones:
    
    //insertando un usuario en la base de dados
    public void insertarUsuario (String nombre, String correo, String contrasenia) {
        //encerreamos en un try catch para atrapar las excepciones
        try {
            //creamos un objeto de tupo usuario
            Usuario u = new Usuario();
            //pasamos el nombre, correo y contraseña al objeto
            u.setNombre(nombre);
            u.setCorreo(correo);
            u.setContrasenia(contrasenia);
            //se llama a la funcion insertar de UsuariosDAO
            dao.insertar(u);
            vista.mostrarMensaje("¡Usuario insertado con éxito!");
        }catch(SQLException e){
            vista.mostrarMensaje("Error insertando usuario => "+e.getMessage());
        }   
    }
    
    //mostrando todos los usuarios en la base de dados
    public void mostrarUsuarios() {
        //encerreamos en un try catch para atrapar las excepciones
        try{
            /*
            se llama a la funcion obtenerTodos de la clase UsuariosDAO 
            y se guarda en una lista todos los registros de la bases de datos
            */
            List<Usuario> lista  = dao.obtenerTotos();
            //mostramos los datos de la lista por medio de la funcion 
            //mostradUsuarios de la clases UsuariosVista pasando como parametro la lista de usuarios
            vista.MostrarUsauarios(lista);
        }catch(SQLException e){
            vista.mostrarMensaje("Error consultando usuarios => "+e.getMessage());
        }
    }
    
    //Actualizando un usuario
    public void actualizarUsuario(int id, String nombre, String correo, String contrasenia) {
        //encerreamos en un try catch para atrapar las excepciones
        try{
            Usuario u = new Usuario(id, nombre, correo, contrasenia);
            //llamaos a la funcion que actualiza en usuario de la clase UsuarioDAO
            dao.actualizar(u);
            vista.mostrarMensaje("Usuario actualizado");
            
        }catch(SQLException e){
            vista.mostrarMensaje("Error actualizando usuario => "+ e.getMessage());
        }
    }
    
    //Eliminando un usuario
     public void eliminarUsuario(int id) {
         //encerreamos en un try catch para atrapar las excepciones
         try {
             //Llamamos a la funcion eliminar de la clase UsuarioDAO
            dao.eliminar(id);
            vista.mostrarMensaje("Usuario eliminado.");
        } catch (SQLException e) {
            vista.mostrarMensaje("Error eliminando usuario: " + e.getMessage());
        }
    }
  
    
}
