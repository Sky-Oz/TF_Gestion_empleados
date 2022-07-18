package dao;

import conexion.MySQLConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;
import modelo.Asistencia;


public class DAOSueldo implements ISueldo{    

    @Override
    public void grabaSueldo(String codemp) {
             try{
            Connection cn=MySQLConexion.getConexion();
            String sql="INSERT INTO sueldo(Empleado_codEmp)\n" +
"VALUES (?);";        
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1,codemp);            
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void grabaBon(double mbon) {
        try{
            String sql="{call GRABABON(?)}";
            Connection cn=MySQLConexion.getConexion();
            CallableStatement st=cn.prepareCall(sql);
            st.setDouble(1,mbon);        
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    

    @Override
    public void grabaDes(double mdes) {
        try{
            String sql="{call GRABADES(?)}";
            Connection cn=MySQLConexion.getConexion();
            CallableStatement st=cn.prepareCall(sql);
            st.setDouble(1,mdes);        
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }
    

    @Override
    public void grabaVac(double mvac) {
        try{
            String sql="{call GRABAVAC(?)}";
            Connection cn=MySQLConexion.getConexion();
            CallableStatement st=cn.prepareCall(sql);
            st.setDouble(1,mvac);        
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    

    @Override
    public void grabaCts(double tsue, String fces, int mlab, double mcts, String fec) {
        try{
            String sql="{call GRABACTS(?,?,?,?,?)}";
            Connection cn=MySQLConexion.getConexion();
            CallableStatement st=cn.prepareCall(sql);
            st.setDouble(1,tsue);
            st.setString(2,fces); 
            st.setInt(3,mlab);
            st.setDouble(4,mcts);
            st.setString(5,fec);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
    @Override
    public void grabaTot(double mtot) {
        try{
            String sql="{call GRABATOT(?)}";
            Connection cn=MySQLConexion.getConexion();
            CallableStatement st=cn.prepareCall(sql);
            //Asignando valores
            //(debe de estar en el mismo orden como creamos en el SP)
            st.setDouble(1,mtot);        
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }   

    @Override
    public void cambiaHhee(String cod, int hhee) {
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="UPDATE administrativo\n" +
"SET hextras=?\n" +
"WHERE Empleado_codEmp=?;";        
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1,hhee);
            st.setString(2,cod);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }

    @Override
    public void cambiaMvent(String cod, int mvnt) {
                try{
            Connection cn=MySQLConexion.getConexion();
            String sql="UPDATE vendedor\n" +
"SET montoVent=?\n" +
"WHERE Empleado_codEmp=?;";        
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1,mvnt);
            st.setString(2,cod);
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
        
    }
}
