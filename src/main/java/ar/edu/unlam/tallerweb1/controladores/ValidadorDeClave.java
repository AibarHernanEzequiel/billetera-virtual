package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ClaveInvalidaException;
import ar.edu.unlam.tallerweb1.excepciones.ClavesNoCoincidentesException;

public class ValidadorDeClave {
    public static boolean validarClave(String clave) throws ClaveInvalidaException {
        if (contieneMayusculas(clave) && contieneNumeros(clave))
        {
            return true;
        }
        throw new ClaveInvalidaException();
    }

    private static boolean contieneMayusculas(String clave) {
        for (int i = 0; i < clave.length(); i++)
        {
            if (Character.isUpperCase(clave.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean contieneNumeros(String clave) {
        for (int i = 0; i < clave.length(); i++) {
            if (Character.isDigit(clave.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validarClaveYRepiteClave(String clave, String repiteClave) throws ClavesNoCoincidentesException {
        if (clave.equals(repiteClave))
        {
            return true;
        }
        throw new ClavesNoCoincidentesException();
    }
}
