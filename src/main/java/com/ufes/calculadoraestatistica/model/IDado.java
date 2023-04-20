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
public interface IDado {
    //ArrayList<Double> dados;
    
    
    public void setDados( ArrayList<Double> dados);
    public void add(Double dado);
    public ArrayList<Double> getDados();
    
    public void add(Resultado resultado);
    public ArrayList<Resultado> getResultados();
    
    @Override
    String toString();
    
}
