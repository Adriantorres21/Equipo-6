package Controlador;

/**
 *
 * @author smspr
 */
public class Comparar_campos {
    public boolean esNumero(String numeros){
        try {
		Integer.parseInt(numeros);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
