
package negocio;


import dao.DAOSueldo;
import modelo.*;

//Clase decoradora de calculo CTS
public class CTS extends CalculoDecorator{
    
    
    //Constructor parametrizado
    public CTS(Calculo nuevoCalculo) {
        super(nuevoCalculo);  
        
    }
    
    public double resultado(Empleado e){
        DAOSueldo sue = new DAOSueldo();
        int mesest=mesesTrabajados(e.getFcontrat(),e.getFcese());
        //totalsuedos=mesestrab*sueldobase        
        Double totsueldos=mesest*e.getSbase();
        Double sueldo=e.getSbase(), essalud=0.09;
        //Calculo monto essalud
        Double messalud=sueldo*essalud;
        Double grati=0.0,porcgrati,gratidiv,temp,monto,result;
        //Calculando la grati segun su formula
        if(mesest<6){            
            grati=sueldo/4+messalud;
        }else if(mesest>=6){
            porcgrati=(double)mesest/6;
            grati=sueldo*porcgrati;
        }
        gratidiv=grati/6;
        temp=(sueldo+gratidiv)/360;
        monto=temp*180;       
        
        result=Math.round((totsueldos+monto)*100)/100.0;
        sue.grabaCts(Math.round(totsueldos*100)/100.0, e.getFcese(), mesest, result, fechaHoy());
        
        
        return tempCalculo.resultado(e) + result;
    }    
    
    public String salida(Empleado e){
        int mesest=mesesTrabajados(e.getFcontrat(),e.getFcese());
        Double totsueldos=mesesTrabajados(e.getFcontrat(),e.getFcese())*e.getSbase();
        Double sueldo=e.getSbase(), essalud=0.09;
        Double messalud=sueldo*essalud;
        Double grati=0.0,porcgrati,gratidiv,temp,monto,result;
        if(mesest<6){            
            grati=sueldo/4+messalud;
        }else if(mesest>=6){
            porcgrati=(double)mesest/6;
            grati=sueldo*porcgrati;
        }
        gratidiv=grati/6;
        temp=(sueldo+gratidiv)/360;
        monto=temp*180;           
        String cadena="";        
        cadena=""+
            " "+"\n"+
	"-------------------------------------------------------------"+"\n"+
        "F. Contrat.: "+e.getFcontrat()+"\n"+
        "F. Cese: "+e.getFcese()+"\n"+	
	"Total meses trabajados: "+mesesTrabajados(e.getFcontrat(),e.getFcese())+"\n"+
	"Monto total sueldos: "+Math.round(totsueldos*100)/100.0+"\n"+        
	"Monto total CTS: "+Math.round(monto*100)/100.0+"\n"+	
	" ";
        
        return tempCalculo.salida(e) + cadena;
    }    
    
}