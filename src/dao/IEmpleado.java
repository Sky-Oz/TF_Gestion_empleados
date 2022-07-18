/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrativo;
import modelo.Empleado;
import modelo.Vendedor;

/**
 *
 * @author CASA
 */
public interface IEmpleado {
    public void agrAdministrativo(Administrativo a);
    public void agrVendedor(Vendedor v);
    public List<Empleado>lisEmpleados();
    public void borraAdm(Empleado a);
    public void borraVend(Empleado v);
    public void modificaAdm(Administrativo a);
    public void modificaVend(Vendedor v);
    public List<Empleado>filtraEmpNom(String nom);
    public List<Empleado>filtraEmpApe(String ape);
    public List<Empleado>muestraEmpCod(String cod);
    public Empleado filtraEmpCod(String cod);
    public List<Empleado>filtraEmpAdm();
    public List<Empleado>filtraEmpVen();
    
    
    
    
    
    
}
