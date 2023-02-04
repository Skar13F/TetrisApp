/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: clase jugador para gestionar las transacciones a la base de
 *              datos, específicamente en la tabla jugador.
 */
package model;

import bd.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.Jugador;
import java.util.ArrayList;
import java.util.List;

public class JugadorModelImpl implements IJugadorModel {

    /**
     * Declaración de las variables a utilizar en toda la clase
     */
    private Conexion conexion;
    private Connection connection;
    private Statement stm;

    /**
     * Método para insertar un registro en la tabla jugador, utilizamos un try
     * para gestionar un fallo en la ejecución de la transacción, como primer
     * paso establecemos los valores de la BD, obtenemos la conexión, definimos
     * la transacción, la preparamos y posteriormente la ejecutamos, finalmente
     * cerramos la ejecución y la conexión
     */
    @Override
    public void insertarRegistro(Jugador jugador) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "INSERT INTO jugador(nombre, edad, sexo, telefono, "
                    + "correo) values('" + jugador.getNombre() + "','"
                    + jugador.getEdad() + "','"
                    + jugador.getSexo().charAt(0) + "','"
                    + jugador.getTelefono() + "','" + jugador.getCorreo()
                    + "')";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para obtener toos los registro de la tabla jugador, recorremos los
     * registros y lo almacenamos como objetos en una lista para retornarlos
     */
    @Override
    public List<Jugador> obtenerRegistro() {
        try {
            List<Jugador> listaJugador = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "SELECT * FROM jugador";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setId_jugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(Integer.parseInt(rs.getString(3)));
                jugador.setSexo(rs.getString(4));
                jugador.setTelefono(rs.getString(5));
                listaJugador.add(jugador);
            }
            stm.close();
            connection.close();
            return listaJugador;
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
            String query = "DELETE FROM jugador WHERE id_jugador='" + id + "'";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para buscar un registro en la tabla jugador mediante el número de
     * teléfono del registro
     */
    @Override
    public Jugador buscarRegistro(String telefono) {
        try {
            Jugador jugador = new Jugador();
            ResultSet rs;
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "SELECT * FROM jugador where telefono='" + telefono
                    + "'";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            /**
             * Para la siguiente instrucción podemos utilizar
             * jugador.setIdJugador(rs.getInt("idJugador"));
             */
            jugador.setId_jugador(rs.getInt(1));
            jugador.setNombre(rs.getString(2));
            jugador.setEdad(rs.getInt(3));
            jugador.setTelefono(rs.getString(5));
            stm.close();
            connection.close();
            return jugador;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para actualizar un registro en la tabla jugador mediante el id del
     * registro
     */
    @Override
    public void actualizarRegistro(Jugador jugadorNuevo) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "UPDATE jugador SET nombre='"
                    + jugadorNuevo.getNombre() + "' WHERE jugador.id_jugador='"
                    + jugadorNuevo.getId_jugador() + "';";
            stm = connection.createStatement();
            stm.execute(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarPuntos(Jugador jugador) {
        try {
            conexion = new Conexion();
            connection = conexion.getConnection();
            String query = "CALL actualizarPuntos('" +jugador.getId_jugador()+ "','"
                    + jugador.getPuntos()+ "')";
            stm = connection.createStatement();
            stm.execute(query);
            System.out.println(jugador.getPuntos()+"   "+jugador.getId_jugador());
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
