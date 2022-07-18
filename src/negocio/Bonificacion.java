package negocio;

import modelo.*;
import dao.DAOSueldo;

//Decorador bonificacion
public class Bonificacion extends CalculoDecorator{
    DAOSueldo sue = new DAOSueldo();    
    

    
    //Constructor parametrizado
    public Bonificacion(Calculo nuevoCalculo) {
        super(nuevoCalculo);
        
        
        
    }
    
    public double resultado(Empleado e){
        Double sueldo=e.getSbase(), result;
        result=e.bonificacion();
        //result=sueldo+bono;        
        sue.grabaBon(Math.round(result*100)/100.0);
        
        return tempCalculo.resultado(e) + result;
    }    
    
    public String salida(Empleado e){
        String cadena="";
        //Si es personal administrativo
        if(e instanceof Administrativo){
            cadena=""+
                " "+"\n"+
            "-------------------------------------------------------------"+"\n"+
            "Horas extras realizadas: "+((Administrativo) e).getHextras()+"\n"+
            "Monto bonificacion hh.ee.: "+Math.round(e.bonificacion()*100)/100.0+"\n"+
            " ";
        //Si es personal de ventas
        }else if(e instanceof Vendedor){
            cadena=""+
                " "+"\n"+
            "-------------------------------------------------------------"+"\n"+
            "Monto de venta realizada: "+((Vendedor) e).getMventas()+"\n"+
            "Monto bonificacion comision: "+Math.round(e.bonificacion()*100)/100.0+"\n"+
            " ";
        }         
        return tempCalculo.salida(e) + cadena;
    }

 
    
    
    
    
    
}