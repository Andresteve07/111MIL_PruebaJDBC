/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajdbc;

/**
 *
 * @author steve-urbit
 */
public class Libro {
    private String idLibro;
    private String titulo;
    private String edicion;
    private float precio;

    public Libro(String idLibro, String titulo, String edicion, float precio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.edicion = edicion;
        this.precio = precio;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", edicion=" + edicion + ", precio=" + precio + '}';
    }
    
    
}
