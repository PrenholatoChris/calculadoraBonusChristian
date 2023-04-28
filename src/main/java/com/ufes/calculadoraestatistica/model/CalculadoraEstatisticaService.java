/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.model;

import com.ufes.calculadoraestatistica.collection.DadoCollection;
import java.util.ArrayList;

/**
 *
 * @author CONEXOS
 */
public final class CalculadoraEstatisticaService {
    private final ArrayList<IOperacao> operacoes = new ArrayList();
    
    private final DadoCollection dadoCollection;
    
    public CalculadoraEstatisticaService(DadoCollection dadoCollection){
        this.dadoCollection = dadoCollection;
        
        this.operacoes.add(new MaiorOperacao());
        this.operacoes.add(new MenorOperacao());
        this.operacoes.add(new MediaOperacao());
        this.operacoes.add(new SomatorioOperacao());
        this.operacoes.add(new VarianciaOperacao());
        this.operacoes.add(new DesvioPadraoOperacao());
        
        
        for (Dado dado : this.dadoCollection.getDadoCollection()) {
            calcular(dado);
            System.out.println(dado);
        }
    }
    
    public void calcular(IDado dado){
        for (IOperacao operacao : operacoes) {
            operacao.calcular(dado);
        }
    }
}
