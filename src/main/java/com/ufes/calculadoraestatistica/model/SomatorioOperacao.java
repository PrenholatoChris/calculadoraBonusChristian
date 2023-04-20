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
public class SomatorioOperacao  implements IOperacao {
    @Override
    public void calcular(IDado dado){
        ArrayList<Double> lista = dado.getDados();
        
        double total = 0;
        
        for(int i=0; i< lista.size(); i++){
            total += lista.get(i);
       }
        
        dado.add(new Resultado("Somatório", total));
    }
}
