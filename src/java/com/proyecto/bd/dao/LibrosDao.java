/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.dao;

import com.proyecto.bd.entidades.Libros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 *
 * @author Moisés
 */
public class LibrosDao {
      PreparedStatement ps;
      ResultSet rs;
      Statement stmt =null;
      public List <Libros> getallLibros(){
        List<Libros> libros = new ArrayList<Libros>();
        try{
            
            Connection conn = Dao.getConnection();
            String querito="SELECT * FROM tb_libros";     
            ps= conn.prepareStatement(querito);
            rs=ps.executeQuery();
            Libros l;
            while(rs.next()){
                l = new Libros();
                l.setId_libro(rs.getInt("id_libro"));
                l.setTitulo(rs.getString("titulo"));
                l.setEditorial(rs.getString("editorial"));
                libros.add(l);
            }
          
      }catch(Exception e){
          
      } 
        return libros;
    
}
       public void addLibro(Libros campos){
        //boolean respuesta = false;
        try{
        Connection conn = Dao.getConnection();       
        String query="INSERT INTO `dbmicrocredits`.`tb_libross`(`titulo`,`editorial`,`) VALUES ('"+campos.getTitulo()+"','"+campos.getEditorial()+"');";
        stmt=conn.createStatement();
        stmt.execute(query);
        }catch(Exception e){
            System.out.print("Error en creacion");
        }
    }
       public Libros get(String editorial){
        Libros l = new Libros();
        try{
              Connection conn = Dao.getConnection();
              String querito="SELECT * FROM tb_libros WHERE editorial='"+editorial+"'";
              ps= conn.prepareStatement(querito);
              rs=ps.executeQuery();
              if(rs.next()){
                 l = new Libros(); 
                 l.setId_libro(rs.getInt("id_libro"));
                 l.setTitulo(rs.getString("titulo"));
                 l.setEditorial(rs.getString("editorial"));
              }
        }catch(Exception e){
            
        }
        return l;
    }
        public void eliminarcliente(int id){ 
        Libros l = new Libros();
        try{
            Connection conn = Dao.getConnection();
            String query="delete from tb_libros where id_libro="+id+";";
            ps=conn.prepareStatement(query);
            ps.execute(query);
}
catch(Exception ex){

}
}
         public Libros updatecliente(Libros libro){ 
   
        try{
           
            Connection conn = Dao.getConnection();
            String query="update tb_libros set titulo='"+libro.getTitulo()+"',editorial='"+libro.getEditorial()+";";
            ps=conn.prepareStatement(query);
            ps.execute(query);
        }
        catch(Exception ex){

    }
    return libro;
}
}
