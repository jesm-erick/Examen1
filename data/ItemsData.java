package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Items;

public class ItemsData {
    List<Items> lis = new ArrayList<Items>();
    int id = 0;
    Connection cn = Conexion.connectSQLite();
    public void create(Items d) {
        
        String sql = "INSERT INTO items(nombre, categoria, familia, precio) "
                + " VALUES(?,?,?,?) ";
        int i = 0;
        int res =0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getCategoria());
            ps.setString(++i, d.getFamilia());
            ps.setInt(++i, d.getPrecio());
            res = ps.executeUpdate();// 0 no o 1 si commit
            System.out.println("create.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    
    }
    public List<Items> list(String filter) {
        List<Items> lis2 = new ArrayList<Items>();
        String sql = "SELECT * FROM items ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Items p = new Items();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setFamilia(rs.getString("familia"));
                p.setPrecio(rs.getInt("precio"));
                lis2.add(p);                
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lis2;
    }
    
    public Items get(int id) {
        Items p =new Items();
        String sql = "SELECT * FROM items WHERE id = "+id+" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setFamilia(rs.getString("familia"));
                p.setPrecio(rs.getInt("precio"));
                            
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return p;
    }
    public void update(Items d) {
        String sql = "UPDATE items SET "
                + "nombre=?, "
                + "categoria=?, "
                + "familia=?, "
                + "precio=? "
                + "WHERE id=?";
        int i = 0;
        int res =0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getCategoria());
            ps.setString(++i, d.getFamilia());
            ps.setInt(++i, d.getPrecio());
            ps.setInt(++i, d.getId());
            res = ps.executeUpdate();// 0 no o 1 si commit
            System.out.println("update.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return ;
    }
    public void delete(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        int res =0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id );
            res = ps.executeUpdate();// 0 no o 1 si commit
            System.out.println("delete.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return ;
    }
}
