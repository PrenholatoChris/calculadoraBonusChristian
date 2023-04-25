/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.service;

import com.ufes.calculadoraestatistica.collection.DadoCollection;
import com.ufes.calculadoraestatistica.model.Dado;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;


import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CONEXOS
 */
public final class ImportarArquivoService {
    
    private Document doc;
    private DadoCollection dadoCollection;
    private JFileChooser chooser;
    
    public ImportarArquivoService(DadoCollection dadoCollection){
        this.dadoCollection = dadoCollection;
        
        try {
            //this.openExplorer();
            File file = javaExplorer();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.doc = builder.parse(file);
            this.doc.getDocumentElement().normalize();
            
        } catch (SAXException | IOException | ParserConfigurationException  ex) {
            Logger.getLogger(ImportarArquivoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        addXMLtoCollection();
        
        JOptionPane.showMessageDialog(chooser, "XML importado com sucesso");
    }
    
    public void addXMLtoCollection(){
        NodeList nodeList = this.doc.getElementsByTagName("dado");
        Element dadoNode;
        ArrayList<Double> valores ;
        Double valor;
        for (int i = 0; i < nodeList.getLength(); i++) {
            valores = new ArrayList();
            dadoNode = ((Element)(nodeList.item(i)));
            NodeList valoresNodeList = dadoNode.getElementsByTagName("valor");
            for (int j = 0; j < valoresNodeList.getLength(); j++) {
                valor = Double.valueOf(valoresNodeList.item(j).getTextContent());
                valores.add(valor);
            }
            dadoCollection.add(new Dado(valores));
        }
    }
    
    public File javaExplorer(){
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "XML files", "xml");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        
        if(returnVal != JFileChooser.APPROVE_OPTION) {           
            System.out.println("Erro ao usar arquivo!");
        }
        File file = chooser.getSelectedFile();
        return file;                
    }
    
}
