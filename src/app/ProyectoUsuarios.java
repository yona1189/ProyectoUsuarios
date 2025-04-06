package app;


/*
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoUsuarios {

    public static void main(String[] args) {
        // Configurar salida en UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String usuario = "root";
        String password = "Marian2016";
        String url = "jdbc:mysql://localhost:3306/prueba?useUnicode=true&characterEncoding=UTF-8";

        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : " +
                        rs.getString("nombre") + " : " +
                        rs.getString("contraseña"));
            }

            // Variable interna con caracteres especiales
            String valor = "Árbol de niñes";
            System.out.println(valor);

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
*/

// Importamos las clases de nuestros paquetes model, view y controller
import model.*;
import view.*;
import controller.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

// Importamos clases de Java para la conexión a la base de datos y entrada por consola
import java.sql.Connection;
import java.util.Scanner;

public class ProyectoUsuarios {
    public static void main(String[] args) {
         // Configurar salida en UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // Obtenemos una conexión a la base de datos mediante la clase ConexionDB del modelo
            Connection con = ConexionDB.obtenerConexion();

            // Creamos una instancia del DAO (Data Access Object) que manejará las operaciones de base de datos
            UsuarioDAO dao = new UsuarioDAO(con);
            
            // Creamos la vista, que será responsable de mostrar los datos por consola
            UsuarioVista vista = new UsuarioVista();
            
            // Creamos el controlador, que coordina la lógica entre la vista y el modelo
            UsuarioControlador ctrl = new UsuarioControlador(dao, vista);

            // Creamos un escáner para leer la entrada del usuario desde consola
            Scanner sc = new Scanner(System.in);
            int opcion; // variable para guardar la opción seleccionada por el usuario

            // Bucle principal del programa: muestra un menú y ejecuta la acción elegida
            do {
                System.out.println("\n1. Insertar usuario\n2. Mostrar usuarios\n3. Actualizar usuario\n4. Eliminar usuario\n0. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt(); // Leemos la opción
                sc.nextLine(); // Consumimos el salto de línea

                // Evaluamos la opción con switch
                switch (opcion) {
                    case 1:
                        // Insertar usuario
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Correo: ");
                        String correo = sc.nextLine();
                        System.out.print("Contraseña: ");
                        String contrasenia = sc.nextLine();
                        ctrl.insertarUsuario(nombre, correo, contrasenia); // Llamamos al controlador
                        break;
                    case 2:
                        // Mostrar todos los usuarios
                        ctrl.mostrarUsuarios();
                        break;
                    case 3:
                        // Actualizar usuario
                        System.out.print("ID del usuario: ");
                        int id = sc.nextInt(); sc.nextLine(); // Leemos el ID
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine(); // Leemos nuevo nombre
                        System.out.print("Nuevo correo: ");
                        String nuevoCorreo = sc.nextLine(); // Leemos nuevo correo
                        String nuevaContrasenia = null;
                        
                        ctrl.actualizarUsuario(id, nuevoNombre, nuevoCorreo, nuevaContrasenia);
                        break;
                    case 4:
                        // Eliminar usuario
                        System.out.print("ID del usuario a eliminar: ");
                        int idEliminar = sc.nextInt();
                        ctrl.eliminarUsuario(idEliminar);
                        break;
                }
            } while (opcion != 0); // El bucle se repite hasta que el usuario elija 0 (Salir)

            // Cerramos el escáner y la conexión al final del programa
            sc.close();
            con.close();

        } catch (Exception e) {
            // Capturamos cualquier error que ocurra y lo mostramos
            e.printStackTrace();
        }
    }
}