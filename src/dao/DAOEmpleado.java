
package dao;

import conexion.MySQLConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;
import java.util.ArrayList;
import java.util.List;



public class DAOEmpleado implements IEmpleado{     

    
    //Constructor vacio
    public DAOEmpleado() {        
    }

    
    @Override
    public void agrAdministrativo(Administrativo a) {
        try{
        String sql="{call ADDADMIN(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection cn=MySQLConexion.getConexion();
        CallableStatement st=cn.prepareCall(sql);
        st.setInt(1,a.getDni());
        st.setDouble(2,a.getSbase());
        st.setString(3,a.getNome());
        st.setString(4,a.getApe());
        st.setString(5,a.getSexo());
        st.setInt(6,a.getTelef());  
        st.setString(7,a.getGestud());
        st.setString(8,a.getMail());
        st.setString(9,a.getDir());
        st.setString(10,a.getFnac());
        st.setString(11,a.getFcontrat());
        st.setString(12,a.getTseg());
        st.setString(13,a.getLnac());
        st.setString(14,a.getNpuesto());
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }                
    }

    @Override
    public void agrVendedor(Vendedor v) {
        try{
        String sql="{call ADDVEND(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection cn=MySQLConexion.getConexion();
        CallableStatement st=cn.prepareCall(sql);
        st.setInt(1,v.getDni());
        st.setDouble(2,v.getSbase());
        st.setString(3,v.getNome());
        st.setString(4,v.getApe());
        st.setString(5,v.getSexo());
        st.setInt(6,v.getTelef());  
        st.setString(7,v.getGestud());
        st.setString(8,v.getMail());
        st.setString(9,v.getDir());
        st.setString(10,v.getFnac());
        st.setString(11,v.getFcontrat());
        st.setString(12,v.getTseg());
        st.setString(13,v.getLnac());
        st.setString(14,v.getNpuesto());
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }           
    }

