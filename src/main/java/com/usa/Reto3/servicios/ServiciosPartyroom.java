/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto3.servicios;

import com.usa.Reto3.modelos.Partyroom;
import com.usa.Reto3.repositorios.RepositorioPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosPartyroom {
     @Autowired
    private RepositorioPartyroom metodosCrud;

    public List<Partyroom> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Partyroom> getPartyroom(int partyroomId) {
        return metodosCrud.getPartyroom(partyroomId);
    }

    public Partyroom save(Partyroom partyroom){
        if(partyroom.getId()==null){
            return metodosCrud.save(partyroom);
        }else{
            Optional<Partyroom> e=metodosCrud.getPartyroom(partyroom.getId());
            if(e.isEmpty()){
                return metodosCrud.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }

    public Partyroom update(Partyroom partyroom){
        if(partyroom.getId()!=null){
            Optional<Partyroom> e=metodosCrud.getPartyroom(partyroom.getId());
            if(!e.isEmpty()){
                if(partyroom.getName()!=null){
                    e.get().setName(partyroom.getName());
                }
                if(partyroom.getOwner()!=null){
                    e.get().setOwner(partyroom.getOwner());
                }
                if(partyroom.getCapacity()!=null){
                    e.get().setCapacity(partyroom.getCapacity());
                }
                if(partyroom.getDescription()!=null){
                    e.get().setDescription(partyroom.getDescription());
                }
                if(partyroom.getCategory()!=null){
                    e.get().setCategory(partyroom.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return partyroom;
            }
        }else{
            return partyroom;
        }
    }


    public boolean deletePartyroom(int partyroomId) {
        Boolean aBoolean = getPartyroom(partyroomId).map(partyroom -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
