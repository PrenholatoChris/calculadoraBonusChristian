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
public class MaiorOperacao implements IOperacao {
    @Override
    public void calcular(IDado dado){
        ArrayList<Double> lista = dado.getDados();
        
        double maior = lista.get(0);
        double it;
        for(int i=0; i< lista.size(); i++){
            it = lista.get(i);
            if(it > maior){
                maior = it;
            }
       }
        
        dado.add(new Resultado("Maior", maior));
    }
}
