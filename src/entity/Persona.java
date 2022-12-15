/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 25 de noviembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
 * Descripción: clase que modela al objeto abstracto persona, el cual contiene
 *              una variable de tipo String que guardará el nombre que le
 *              corresponde a la persona, un int para la edad, un String para
 *              el sexo, un string para el teléfono, un String para el correo.
 */
package entity;

public class Persona {

    /**
     * Declaración de variables
     */
    private String nombre;
    private int edad;
    private String sexo;
    private String telefono;
    private String correo;
    private String direccion;

    /**
     * Métodos get y set de los atributos
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
