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
    Date createAt;

    public OrderItems() {
    }

    public OrderItems(int id, int orderId, int productId, Date createAt) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.createAt = createAt;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", createAt=" + createAt + '}';
    }
}
