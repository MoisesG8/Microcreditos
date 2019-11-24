/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bd.service;

import com.proyecto.bd.dao.CreditosDao;
import com.proyecto.bd.entidades.Cliente;
import com.proyecto.bd.entidades.Creditos;
import java.util.List;

/**
 *
 * @author Moisés
 */
public class UsarServicioCreditos {
     private CreditosDao creditosdao;
     
     public UsarServicioCreditos(){
         creditosdao = new CreditosDao();
}
      public void createcredit(Creditos c){
        if(c==null)
            throw new NullPointerException("Credito NO PUEDE SER NULL");
        creditosdao.addcredito(c);
    }
       public List<Cliente> getAllCreditos(){
        return creditosdao.getAllCreditos();
    }
}
