/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase es para gestionar las transacciones a la base de
 *              datos, específicamente en la tabla rol.
 */
package model;

import bd.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.Rol;
import java.util.ArrayList;
import java.util.List;

public class RolModelImpl implements IRolModel {

    /**
     * Declaración de las variables a utilizar en toda la clase
     */
    private Conexion conexion;
    private Connection connection;
    private Statement stm;

    /**
     * Método para insertar un registro en la tabla rol, utilizamos un try para
     * gestionar un fallo en la ejecución de la transacción, como primer paso
     * establecemos los valores de la BD, obtenemos la conexión, definimos la
     * transacción, la preparamos y posteriormente la ejecutamos, finalmente
     * cerramos la ejecución y la conexión
     */
    @Override
    public void insertarRegistro(Rol rol) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL insertarRegistro('" + rol.getRol() + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para obtener toos los registro de la tabla rol, recorremos los
     * registros y lo almacenamos como objetos en una lista para retornarlos
     */
    @Override
    public List<Rol> obtenerRegistro() {
        try {
            List<Rol> listaRol = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL obtenerRegistro";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt(1));
                rol.setRol(rs.getString(2));
                listaRol.add(rol);
            }
            stm.close();
            connection.close();
            return listaRol;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para eliminar un registro de la tabla jugador mediante el id del
     * registro
     */
    @Override
    public void eliminarRegistro(int id) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL eliminarRegistro('" + id + "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para buscar un registro en la tabla rol mediante el nombre del
     * registro
     */
    @Override
    public Rol buscarRegistro(String rol) {
        try {
            Rol rolConsulta = new Rol();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL buscarRegistro('" + rol + "')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            rolConsulta.setIdRol(rs.getInt(1));
            rolConsulta.setRol(rs.getString(2));
            stm.close();
            connection.close();
            return rolConsulta;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para actualizar un registro en la tabla rol mediante el id del
     * registro
     */
    @Override
    public void actualizarRegistro(Rol rolNuevo) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL actualizarRegistro('" + rolNuevo.getRol()
                    + "','" + rolNuevo.getIdRol() + "')";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
