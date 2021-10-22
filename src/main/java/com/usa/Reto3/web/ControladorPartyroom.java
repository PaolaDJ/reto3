/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto3.web;

import com.usa.Reto3.modelos.Partyroom;
import com.usa.Reto3.servicios.ServiciosPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController //Asigna las entradas de los URLS
@RequestMapping("/api/Partyroom") //Ruta de ese controlador
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //Puerta de acceso 

// POST http:IP:PUERTO/api/Partyroom/save

public class ControladorPartyroom {
     @Autowired
    private ServiciosPartyroom servicio;
    @GetMapping("/all")
    public List<Partyroom> getPartyrooms(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int partyroomId) {
        return servicio.getPartyroom(partyroomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom partyroom) {
        return servicio.save(partyroom);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom partyroom) {
        return servicio.update(partyroom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int partyroomId) {
        return servicio.deletePartyroom(partyroomId);
    } 
}
