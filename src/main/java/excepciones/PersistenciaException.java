/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Clase de persistencias para los metodos de las excepciones.
 * @author Daniel & David
 */
public class PersistenciaException extends Exception{
    /**
     * Constructor por default
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de Persistencia Exception para errores que recibe el mensaje 
     * @param message mensaje
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de Persistencia Exception para errores y imprime la causa
     * @param message mensaje
     * @param cause causa
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor de Persistencia Exception para errores que solamente recibe la causa y la excusa.
     * @param cause causa
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor de Persistencia Exception para errores.
     * @param message mensaje
     * @param cause causa
     * @param enableSuppression
     * @param writableStackTrace 
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
