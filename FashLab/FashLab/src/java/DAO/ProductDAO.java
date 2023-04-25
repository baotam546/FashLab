/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProductDAO {
    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT  p1.id,p1.name,p1.categoryId, p1.price , p1.discountId,p1.createdAt,p1.quantity,p2.link" +
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
    
    
    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        List<Product> list = p.getAllProducts();
        for (Product product : list) {
            System.out.println(product);
        }
    }
    
}
