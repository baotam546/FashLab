/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class CartItems {

    int id;
    int sessionId;
    int productId;
    int total;
    Date createdAt;

    public CartItems() {
    }

    public CartItems(int id, int sessionId, int productId, int total, Date createdAt) {
        this.id = id;
        this.sessionId = sessionId;
        this.productId = productId;
        this.total = total;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CartItems{" + "id=" + id + ", sessionId=" + sessionId + ", productId=" + productId + ", total=" + total + ", createdAt=" + createdAt + '}';
    }

}
