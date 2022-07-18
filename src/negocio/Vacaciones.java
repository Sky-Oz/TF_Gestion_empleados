
package negocio;

import dao.DAOSueldo;
import modelo.*;

//Clase decoradora calculo vacaciones
public class Vacaciones extends CalculoDecorator{
    
    
    //Constructor parametrizado
    public Vacaciones(Calculo nuevoCalculo) {
        super(nuevoCalculo);        
    }
    
    public double resultado(Empleado e){
        DAOSueldo sue = new DAOSueldo();
        //variables remuneracion computado, vacaciones truncas y resultado
        Double rc=e.getSbase(),vc,result;
        //Calcula los días trabajados
        int diaslab=diasTrabajados(e.getFcontrat(), e.getFcese());
        //Calcula
        vc=rc/360*diaslab;
        result=Math.round(vc*100)/100.0;
        sue.grabaVac(result);
        
        return tempCalculo.resultado(e) + result;
    }    
    
    
    public String salida(Empleado e){        
        String cadena="";   
        Double rc=e.getSbase();
        //Calcula los días trabajados
        int diaslab=diasTrabajados(e.getFcontrat(), e.getFcese());
            cadena=""+
                " "+"\n"+
            "-------------------------------------------------------------"+"\n"+
            "Total de días laborados: "+diaslab+"\n"+
            "Monto de vacaciones truncas: "+Math.round((rc/360*diaslab)*100)/100.0+"\n"+
            " ";
            
        return tempCalculo.salida(e) + cadena;
    }
    
    
    
    
    
    
}