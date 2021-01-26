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
public class Bean02TablaMultiplicar {

    public String getTabla(int numero) {
        String html = "<table border='5'>";
        html += "<tr>";
        html += "<th>Operacion</th>";
        html += "<th>Resultado</th>";
        html += "</tr>";
        for (int i = 1; i <= 10; i++) {
            String operacion = numero + " x " + i;
            int resultado = numero * i;

            html += "<tr>";
            html += "<td>" + operacion + "</td>";
            html += "<td>" + resultado + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
}
