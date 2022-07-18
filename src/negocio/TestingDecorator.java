package negocio;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import modelo.*;



public class TestingDecorator {


    public static void main(String[] args) {
        //Calculo calculohaberes = new Descuentos(new CTS(new CalculoBasico()));
        //Calculo calculohaberes = new Descuentos(new CalculoBasico()); 
        Administrativo emp=new Administrativo();
        emp.setApe("Castellanos");
        emp.setNome("Axl");
        emp.setSexo("M");
        emp.setFnac("20-04-1992");
        emp.setLnac("Cercado de Lima");
        emp.setGestud("Superior técnico");
        emp.setMail("axl_2092@hotmail.com");
        emp.setDir("Jr. Gonzales Prada");
        emp.setNpuesto("Asistente de Informática");
        emp.setTpuesto("Administrativo");
        emp.setFcontrat("20-01-2020");
        emp.setTseg("AFP");
        emp.setDni(46983606);
        emp.setTelef(44455566);
        emp.setSbase(1500);            
        emp.setHextras(10);
        
        emp.setFcese("12-12-2020");
        
        //Calculo calculohaberes = new Bonificacion(new CalculoBasico());
        Calculo calculohaberes = new CTS(new Vacaciones(new Descuentos(new Bonificacion(new CalculoBasico())))); 
        //Calculo calculohaberes = new Vacaciones(new Descuentos(new Bonificacion(new CalculoBasico())));
        //Calculo calculohaberes = new Descuentos(new CalculoBasico()); 
        //Calculo calculohaberes = new Vacaciones(new CalculoBasico());
        //Calculo calculohaberes = new CTS(new CalculoBasico());
        
        System.out.println("Resultados: "+calculohaberes.salida(emp));
        System.out.println("El total a pagar es: "+calculohaberes.resultado(emp));     
    

        
        //Double dif=calculohaberes.resultado(emp)-emp.getSbase()*2;
        //System.out.println("El total a pagar es: "+dif);
    }
    
}
