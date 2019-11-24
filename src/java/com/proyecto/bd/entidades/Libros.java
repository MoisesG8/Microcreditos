/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.entidades;

/**
 *
 * @author Moisés
 */
public class Libros {
    private int id_libro;
    private String titulo;
    private String editorial;
    
    public Libros(){
        
    }
     public Libros(int id_libro, String titulo, String editorial) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
}
