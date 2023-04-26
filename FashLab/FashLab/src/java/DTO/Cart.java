/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.ProductDAO;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class Cart {

    private String sessionId;
    private Map<Product, Integer> items;
    private Date createdDate;
    private float totalPayment;

    public Cart(String sessionId, Map<Product, Integer> items, Date createdDate, float totalPayment) {
        this.sessionId = sessionId;
        this.items = items;
        this.createdDate = createdDate;
        this.totalPayment = totalPayment;
    }

    public Cart(String sessionId) {
        this.createdDate = new Date(System.currentTimeMillis());
        this.items = new HashMap<>();
        this.totalPayment = 0;

    }

    public void addToCart(Product product, int amount) {

        if (items.isEmpty()) {
            items.put(product, amount);
            return;
        }
        // items het rong
        Integer currentAmount = items.get(product);
        if (currentAmount != null){
            currentAmount += amount;
        } else {
           currentAmount = amount;
        }
         items.put(product, currentAmount);
    }
    
    public void deleteFromCart(int id){
        ProductDAO dao = new ProductDAO();
        Product product = dao.getProduct(id);
        if (product == null) return;
        items.remove(product);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public float getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }

}
