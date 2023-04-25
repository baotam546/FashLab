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
public class OrderItems {

    int id;
    int orderId;
    int productId;
    Date createdAt;

    public OrderItems() {
    }

    public OrderItems(int id, int orderId, int productId, Date createAt) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.createdAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", createAt=" + createdAt + '}';
    }
}
