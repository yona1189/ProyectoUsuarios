/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Yona20
 */

import model.Usuario;
import java.util.List;

public class UsuarioVista {
    public void MostrarUsauarios(List<Usuario> usuarios) {
        for(Usuario u: usuarios) {
            System.out.println("|------------------------------------------------------------------------------------------|");
            System.out.println("ID: "+ u.getId() + " Nombre: "+ u.getNombre() +" Correo: "+u.getCorreo() + " Contraseña: " + u.getContrasenia());
            System.out.println("|------------------------------------------------------------------------------------------|");
        }
    }
    
    public void mostrarMensaje(String mensaje){
         System.out.println("--------------------->");
        System.out.println(mensaje);
    }
    
}
