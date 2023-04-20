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
public class CalculadoraEstatisticaService {
    ArrayList<IOperacao> operacoes;
    
    public CalculadoraEstatisticaService(){
        this.operacoes.add(new MaiorOperacao());
        this.operacoes.add(new MenorOperacao());
        this.operacoes.add(new MediaOperacao());
        this.operacoes.add(new SomatorioOperacao());
        this.operacoes.add(new VarianciaOperacao());
        this.operacoes.add(new DesvioPadraoOperacao());
    }
    
    public void calcular(IDado dado){
        for (IOperacao operacao : operacoes) {
            operacao.calcular(dado);
        }
    }
}
