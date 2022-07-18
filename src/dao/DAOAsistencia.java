package dao;

import conexion.MySQLConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;
import modelo.Asistencia;



public class DAOAsistencia implements IAsistencia{

    
    @Override
    public Asistencia validaAsis(String cod) {
        Asistencia a=null;
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select nomEmp,apeEmp from empleado where codEmp=?";
        PreparedStatement st=cn.prepareStatement(sql);       
        st.setString(1,cod);
        ResultSet rs=st.executeQuery();//obtener todo el listado
        if(rs.next()){
            a=new Asistencia();
            a.setNombre(rs.getString(1));
            a.setApellido(rs.getString(2));
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return a;        
    }

    @Override
    public void regAsistencia(Asistencia a) {
        try{
        String sql="{call addasis(?,?)}";
        Connection cn=MySQLConexion.getConexion();
        CallableStatement st=cn.prepareCall(sql);
        st.setString(1,a.getIdEm());
        st.setString(2,a.getDia());        
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }              
    }
}

