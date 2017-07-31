/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.control;

import com.mycompany.dao.AvionFacade;
import com.mycompany.entidad.Avion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class AvionControl implements Serializable {

    @EJB
    private AvionFacade avionFacade;
    
    List<Avion> aviones;
    
    
    public AvionControl() {
    }

    public List<Avion> getAviones() {
        return avionFacade.findAll();
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }
    
    
}
