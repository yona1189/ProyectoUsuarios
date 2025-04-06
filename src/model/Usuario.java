/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yona20
 */


public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contrasenia;
    
    public Usuario() {}
    
    public Usuario (int id, String nombre, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    
    public String getContrasenia() {return contrasenia;}
    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}
    
}
