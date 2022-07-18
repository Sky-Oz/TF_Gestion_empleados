package modelo;


public class Vendedor extends Empleado{
    private int mventas;
    
    

    
    @Override
    public double bonificacion() {
        int pasajes=200;
        double comision=mventas*0.09;               
        
        return pasajes+comision;
    }

    @Override
    public String toString() {
        return "Personal de ventas";
    }

    
    //Métodos Getters & Setters
    public int getMventas() {
        return mventas;
    }

    public void setMventas(int mventas) {
        this.mventas = mventas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
