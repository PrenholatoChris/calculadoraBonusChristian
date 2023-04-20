/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes.calculadoraestatistica;

import com.ufes.calculadoraestatistica.model.CalculadoraEstatisticaService;
import com.ufes.calculadoraestatistica.model.Dado;
import com.ufes.calculadoraestatistica.model.ReadXML;
import java.util.ArrayList;
/**
 *
 * @author CONEXOS
 */
public class CalculadoraEstatistica {

    public static void main(String[] args) {
        
        ArrayList<Double> lista = new ArrayList();
        lista.add(1.5);
        lista.add(5.9);
        lista.add(9.1);
        lista.add(8.22);
        lista.add(7.7);
        Dado dado = new Dado(lista);
        
        CalculadoraEstatisticaService calculadora = new CalculadoraEstatisticaService();
        calculadora.calcular(dado);
        System.out.println(dado);
        
        
        ReadXML xml = new ReadXML("../valores.xml");
        ArrayList<Double> lista2 = xml.getData();
        Dado dado2 = new Dado(lista2);
        calculadora.calcular(dado2);
        System.out.println(dado2);
    }

}