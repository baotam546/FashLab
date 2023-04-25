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
    public  List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product ";
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getDate(6), rs.getInt(7) );
                list.add(p);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
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
    
    
}
