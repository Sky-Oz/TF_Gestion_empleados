/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.Empleado;

/**
 *
 * @author CASA
 */
public interface Calculo {    
    public double resultado(Empleado e);
    public String salida(Empleado e);
    
}
