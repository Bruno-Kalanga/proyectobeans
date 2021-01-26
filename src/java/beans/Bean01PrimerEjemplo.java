/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Kuro
 */
public class Bean01PrimerEjemplo {

    public String getSaludo() {
        return "<h1 style='color:red'>Hola Mundo</h1>";
    }

    public String getSaludo(String nombre) {
        return "<h1 style='color:blue'>Bienvenido, "
                + nombre + "</h1>";
    }
}
