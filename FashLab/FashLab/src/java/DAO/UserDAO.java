/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class UserDAO {

    public static ArrayList<User> getUsers() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        if (con != null) {
            String sql = "select id, firstName, lastName, email, mobile, password, address, createdAt, role "
                    + "from Clients "
                    + "where id = ? and password = ? COLLATE Latin1_General_CS_AS";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String fistname = rs.getString("firstName");
                    String lastname = rs.getString("lastName");
                    String email = rs.getString("email");
                    String mobile = rs.getString("mobile");
                    String pwd = rs.getString("password");
                    String address = rs.getString("address");
                    Date createdAt = rs.getDate("createdAt");
                    int role = rs.getInt("role");
                    User us = new User(id, fistname, lastname, email, mobile, pwd, address, createdAt, role);
                    list.add(us);
                }
                rs.close();
                pst.close();
            }
            con.close();
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<User> list = UserDAO.getUsers();
        for (User user : list) {
            System.out.println(user);

        }
    }
}
