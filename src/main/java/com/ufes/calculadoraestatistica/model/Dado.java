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
public class Dado implements IDado{
    public ArrayList<Double> dados;
    public ArrayList<Resultado> resultados;

    public Dado(ArrayList<Double> dados) {
        this.dados = dados;
        this.resultados = new ArrayList();
    }

    @Override
    public ArrayList<Double> getDados() {
        return dados;
    }
    
    @Override
    public void setDados(ArrayList<Double> dados){
        this.dados = dados;
    }
    
    @Override
    public void add(Double dado) {
        if(dado == null){
            return;
        }
        dados.add(dado);
    }

    @Override
    public void add(Resultado resultado) {
        if(resultado == null){
            return;
        }
        resultados.add(resultado);
    }

    @Override
    public ArrayList<Resultado> getResultados() {
        return resultados;
    }
    
    @Override
    public String toString(){
        String str = new String();
        str += "A lista = [";
        
        for (Double item :dados){
            str += Double.toString(item) + ", ";
        }
        str += "] possui os seguintes resultados.\n";
        for (Resultado resul : resultados) {
            str += resul.getNome() + ": " + resul.getValor() + " - ";
        }
        return str;
    }

}