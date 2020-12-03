package Controlador;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class Consulta_Historial {
    public void consultar_historial(JComboBox<String> caja, JDateChooser fecha1
    ,JDateChooser fecha2){
        String seleccion = (String)caja.getSelectedItem();
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String fecha_inicial = f.format(fecha1.getDate());
        String fecha_final = f.format(fecha2.getDate());
        
        String consulta = "SELECT * FROM "; 
    }
}
