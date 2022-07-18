/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Asistencia;

/**
 *
 * @author CASA
 */
public interface IAsistencia {
    public Asistencia validaAsis(String cod);
    public void regAsistencia(Asistencia a);
    
    
}
