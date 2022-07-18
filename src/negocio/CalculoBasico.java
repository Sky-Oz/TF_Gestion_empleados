
package negocio;

import modelo.Administrativo;
import modelo.Empleado;


public class CalculoBasico implements Calculo{      

    

    @Override
    public double resultado(Empleado e) {        
        return 1;
    }
    
    @Override
    public String salida(Empleado e) {
        String cadena,tbono;    
        //Si es personal administrativo
        if(e instanceof Administrativo){
            tbono="Horas extra";
        }else{
            tbono="Pasajes + comision de ventas";
        }
        
        cadena=""+
            " "+"\n"+
	"-------------------------------------------------------------"+"\n"+
        "Empleado: "+e.getNome()+" "+e.getApe()+"\n"+
        "DNI: "+e.getDni()+"\n"+	
	"Código: "+e.getCode()+"\n"+
	"Puesto: "+e.getNpuesto()+"\n"+
	"Tipo de empleado: "+e.getTpuesto()+"\n"+
	"Tipo de bono: "+tbono+"\n"+
	"Tipo de seguro: "+e.getTseg()+"\n"+
	"Sueldo mensual asignado: "+e.getSbase()+"\n"+
	" ";
        
        return cadena;
    }   
}
