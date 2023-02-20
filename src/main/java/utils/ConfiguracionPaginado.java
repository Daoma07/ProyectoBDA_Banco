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

    private int numeroPagina;
    private int elementosPorPagina;

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    //Como el offset
    public int getElementosASaltar() {
        return this.numeroPagina * this.elementosPorPagina;
    }

    public void avanzarPagina() {
        this.numeroPagina++;
    }

    public void retrocederPagina() {
        if (this.numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

}