    @Override
    public List<Empleado> lisEmpleados() {
        List<Empleado> lista=new ArrayList();
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="select codemp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from empleado";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();//obtener todo el listado
            while(rs.next()){            
                Empleado emp=new Administrativo();            
                emp.setCode(rs.getString(1));            
                emp.setNome(rs.getString(2));
                emp.setApe(rs.getString(3));
                emp.setNpuesto(rs.getString(4));
                emp.setTpuesto(rs.getString(5));
                emp.setFcontrat(rs.getString(6));
                emp.setSbase(rs.getDouble(7));                
                lista.add(emp);
            }        
        }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
        }    
        return lista;    
    }
   
    

    @Override
    public void borraAdm(Empleado a) {
                try{
        String sql="DELETE empleado,administrativo FROM empleado\n" +
"INNER JOIN administrativo\n" +
"WHERE empleado.codEmp=administrativo.Empleado_codEmp and empleado.codEmp = ?";
        Connection cn=MySQLConexion.getConexion();
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,a.getCode());        
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    

    @Override
    public void borraVend(Empleado v) {
                try{
        String sql="DELETE empleado,vendedor FROM empleado\n" +
"INNER JOIN vendedor\n" +
"WHERE empleado.codEmp=vendedor.Empleado_codEmp and empleado.codEmp = ?";
        Connection cn=MySQLConexion.getConexion();
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,v.getCode());        
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }

    
    
    @Override
    public void modificaAdm(Administrativo a) {
        try{
        String sql="{call MODADMIN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection cn=MySQLConexion.getConexion();
        CallableStatement st=cn.prepareCall(sql);
        st.setString(1,a.getCode());
        st.setInt(2,a.getDni());
        st.setDouble(3,a.getSbase());
        st.setString(4,a.getNome());
        st.setString(5,a.getApe());
        st.setString(6,a.getSexo());
        st.setInt(7,a.getTelef());  
        st.setString(8,a.getGestud());
        st.setString(9,a.getMail());
        st.setString(10,a.getDir());
        st.setString(11,a.getFnac());
        st.setString(12,a.getFcontrat());
        st.setString(13,a.getTseg());
        st.setString(14,a.getLnac());
        st.setString(15,a.getNpuesto());
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }               
    }

    
    
    @Override
    public void modificaVend(Vendedor v) {
                try{
        String sql="{call MODVENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection cn=MySQLConexion.getConexion();
        CallableStatement st=cn.prepareCall(sql);
        st.setString(1,v.getCode());
        st.setInt(2,v.getDni());
        st.setDouble(3,v.getSbase());
        st.setString(4,v.getNome());
        st.setString(5,v.getApe());
        st.setString(6,v.getSexo());
        st.setInt(7,v.getTelef());  
        st.setString(8,v.getGestud());
        st.setString(9,v.getMail());
        st.setString(10,v.getDir());
        st.setString(11,v.getFnac());
        st.setString(12,v.getFcontrat());
        st.setString(13,v.getTseg());
        st.setString(14,v.getLnac());
        st.setString(15,v.getNpuesto());
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }

    
    
    @Override
    public List<Empleado> filtraEmpNom(String nom) {
        List<Empleado> lista=new ArrayList();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select codemp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from empleado\n" +
"where nomEmp like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,nom+"%");//relaciona el signo de interrogacion con el id
        ResultSet rs=st.executeQuery();//obtener todo el listado
        while(rs.next()){
            Empleado e=new Administrativo();
            e.setCode(rs.getString(1));
            e.setNome(rs.getString(2));
            e.setApe(rs.getString(3));
            e.setNpuesto(rs.getString(4));
            e.setTpuesto(rs.getString(5));
            e.setFcontrat(rs.getString(6));
            e.setSbase(rs.getDouble(7));
            lista.add(e);//Agrega todo al ArrayList lista
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return lista;
    }
    
    
    
    @Override
    public List<Empleado> filtraEmpApe(String ape) {
        List<Empleado> lista=new ArrayList();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select codemp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from empleado\n" +
"where apeEmp like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,ape+"%");//relaciona el signo de interrogacion con el id
        ResultSet rs=st.executeQuery();//obtener todo el listado
        while(rs.next()){
            Empleado e=new Administrativo();
            e.setCode(rs.getString(1));
            e.setNome(rs.getString(2));
            e.setApe(rs.getString(3));
            e.setNpuesto(rs.getString(4));
            e.setTpuesto(rs.getString(5));
            e.setFcontrat(rs.getString(6));
            e.setSbase(rs.getDouble(7));
            lista.add(e);//Agrega todo al ArrayList lista
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return lista;        
    }
    
    

    @Override
    public Empleado filtraEmpCod(String cod) {
        Empleado e=null;
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select codemp,dniEmp,sbaseEmp,nomEmp,apeEmp,sexEmp,telEmp,estuEmp,correoEmp,dircEmp,fecNaEmp,fecContEmp,segEmp,DnacEmp,NpuestoEmp,tEmp\n" +
"from empleado\n" +
"WHERE codEmp=?";
        PreparedStatement st=cn.prepareStatement(sql);        
        st.setString(1,cod);//relaciona el signo de interrogacion con el id        
        ResultSet rs=st.executeQuery();//obtener todo el listado
        if(rs.next()){
            //Si es administrativo
            if(rs.getString(16).equals("Administrativo")){                
                e=new Administrativo();
                e.setCode(rs.getString(1));
                e.setDni(rs.getInt(2));
                e.setSbase(rs.getDouble(3));
                e.setNome(rs.getString(4));
                e.setApe(rs.getString(5));
                e.setSexo(rs.getString(6));
                e.setTelef(rs.getInt(7));
                e.setGestud(rs.getString(8));
                e.setMail(rs.getString(9));
                e.setDir(rs.getString(10));
                e.setFnac(rs.getString(11));
                e.setFcontrat(rs.getString(12));
                e.setTseg(rs.getString(13));
                e.setLnac(rs.getString(14));
                e.setNpuesto(rs.getString(15));
                e.setTpuesto(rs.getString(16));
                //Si es Vendedor
            }else if(rs.getString(16).equals("Ventas")){                
                e=new Vendedor();
                e.setCode(rs.getString(1));
                e.setDni(rs.getInt(2));
                e.setSbase(rs.getDouble(3));
                e.setNome(rs.getString(4));
                e.setApe(rs.getString(5));
                e.setSexo(rs.getString(6));
                e.setTelef(rs.getInt(7));
                e.setGestud(rs.getString(8));
                e.setMail(rs.getString(9));
                e.setDir(rs.getString(10));
                e.setFnac(rs.getString(11));
                e.setFcontrat(rs.getString(12));
                e.setTseg(rs.getString(13));
                e.setLnac(rs.getString(14));
                e.setNpuesto(rs.getString(15));
                e.setTpuesto(rs.getString(16));
            }            
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return e;              
    }
    
    
    
    
    @Override
    public List<Empleado> filtraEmpAdm() {
        List<Empleado> lista=new ArrayList();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select Empleado_codEmp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from administrativo a\n" +
"join empleado e on e.codEmp=a.Empleado_codEmp";
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();//obtener todo el listado
        while(rs.next()){
            Empleado e=new Administrativo();
            e.setCode(rs.getString(1));
            e.setNome(rs.getString(2));
            e.setApe(rs.getString(3));
            e.setNpuesto(rs.getString(4));
            e.setTpuesto(rs.getString(5));
            e.setFcontrat(rs.getString(6));
            e.setSbase(rs.getDouble(7));
            lista.add(e);//Agrega todo al ArrayList lista
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return lista;        
    }

    
    
    @Override
    public List<Empleado> filtraEmpVen() {
        List<Empleado> lista=new ArrayList();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select Empleado_codEmp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from vendedor v\n" +
"join empleado e on e.codEmp=v.Empleado_codEmp";
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();//obtener todo el listado
        while(rs.next()){
            Empleado e=new Administrativo();
            e.setCode(rs.getString(1));
            e.setNome(rs.getString(2));
            e.setApe(rs.getString(3));
            e.setNpuesto(rs.getString(4));
            e.setTpuesto(rs.getString(5));
            e.setFcontrat(rs.getString(6));
            e.setSbase(rs.getDouble(7));
            lista.add(e);//Agrega todo al ArrayList lista
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return lista;        
    }   
    

    @Override
    public List<Empleado> muestraEmpCod(String cod) {
        List<Empleado> lista=new ArrayList();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select codemp,nomEmp,apeEmp,NpuestoEmp,tEmp,fecContEmp,sbaseEmp\n" +
"from empleado\n" +
"WHERE codEmp=?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1,cod);       
        ResultSet rs=st.executeQuery();//obtener todo el listado
        while(rs.next()){
            Empleado e=new Administrativo();
            e.setCode(rs.getString(1));
            e.setNome(rs.getString(2));
            e.setApe(rs.getString(3));
            e.setNpuesto(rs.getString(4));
            e.setTpuesto(rs.getString(5));
            e.setFcontrat(rs.getString(6));
            e.setSbase(rs.getDouble(7));
            lista.add(e);//Agrega todo al ArrayList lista
        }        
    }catch(Exception ex){//Si bota error
            ex.printStackTrace();//Imprime el error en consola
            }
        return lista;       
    }   
}   
    
    
     
     
        

