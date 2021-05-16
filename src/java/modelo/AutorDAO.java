
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duvan Felipe
 */
public class AutorDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
    
    
    public List listar(){
        List<Autor> lista = new ArrayList<>();
        String sql="select * from autor";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Autor autor=new Autor();
                autor.setId_autor(Integer.parseInt(rs.getString(1)));
                autor.setNombre(rs.getString(2));
                autor.setCargo(rs.getString(3));
                
                lista.add(autor);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Autor autor){
        int r=0;
        String sql="insert into autor(id,nombre,cargo) values(?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,String.valueOf(autor.getId_autor()));
            ps.setString(2,autor.getNombre());
            ps.setString(3,autor.getCargo());
            
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
    
    
    public Autor listarId(String id){
        String sql="select * from autor where id="+id;
        Autor autor=new Autor();
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {     
                
                autor.setId_autor(Integer.parseInt(rs.getString(1)));
                autor.setNombre(rs.getString(2));
                autor.setCargo(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return autor;
    }
    
    
    public int actualizar(Autor autor){
        int r=0;
        String sql="update autor set nombres=?,cargo=? where id=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,autor.getNombre());
            ps.setString(2,autor.getCargo());
            
            
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
        String sql="delete from autor where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
}
