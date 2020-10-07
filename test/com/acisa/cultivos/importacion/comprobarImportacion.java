/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acisa.cultivos.importacion;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jcperan
 */
public class comprobarImportacion {
    
    public comprobarImportacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void comprobarImportacion() {
        
        Integer i = 25296;
        
        List<String> listaCultivos = new ArrayList<String>();
        List<String> listaPlagas = new ArrayList<String>();
        
        ObtenerCultivos cultivos = new ObtenerCultivos();
        cultivos.procesarCultivos(listaCultivos);
        
        ObtenerPlagas plagas = new ObtenerPlagas();
        plagas.procesarPlagas(listaPlagas);
        
        DocumentoPDF documentoPDF = new DocumentoPDF();
        if (documentoPDF.obtenerPDF(String.format("%1$05d", i))) {
            if (documentoPDF.isFolio()) {
                ProcesarFolio proceso = new ProcesarFolio(i, documentoPDF, listaCultivos, listaPlagas);
                System.out.println(proceso);
            } else {
                ProcesarRegistro proceso = new ProcesarRegistro(i, documentoPDF.getTextoPDF());
                System.out.println(proceso);
            }
            i=1;
        } else {
            if (documentoPDF.obtenerPDF("ES-" + String.format("%1$05d", i))) {
                if (documentoPDF.isFolio()) {
                    ProcesarFolio proceso = new ProcesarFolio(i, documentoPDF, listaCultivos, listaPlagas);
                    System.out.println(proceso);
                } else {
                    ProcesarRegistro proceso = new ProcesarRegistro(i, documentoPDF.getTextoPDF());
                    System.out.println(proceso);
                }
                i=1;
            }
        }
    }
    
}
