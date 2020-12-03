/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.*; 
/**
 *
 * @author Adrian
 */
public class GenerarPDF {
    public static final String ruta = "C:\\Users\\Adrian\\Desktop\\mipdf.pdf";
    
    public void createPDF(String r) throws IOException{
        // Aquí introduciremos el código pa ra crear el PDF.
        PdfWriter writer = new PdfWriter(r);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        doc.add(new Paragraph("PDF panaderia Karen"));
        doc.close();
        
    }
    
    public static void main(String[] args) throws IOException {
        new GenerarPDF().createPDF(ruta);
    }
}
