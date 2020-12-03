/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.io.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Adrian
 */
public class GenerarPDF {

    public static final String ruta = "C:\\Users\\Adrian\\Desktop\\mipdf.pdf";

    public void createPDF(String r, JTable vPrevia,String fInicial,String fFinal) throws IOException {
        // Aquí introduciremos el código pa ra crear el PDF.
        String logo = "src/Imagenes/LogoPanaderiaKaren.png";
        PdfWriter writer = new PdfWriter(r);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf,PageSize.A4.rotate());
        Image img = new Image(ImageDataFactory.create(logo));
        img.scaleToFit(150, 150);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont fontBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
        Paragraph p = new Paragraph().add(img);

        p.setTextAlignment(TextAlignment.CENTER);
        p.add("\n");
        p.add("REPORTE\n").setFont(font).setFontSize(18);
        Paragraph pa2 = new Paragraph();
        pa2.add("Fecha inicial: "+fInicial+"\n");
        pa2.add("Fecha Final: "+fFinal);

        Table table = new Table(new float[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4});
        llenarTabla(vPrevia, table);
        
        doc.add(p);
        doc.add(pa2);
        doc.add(table);
        doc.close();

        try {
            File path = new File(r);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void llenarTabla(JTable vPrevia,Table tb){
        //Generacion de tabla para reporte
        TableModel modelo = vPrevia.getModel();
        int col = modelo.getColumnCount();
        int fila = modelo.getRowCount();
        for (int h = 0; h < col; h++) {
            tb.addHeaderCell(new Cell().add(new Paragraph(modelo.getColumnName(h))));
        }
        
        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < col; c++) {
                tb.addCell(new Cell().add(new Paragraph(
                        String.valueOf(modelo.getValueAt(f, c)))));
            }
        }
    }
}
