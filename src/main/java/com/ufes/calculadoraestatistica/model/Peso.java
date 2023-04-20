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
public class Peso implements IDado{
    public ArrayList<Double> dados;
    public ArrayList<Resultado> resultados;

    public Peso(ArrayList<Double> dados) {
        this.dados = dados;
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
        for (Resultado resul : resultados) {
            str += resul.getNome() + ": " + resul.getValor();
        }
        return str;
    }

}