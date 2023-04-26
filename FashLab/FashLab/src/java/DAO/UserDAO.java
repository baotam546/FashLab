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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class UserDAO {

    public static boolean checkLogin(String email, String password) throws Exception {
        boolean isValid = false;
        try {
            Connection con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select email, password, role "
                        + "from Clients "
                        + "where email = ? and password = ? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        if (rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
                            isValid = true;
                            break;
                        }
                    }
                    rs.close();
                    pst.close();
                }
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    public static ArrayList<User> getUsers() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        if (con != null) {
            String sql = "select id, firstName, lastName, email, mobile, password, address, createdAt, role "
                    + "from Clients "
                    + "where email = ? and password = ? COLLATE Latin1_General_CS_AS";
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
                    User us = new User(id, fistname, lastname, email, mobile, pwd, address);
                    list.add(us);
                }
                rs.close();
                pst.close();
            }
            con.close();
        }
        return list;
    }

    public boolean insertUser(User user) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO Clients (firstName, lastName, email, password, mobile, address, createdAt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getMobile());
            pst.setString(6, user.getAddress());
            pst.setTimestamp(7, new Timestamp(user.getCreatedAt().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert account error: " + ex.getMessage());
            return false;
        } finally {

        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        User user = new User(1, "John", "Doe", "johndoe@gmail.com", "123456789", "password", "123 Main St");
        UserDAO dao = new UserDAO();
        boolean result = dao.insertUser(user);
        if (result) {
            System.out.println("User inserted successfully!");
        } else {
            System.out.println("Failed to insert user.");
        }
    }

//    public static void main(String[] args) throws Exception {
//        ArrayList<User> list = UserDAO.getUsers();
//        for (User user : list) {
//            System.out.println(user);
//
//        }
//    }
}
