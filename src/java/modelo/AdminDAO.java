/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57320
 */
public class AdminDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
    
    
    public List listar(){
        List<Administrador>lista = new ArrayList<>();
        String sql="select * from administrador";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Administrador admin=new Administrador();
                admin.setId(rs.getString(1));
                admin.setNombre(rs.getString(2));
                admin.setApellido(rs.getString(3));
                admin.setEmail(rs.getString(4));
                admin.setContraseña(rs.getString(5));
                lista.add(admin);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    public int agregar(Administrador admin){
        int r=0;
        String sql="insert into administrador(id,nombre,apellido,email,contraseña) values(?,?,?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,admin.getId());
            ps.setString(2,admin.getNombre());
            ps.setString(3,admin.getApellido());
            ps.setString(4,admin.getEmail());
            ps.setString(5,admin.getContraseña());
            r=ps.executeUpdate();
            if (r==1) {
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    
    public Administrador listarId(String id){
        String sql="select * from administrador where id="+id;
        Administrador admin=new Administrador();
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                admin.setId(rs.getString(1));
                admin.setNombre(rs.getString(2));
                admin.setApellido(rs.getString(3));
                admin.setEmail(rs.getString(4));
                admin.setContraseña(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return admin;
    }
    
    public int actualizar(Administrador admin){
        int r=0;
        String sql="update administrador set nombres=?,apellido=?,email=?,contraseña=? where id=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,admin.getNombre());
            ps.setString(2,admin.getApellido());
            ps.setString(3,admin.getEmail());
            ps.setString(4,admin.getContraseña());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(String id){
        String sql="delete from administrador where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}
