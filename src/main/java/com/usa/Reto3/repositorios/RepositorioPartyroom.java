/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto3.repositorios;

import com.usa.Reto3.modelos.Partyroom;
import com.usa.Reto3.repositorios.crud.InterfacePartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioPartyroom {
    
    @Autowired
    private InterfacePartyroom crud;

    public List<Partyroom> getAll(){
        return (List<Partyroom>) crud.findAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return crud.findById(id);
    }

    public Partyroom save(Partyroom partyroom){
        return crud.save(partyroom);
    }
    public void delete(Partyroom partyroom){
        crud.delete(partyroom);
    }
    
}
