package negocio;

import dao.DAOSueldo;
import modelo.Empleado;

//Clase decoradora de calculo descuentos
public class Descuentos extends CalculoDecorator{
    
    
    //Constructor parametrizado
    public Descuentos(Calculo nuevoCalculo) {
        super(nuevoCalculo);        
    }
       
    
    public double resultado(Empleado e){   
        DAOSueldo sue = new DAOSueldo();
        Double sueldo=e.getSbase(),totsueldos,result,montdesc;
        //Calcula meses trabajados y lo guarda en la variable
        int mesest=mesesTrabajados(e.getFcontrat(),e.getFcese());
        //Calcula
        totsueldos=mesest*sueldo;
        montdesc=e.seguro()*totsueldos;        
        result=montdesc;
        sue.grabaDes(Math.round(result*100)/100.0);
        
        
        return tempCalculo.resultado(e) - result;
    }
    
    public String salida(Empleado e){
        Double totsueldos=mesesTrabajados(e.getFcontrat(),e.getFcese())*e.getSbase();
        String cadena="";        
        cadena=""+
            " "+"\n"+
	"-------------------------------------------------------------"+"\n"+
        "Monto total desc: "+Math.round((e.seguro()*totsueldos)*100)/100.0+"\n"+	
	" ";        
        
        return tempCalculo.salida(e) + cadena;
    }
    
    
    
    
}
