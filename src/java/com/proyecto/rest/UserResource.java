/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.rest;

import com.google.gson.Gson;
import com.proyecto.bd.entidades.Cliente;
import com.proyecto.bd.entidades.Creditos;
import com.proyecto.bd.entidades.Libros;
import com.proyecto.bd.service.UsarServicio;
import com.proyecto.bd.service.UsarServicioCreditos;
import com.proyecto.bd.service.UsarServicioLibro;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author Moisés
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    
    public UserResource() {
    }
   
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
       try{
           List<Cliente> clientes = new UsarServicio().getAll();
         
           String json = new Gson().toJson(clientes);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       }  
    }
    @GET
    @Path("alllibros")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibros() {
       try{
          
              List<Libros> libro = new UsarServicioLibro().getallLibros();
           //List<Libros> libro = new UsarServicioLibro.getallLibros();
            String json = new Gson().toJson(libro);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       }  
    }
    @POST
    @Path("addLibro")
   // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addLibro(String json) {
        try{
            Gson gson = new Gson();
            Libros l = gson.fromJson(json, Libros.class);
            UsarServicioLibro service = new UsarServicioLibro();
            service.create(l);
            String respuesta=String.valueOf(l.getTitulo()+" "+l.getEditorial());
        }catch(Exception e){
            
        }

    }
    
    @GET
    @Path("allcredits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCredit() {
       try{
           List<Cliente> clientes = new UsarServicioCreditos().getAllCreditos();
           String json = new Gson().toJson(clientes);
           
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       }  
    }
    @GET
    @Path("cliente/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("nombre")String nombres){
     // Cliente c = new Cliente();
        try{
           Cliente clientes = new UsarServicio().get(nombres);
           String json = new Gson().toJson(clientes);
           return Response.ok(json, MediaType.APPLICATION_JSON).build();
       }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
       } 
    }
    
    @POST
    @Path("add")
   // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCliente(String json) {
        try{
            Gson gson = new Gson();
            Cliente c = gson.fromJson(json, Cliente.class);
            UsarServicio service = new UsarServicio();
            service.create(c);
            String respuesta=String.valueOf(c.getNombre()+" "+c.getApellidos()+" "+c.getDpi()+" "+c.getDireccion()+" "+c.getTelefono()+" "+c.getEdad()+" "+c.getEmail());
        }catch(Exception e){
            
        }

    }
    @POST
    @Path("addcredito")
   // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCredito(String json) {
        try{
            Gson gson = new Gson();
            Creditos c = gson.fromJson(json, Creditos.class);
            Cliente cl = gson.fromJson(json, Cliente.class);
            UsarServicioCreditos service = new UsarServicioCreditos();
            service.createcredit(c);
            String respuesta=String.valueOf(c.getFechainicio()+" "+c.getFechafin()+" "+cl.getId()+" "+c.getEstado()+" "+c.getPagado()+" "+c.getPrestamo()+" "+c.getPorcentajeinteres());
        }catch(Exception e){
             Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }

    }
    @DELETE
    @Path("eliminarlibro/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteL(@PathParam("id")int id){
        try{
            Cliente c = new Cliente();
           // c.setId(id);
            UsarServicioLibro services = new UsarServicioLibro();
            services.eliminar(id);
            String json="(\"id\":\""+c.getId()+"\"}";
            Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){
            Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }
    }
     @DELETE
    @Path("eliminar/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteC(@PathParam("id")int id){
        try{
            Cliente c = new Cliente();
           // c.setId(id);
            UsarServicio services = new UsarServicio();
            services.eliminar(id);
            String json="(\"id\":\""+c.getId()+"\"}";
            Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){
            Response.status(Response.Status.SEE_OTHER).entity("Error: "+e.toString()).build();
        }
    }
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String actualizaC(String json){
         try{
             Gson gson=new Gson();
             Cliente cliente=gson.fromJson(json,Cliente.class);
             UsarServicio service=new UsarServicio();
             service.update(cliente);
             return cliente.getId()+" "+cliente.getNombre()+" "+cliente.getApellidos()+" "
                     +cliente.getDpi()+" "+cliente.getDireccion()+" "+cliente.getTelefono()+" "
                    +cliente.getEdad()+" "+cliente.getEmail();
         }catch(Exception e){
             
         }
         return "";
    }
}
