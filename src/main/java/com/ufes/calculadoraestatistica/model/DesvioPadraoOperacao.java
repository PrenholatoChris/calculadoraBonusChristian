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
public class DesvioPadraoOperacao implements IOperacao {
    @Override
    public void calcular(IDado dado){
        double media = 0;
        
        ArrayList<Double> lista = dado.getDados();
        for(int i=0; i< lista.size(); i++){
            media += lista.get(i);
       }
        media = media/lista.size();
        
        double variancia = 0;
        for(int i=0; i< lista.size(); i++){
            variancia += lista.get(i) - media;
       }
       variancia = variancia/lista.size();
       
       double desvio = Math.sqrt(variancia);
       
       dado.add(new Resultado("Desvio Padrão", desvio));
    }
}