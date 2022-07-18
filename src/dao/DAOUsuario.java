package dao;

import conexion.MySQLConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;


public class DAOUsuario implements IUsuario{

    @Override
    public void agrUsuario(Usuario u) {
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="INSERT INTO usuario (usuario,clave,Empleado_codEmp,rolUsu)\n" +
"VALUES (?,?,?,?);";        
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1,u.getUsername());
            st.setString(2,u.getPassword());
            st.setString(3,u.getCod()); 
            st.setString(4,u.getRol()); 
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
    

    @Override
    public void borraUsu(Usuario u) {
                        try{
        String sql="DELETE from usuario\n" +
"WHERE Empleado_codEmp=?;";
        Connection cn=MySQLConexion.getConexion();
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,u.getCod());        
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }

    @Override
    public Usuario loginUser(String usr, String pas) {
        Usuario u=null;
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select Empleado_codEmp from usuario where usuario=? and clave=?";
        PreparedStatement st=cn.prepareStatement(sql);        
        st.setString(1,usr);//relaciona el signo de interrogacion con el id
        st.setString(2,pas);
        ResultSet rs=st.executeQuery();//obtener todo el listado
        if(rs.next()){
            u=new Usuario();
            //Setea todos los valores encontrados en cada columna
            u.setCod(rs.getString(1));             
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return u;
    }
    
}
