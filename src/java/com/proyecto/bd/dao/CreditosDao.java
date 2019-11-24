/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.dao;

import com.proyecto.bd.entidades.Cliente;
import com.proyecto.bd.entidades.Creditos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moisés
 */
public class CreditosDao {
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt =null;
    public void addcredito(Creditos campos){
        //boolean respuesta = false;
        try{
        Connection conn = Dao.getConnection();       
        String query="INSERT INTO `dbmicrocredits`.`tb_creditos`(`fechainicio`,`fechafin`,`id_cliente`,`estado`,`pagado`,`prestamo`,`porcentajeinteres`) VALUES ('"+campos.getFechainicio()+"','"+campos.getFechafin()+"','"+campos.getId_cliente()+"','"+campos.getEstado()+"','"+campos.getPagado()+"','"+campos.getPrestamo()+"','"+campos.getPorcentajeinteres()+"');";
        stmt=conn.createStatement();
        stmt.execute(query);
        }catch(Exception e){
            
        }
    }
    
      public List <Cliente> getAllCreditos(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            
            Connection conn = Dao.getConnection();
            String querito="SELECT id, nombre, apellidos, dpi, email, prestamo, fechainicio\n" +
            "FROM tb_creditos\n" +
            "inner join tb_clientes \n" +
            "on \n" +
            "tb_creditos.id_cliente= tb_clientes.id\n" +
            "where tb_creditos.id_credito";     
            ps= conn.prepareStatement(querito);
            rs=ps.executeQuery();
            Cliente c;
            Creditos cr;
            while(rs.next())
            {
              cr=new Creditos();  
              c =new Cliente();
              c.setId(rs.getInt("id"));
              c.setNombre(rs.getString("nombre"));
              c.setApellidos(rs.getString("apellidos"));
              c.setDpi(rs.getString("dpi"));
              c.setEmail(rs.getString("email"));
              c.setPrestamo(rs.getInt("prestamo"));
              c.setFechainicio(rs.getString("fechainicio")); 
              clientes.add(c);    
            }
            
        }catch(Exception e){
            
        }
        return clientes;
    }
}
