/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica;

import com.ufes.calculadoraestatistica.collection.DadoCollection;
import com.ufes.calculadoraestatistica.model.Dado;
import com.ufes.calculadoraestatistica.model.Resultado;
import com.ufes.calculadoraestatistica.view.ResultadosCalculosEstatisticosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

/**
 *
 * @author CONEXOS
 */
public class ResultadosCalculosEstatisticosPresenter {
    private ResultadosCalculosEstatisticosView view;
    private DadoCollection dadoCollection;
    private ArrayList<Resultado> resultados;
    private DefaultTableModel tmResultados;
    
    public ResultadosCalculosEstatisticosPresenter(DadoCollection dadoCollection, Date dataFilter){
        System.out.println("aldasdas");
        this.dadoCollection = dadoCollection;
        this.resultados = new ArrayList<Resultado>();
        
        view = new ResultadosCalculosEstatisticosView(dadoCollection);
        
        tmResultados = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Calculo","Valor"}
        );
        
        view.getTblResultados().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmResultados.setNumRows(0);
        
        for (Dado dado : dadoCollection.getDadoCollection()) {
            for(Resultado resultado : dado.getResultados()){
                if(resultado.getData().equals(dataFilter)){
                    this.resultados.add(resultado);
                }
            }
        }
        
        ListIterator<Resultado> it = resultados.listIterator();
        
        while(it.hasNext()){
            Resultado resultado = it.next();
            tmResultados.addRow(new Object[]{
                resultado.getNome(),
                resultado.getValor()    
            });
        }
        
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        view.setVisible(true);
    }
    
    private void fechar(){
        view.dispose();
    }
    
}
