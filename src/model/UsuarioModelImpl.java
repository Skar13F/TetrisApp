/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: clase para gestionar las transacciones de los objetos usuario
 *              a la base de datos, específicamente en la tabla jugador.
 */
package model;

import bd.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

    /**
     * Declaración de las variables a utilizar en toda la clase
     */
    private Conexion conexion;
    private Connection connection;
    private Statement stm;

    /**
     * Método para insertar un registro en la tabla usuario, utilizamos un try
     * para gestionar un fallo en la ejecución de la transacción, como primer
     * paso establecemos los valores de la BD, obtenemos la conexión, definimos
     * la transacción, la preparamos y posteriormente la ejecutamos, finalmente
     * cerramos la ejecución y la conexión
     */
    @Override
    public void insertarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            int id_jugador = usuario.getId_jugador();
            String query = "CALL insertarUsuario('" + usuario.getNombre()
                    + "','" + usuario.getPassword() + "','" + id_jugador + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
            if (usuario.getId_rol() > 0) {
                try {
                    Conexion conexion1 = new Conexion();
                    Connection connection1 = conexion1.getConnection();
                    Usuario usuario1 = this.buscarRegistro(
                            usuario.getNombre());
                    int idUsuario = usuario1.getId_usuario();
                    int idRol = usuario.getId_rol();
                    String query1 = "CALL insertar_Usuario_rol('" + idUsuario
                            + "','" + idRol + "')";
                    Statement stm1 = connection1.createStatement();
                    stm1.execute(query1);
                    stm1.close();
                    connection1.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para obtener toos los registro de la tabla usuario, recorremos los
     * registros y lo almacenamos como objetos en una lista para retornarlos
     */
    @Override
    public List<Usuario> obtenerRegistro() {
        try {
            List<Usuario> listaUsuario = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL obtenerUsuario";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                listaUsuario.add(usuario);
            }
            stm.close();
            connection.close();
            return listaUsuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para eliminar un registro de la tabla usuario mediante el id del
     * registro
     */
    @Override
    public void eliminarRegistro(int id) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL eliminarUsuario('" + id + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para buscar un registro en la tabla usuario mediante su id
     */
    @Override
    public Usuario buscarRegistro(int id) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL buscarUsuario('" + id + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(1));
            usuario.setNombre(rs.getString(2));
            stm.close();
            connection.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para actualizar un registro en la tabla usuario mediante el id del
     * registro
     */
    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            int id_usuario = usuario.getId_usuario();
            int id_jugador = usuario.getId_jugador();
            String query = "CALL actualizarUsuario('" + usuario.getNombre()
                    + "','" + usuario.getPassword() + "','" + id_jugador
                    + "','" + id_usuario + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
            try {
                Conexion conexion1 = new Conexion();
                Connection connection1 = conexion1.getConnection();
                int idUsuario = usuario.getId_usuario();
                int idRol = usuario.getId_rol();
                String query1 = "CALL insertar_Usuario_rol('" + idUsuario
                        + "','" + idRol + "')";
                Statement stm1 = connection1.createStatement();
                stm1.execute(query1);
                stm1.close();
                connection1.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para buscar un registro en la tabla usuario mediante su nombre y
     * contraseña
     */
    @Override
    public Usuario buscarRegistro(Usuario user) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            int aux = user.getId_rol();
            String query = "CALL buscarUsuarioNCP('" + user.getNombre()
                    + "','" + user.getPassword() + "','" + aux + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(3));
            usuario.setNombre(rs.getString(1));
            usuario.setPassword(rs.getString(2));
            usuario.setId_jugador(rs.getInt(4));
            stm.close();
            connection.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para buscar un registro en la tabla usuario mediante su nombre
     */
    @Override
    public Usuario buscarRegistro(String nombre) {
        try {
            Usuario usuario = new Usuario();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL buscarUsuarioNombre('" + nombre + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            usuario.setId_usuario(rs.getInt(1));
            usuario.setNombre(rs.getString(2));
            usuario.setPassword(rs.getString(3));
            stm.close();
            connection.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
