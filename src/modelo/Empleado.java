package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public abstract class Empleado {
    private String code,ape,nome,fnac,sexo,lnac,gestud,mail,dir
            ,npuesto,tpuesto,fcontrat,tseg,fcese;    
    private int dni,telef; 
    private double sbase;
    //static int cuenta = 1;
    
    //Constructor no parametrizado
    public Empleado() {
        //this.code = genera();        
    }
    
    //Método generador de código
//    public String genera() {
//        if (cuenta < 10) {
//            return "E000" + cuenta++;
//        } else if (cuenta < 100) {
//            return "E00" + cuenta++;
//        } else if (cuenta < 1000) {
//            return "E0" + cuenta++;
//        } else {
//            return "E" + cuenta++;
//        }
//    }
    

    //Método abstracto
    public abstract double bonificacion();
    
    
    public double sBruto(){
        return sbase+bonificacion();
    }
    
    
    public double seguro(){
        if(this.tseg.equals("AFP")){
            return 0.1197;
        }else{
            return 0.13;
        }
    }  
    
        
    public double sNeto(){
        return sBruto()-seguro();
    }
     
    
    //Métodos Getters & Setters
    public String getCode() {
        return code;
    }   

    public void setCode(String code) {
        this.code = code;
    }    

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getLnac() {
        return lnac;
    }

    public void setLnac(String lnac) {
        this.lnac = lnac;
    }

    public String getGestud() {
        return gestud;
    }

    public void setGestud(String gestud) {
        this.gestud = gestud;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getNpuesto() {
        return npuesto;
    }

    public void setNpuesto(String npuesto) {
        this.npuesto = npuesto;
    }

    public String getTpuesto() {
        return tpuesto;
    }

    public void setTpuesto(String tpuesto) {
        this.tpuesto = tpuesto;
    }

    public String getFcontrat() {
        return fcontrat;
    }

    public void setFcontrat(String fcontrat) {
        this.fcontrat = fcontrat;
    }

    public String getTseg() {
        return tseg;
    }

    public void setTseg(String tseg) {
        this.tseg = tseg;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public double getSbase() {
        return sbase;
    }

    public void setSbase(double sbase) {
        this.sbase = sbase;
    }


    public String getFcese() {
        return fcese;
    }

    public void setFcese(String fcese) {
        this.fcese = fcese;
    }   

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    
                
}
    
    
    
    
    
    
    
    
    
    
    


    

