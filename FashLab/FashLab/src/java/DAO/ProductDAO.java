/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProductDAO {
    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity, p2.link" +
                     "  FROM Product p1  left join ProductsPhoto p2 on p1.id = p2.userId ";
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getDate(6), rs.getInt(7),rs.getString(8)));
            }
            
        } catch (Exception e) {
        }
        return list;
}
    
    public Product getProduct(int productId){
        Product product = null;

        try {
            Connection cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity, p2.link" +
                     "  FROM Product p1 left join ProductsPhoto p2 on p1.id = p2.userId WHERE p1.id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, productId);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int categoryId = rs.getInt("categoryId");
                        double price = rs.getDouble("price");
                        int discountId = rs.getInt("discountId");
                        Date createdAt = rs.getDate("createdAt");
                        int quantity = rs.getInt("quantity");
                        String link = rs.getString("link");
                        product = new Product(id, name, categoryId, price, discountId, createdAt, quantity, link);
      
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    

    public static List<Product> getAllProductsByCategory(int cateId) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity,p2.link" +
                     "  FROM Product p1  left join ProductsPhoto p2 on p1.id = p2.userId WHERE categoryId = ? ";
        Connection cn = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getDate(6), rs.getInt(7),rs.getString(8)));
            }
            
        } catch (Exception e) {
        }
        return list;
}
    
    public Product getSingleProduct(int id){
        Product p = null;
        try {
            String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity,p2.link" +
                     "  FROM Product p1  left join ProductsPhoto p2 on p1.id = p2.userId "
                    + "WHERE id = ?";
            
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getString(8));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public boolean deleteProduct(String productID) throws SQLException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm =  null;
        try {
            conn = DBUtils.getConnection();
            if(conn!= null){
                String sql=" DELETE Product "
                        + " WHERE id=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                int value = stm.executeUpdate(); //thực thi true trả về >0
                result= value > 0? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(stm!= null) stm.close();
            if(conn!= null) conn.close();
        }
        return result;
    } 
    public static List<Product> getAllProductsBySearch(String txt) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity,p2.link" +
                     "  FROM Product p1  left join ProductsPhoto p2 on p1.id = p2.userId WHERE name like  ";
        Connection cn = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+ txt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getDate(6), rs.getInt(7),rs.getString(8)));
            }
            
        } catch (Exception e) {
        }
        return list;
}
    
    public static void main(String[] args) {

        ProductDAO p = new ProductDAO();
        System.out.print(p.getProduct(2));

        
        List<Product> list = ProductDAO.getAllProducts();
        for (Product product : list) {
            System.out.println(product);
        }
    }

    
}
