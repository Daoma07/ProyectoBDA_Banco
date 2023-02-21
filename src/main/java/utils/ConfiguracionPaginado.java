/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author HP
 */
public class ConfiguracionPaginado {
    
    //Atributros de clase privados
    private int numeroPagina;
    private int elementosPorPagina;

    /**
     * Constructor que se inicializa por default el numero de pagina y los elementos por pagina a mostrar
     */
    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    /**
     * Constructor que inicializa el numero de pagina y los elementos por pagina a mostrar
     * @param numeroPagina numnero de pagagina
     * @param elementosPorPagina Elementos por pagina a mostrar.
     */
    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Metodo Get que obtiene el numero de pagina actual
     * @return numero de pagina
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Metodo Set que setea el numero de pagina
     * @param numeroPagina numero de pagina
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    /**
     * Metodo Get que obtiene los elementos por pagina.
     * @return Numero de elementos por pagina.
     */
    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    /**
     * Metodo Set que ayuda a setear los elementos por pagina
     * @param elementosPorPagina elementos por pagina
     */
    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Metodo Get tipo Offset que ayuda a saltar los elementos de la pagina haciendo retornando el numero de paginas por los elementos de la pagina,
     * @return numero de pagina * elementos por pagina.
     */
    //Como el offset
    public int getElementosASaltar() {
        return this.numeroPagina * this.elementosPorPagina;
    }

    /**
     * Metodo que avanza de pagina.
     */
    public void avanzarPagina() {
        this.numeroPagina++;
    }

    /**
     * Metodo que retrocede la pagina.
     */
    public void retrocederPagina() {
        if (this.numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

}
