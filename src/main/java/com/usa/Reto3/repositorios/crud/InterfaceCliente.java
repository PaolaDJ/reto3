/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.Reto3.repositorios.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.Reto3.modelos.Cliente;
/**
 *
 * @author Paola DJ
 */
public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
    
}
