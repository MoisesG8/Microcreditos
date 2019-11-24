/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.dao;

import com.proyecto.bd.entidades.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moisés
 */
public class ClienteDao {
       PreparedStatement ps;
       ResultSet rs;
       Statement stmt =null;
    public List <Cliente> getAll(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            
            Connection conn = Dao.getConnection();
            String querito="SELECT * FROM tb_clientes";     
            ps= conn.prepareStatement(querito);
            rs=ps.executeQuery();
            Cliente c;
            while(rs.next())
            {
              c =new Cliente();
              c.setId(rs.getInt("id"));
              c.setNombre(rs.getString("nombre"));
              c.setApellidos(rs.getString("apellidos"));
              c.setDpi(rs.getString("dpi"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono")); 
              c.setEdad(rs.getInt("edad"));  
              c.setEmail(rs.getString("email"));  
              
              clientes.add(c);    
            }
            
        }catch(Exception e){
            
        }
        return clientes;
    }
    public Cliente get(String nombres){
        Cliente c = new Cliente();
        try{
              Connection conn = Dao.getConnection();
              String querito="SELECT * FROM tb_clientes WHERE nombre='"+nombres+"'";
              ps= conn.prepareStatement(querito);
              rs=ps.executeQuery();
              if(rs.next()){
                 c = new Cliente(); 
                 c.setId(rs.getInt("id"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellidos(rs.getString("apellidos"));
                 c.setEdad(rs.getInt("edad"));
              }
        }catch(Exception e){
            
        }
        return c;
    }
    public Cliente updatecliente(Cliente cliente){ 
   
        try{
           
            Connection conn = Dao.getConnection();
            String query="update tb_clientes set nombre='"+cliente.getNombre()+"',apellidos='"+cliente.getApellidos()+"',dpi='"+cliente.getDpi()+"',direccion='"+cliente.getDireccion()+"',telefono='"+cliente.getTelefono()+"',edad='"+cliente.getEdad()+"',email='"+cliente.getEmail()+"' where id="+cliente.getId()+";";
            ps=conn.prepareStatement(query);
            ps.execute(query);
        }
        catch(Exception ex){

    }
    return cliente;
}
    public void addcliente(Cliente campos){
        //boolean respuesta = false;
        try{
        Connection conn = Dao.getConnection();       
        String query="INSERT INTO `dbmicrocredits`.`tb_clientes`(`nombre`,`apellidos`,`dpi`,`direccion`,`telefono`,`edad`,`email`) VALUES ('"+campos.getNombre()+"','"+campos.getApellidos()+"','"+campos.getDpi()+"','"+campos.getDireccion()+"','"+campos.getTelefono()+"','"+campos.getEdad()+"','"+campos.getEmail()+"');";
        stmt=conn.createStatement();
        stmt.execute(query);
        }catch(Exception e){
            System.out.print("Error en creacion");
        }
    }
    public void eliminarcliente(int id){ 
    Cliente c = new Cliente();
        try{
            Connection conn = Dao.getConnection();
            String query="delete from tb_clientes where id="+id+";";
            ps=conn.prepareStatement(query);
            ps.execute(query);
}
catch(Exception ex){

}
}
}
