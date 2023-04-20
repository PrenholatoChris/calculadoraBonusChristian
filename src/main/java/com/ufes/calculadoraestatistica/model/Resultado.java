/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.model;

import java.util.Date;

/**
 *
 * @author CONEXOS
 */
public class Resultado {
    private final String nome;
    private final Double valor;
    private Date data;
    
    public Resultado(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
        this.data =  new Date();
    }
    
    public String getNome(){
        return this.nome;
    }

    public Date getData(){
        return this.data;
    }
    
    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Resultado da operacao: " + this.nome + " = " + Double.toString(valor);
    }
}
