/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.entidades;

import java.util.Date;



/**
 *
 * @author Moisés
 */
public class Creditos {
    private int id_creditos;
    private String fechainicio;
    private String fechafin;
    private int id_cliente;
    private String estado;
    private float pagado;
    private int prestamo;
    private int porcentajeinteres;
    public Creditos(int id_creditos, String fechainicio, String fechafin, int id_cliente, String estado, float pagado, int prestamo, int porcentajeinteres) {
        this.id_creditos = id_creditos;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.id_cliente = id_cliente;
        this.estado = estado;
        this.pagado = pagado;
        this.prestamo = prestamo;
        this.porcentajeinteres = porcentajeinteres;
    }
    public Creditos(){
        
    }

    public int getId_creditos() {
        return id_creditos;
    }

    public void setId_creditos(int id_creditos) {
        this.id_creditos = id_creditos;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPagado() {
        return pagado;
    }

    public void setPagado(float pagado) {
        this.pagado = pagado;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    public int getPorcentajeinteres() {
        return porcentajeinteres;
    }

    public void setPorcentajeinteres(int porcentajeinteres) {
        this.porcentajeinteres = porcentajeinteres;
    }


 
}
