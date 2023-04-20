/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.model;

import java.util.ArrayList;

/**
 *
 * @author CONEXOS
 */
public class MenorOperacao implements IOperacao{
    
    @Override
    public void calcular(IDado dado){
        ArrayList<Double> lista = dado.getDados();
        
        double menor = lista.get(0);
        double it;
        for(int i=0; i < lista.size(); i++){
            it = lista.get(i);
            if(it < menor){
                menor = it;
            }
       }
        
        dado.add(new Resultado("Menor", menor));
    }
}
