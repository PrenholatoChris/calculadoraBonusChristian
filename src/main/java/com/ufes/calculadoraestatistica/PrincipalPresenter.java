/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica;

import com.ufes.calculadoraestatistica.collection.DadoCollection;
import com.ufes.calculadoraestatistica.model.CalculadoraEstatisticaService;
import com.ufes.calculadoraestatistica.service.ImportarArquivoService;
import com.ufes.calculadoraestatistica.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author CONEXOS
 */
public class PrincipalPresenter {
    DadoCollection dadoCollection;
    
    public PrincipalPresenter(){
        dadoCollection = new DadoCollection();
        
        PrincipalView view = new PrincipalView(dadoCollection);
        
        view.getJMenuitem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dadoCollection = new DadoCollection();
                ImportarArquivoService xml = new ImportarArquivoService(dadoCollection);
            }
        });
        
        
         view.getJMenuitem2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(dadoCollection.getDadoCollection().isEmpty()){
                    JOptionPane.showMessageDialog(view, "É necessário importar os dados");
                    return;
                }
                try{
                    CalculadoraEstatisticaService calculadora = new CalculadoraEstatisticaService (dadoCollection);
                    ResultadosCalculosEstatisticosPresenter resultadoCalculoPresenter = new ResultadosCalculosEstatisticosPresenter(dadoCollection, new Date());
                }
                catch (Exception x){
                    JOptionPane.showMessageDialog(view, "Erro ao realizar os calculso estatísticos:\n" + x.getMessage());
                }
            }
            
        });
        
       view.getJMenuitem3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                 ResultadosCalculosEstatisticosPresenter resultadoCalculoPresenter = new ResultadosCalculosEstatisticosPresenter(dadoCollection, new Date());
            }
        });
        
    }
}   
