/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;


/**
 *
 * @author ninh
 */
public class OrderItemsDAO {
    
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }
    
    public void getAllProduct () 
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBUtils.DBUtils.getConnection();
            if (con != null){
                //2.Write SQL command
                String sql ="Select id, name, categoryId, price, discountId, createAt, quantity from Product";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                //4.Execute statement to get result
                rs = stm.executeQuery();
                //5. process result
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int categoryId = rs.getInt("categoryId");
                    Double price = rs.getDouble("price");
                    int discountId = rs.getInt("discountId");
                    Date createAt = rs.getDate("createAt");
                    int quantity = rs.getInt("quantity");
                    
                    Product dto = new Product(
                            id,name,categoryId,price,discountId,createAt,quantity);
                    if (this.productList == null){
                        this.productList = new ArrayList<>();
                    }//end product list has NOT existed
                    this.productList.add(dto);
                }//end traverse rs to EOF
            }//end connection
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (con !=null){
                con.close();
            }
       }
    }
    
}
