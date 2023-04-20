/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica.model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;

/**
 *
 * @author CONEXOS
 */
public class ReadXML {
    
    private Document doc;
    
    public ReadXML(String path){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.doc = builder.parse(new File(path));
            this.doc.getDocumentElement().normalize();
        } catch (SAXException | IOException | ParserConfigurationException  ex) {
            Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Double> getData(){
        NodeList nodeList = this.doc.getElementsByTagName("dado");
        Element dadoNode;
        ArrayList<Double> valores = new ArrayList();
        Double valor;
        for (int i = 0; i < nodeList.getLength(); i++) {
            dadoNode = ((Element)(nodeList.item(i)));
            NodeList valoresNodeList = dadoNode.getElementsByTagName("valor");
            for (int j = 0; j < valoresNodeList.getLength(); j++) {
                valor = Double.valueOf(valoresNodeList.item(j).getTextContent());
                valores.add(valor);
            }

        }
        
        return valores;
        
    }    
    
}
