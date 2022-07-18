package modelo;

public class Administrativo extends Empleado{
    protected int hextras;

    

    @Override
    public double bonificacion() {        
        Double vhora,vhextra1,vhextra2,acum=0.0;
        //Calculando valor hora
        vhora=getSbase()/30/8;
        vhextra1=vhora*0.25;
        vhextra2=vhora*0.35;
        //Calculando valor hextras 
        for(int x=1;x<=this.hextras;x++){
            if(x<=2){
                acum=acum+vhora+vhextra1;
            }else{
                acum=acum+vhora+vhextra2;
            }
        } 
        return acum;  
    }

    
    @Override
    public String toString() {
        return "Personal administrativo";
    }

    
    //Métodos Getters & Setters
    public int getHextras() {
        return hextras;
    }

    public void setHextras(int hextras) {
        this.hextras = hextras;
    }
    
    
    
    


    
}
