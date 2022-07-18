
package negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import modelo.Empleado;

//Clase abstracta decoradora
public abstract class CalculoDecorator implements Calculo{
    protected Calculo tempCalculo;

    //Constructor parametrizado
    public CalculoDecorator(Calculo nuevoCalculo) {
        tempCalculo=nuevoCalculo;
    }   
    
    public double resultado(Empleado e) {
        return tempCalculo.resultado(e);
    }

    public String salida(Empleado e){
        return tempCalculo.salida(e);
    }
    
    //Método para calcular los meses trabajados
    public int mesesTrabajados(String fechai, String fechaf){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        long monthsBetween = ChronoUnit.MONTHS.between(        
        LocalDate.parse(fechai,formatter).withDayOfMonth(1),
        LocalDate.parse(fechaf,formatter).withDayOfMonth(1));
        return (int) monthsBetween;
    }
    
    //Método para calcular los días trabajados
    public int diasTrabajados(String fechai, String fechaf){   
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        long daysBetween = ChronoUnit.DAYS.between(
        LocalDate.parse(fechai,formatter).withDayOfMonth(1),
        LocalDate.parse(fechaf,formatter).withDayOfMonth(1));
        return (int) daysBetween;   
    } 
    
    public String fechaHoy(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        return (String) (formatter.format(localDate)); 
    }
    
    
}
