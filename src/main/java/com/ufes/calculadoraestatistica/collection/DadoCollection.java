/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.collection;

import com.ufes.calculadoraestatistica.model.Dado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author CONEXOS
 */
public class DadoCollection {
    
    ArrayList<Dado> dadoCollection;
    
    public DadoCollection(){
        dadoCollection = new ArrayList<>();
    }
    
    public void add(Dado dado){
        if(dadoCollection.contains(dado)){
            throw new RuntimeException("Dado ja existe!");
        }
        
        if(dado != null){
            dadoCollection.add(dado);
        }
        else{
            throw new RuntimeException("Instância de Dado inválida");
        }
    }
    
    public List<Dado> getDadoCollection(){
        return Collections.unmodifiableList(dadoCollection);
    }
}
