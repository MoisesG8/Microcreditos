/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.service;

import com.proyecto.bd.dao.LibrosDao;
import com.proyecto.bd.entidades.Libros;
import java.util.List;

/**
 *
 * @author Moisés
 */
public class UsarServicioLibro {
    private LibrosDao librodao;
    
    public UsarServicioLibro(){
        librodao=new LibrosDao();
    }
    
    public List<Libros> getallLibros(){
        return librodao.getallLibros();
    }
    public void create(Libros l){
        if(l==null)
            throw new NullPointerException("USUARIO NO PUEDE SER NULL");
       librodao.addLibro(l);
    }
     public void eliminar(int id){
      librodao.eliminarcliente(id);
    }
      public Libros update(Libros l){
        if(l==null)
            throw new NullPointerException("USUARIO NO PUEDE SER NULL");
   
    return    librodao.updatecliente(l);
        
    }

}
