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
public class Discount {

    int id;
    String name;
    String discountPercent;
    Date createAt;

    public Discount() {
    }

    public Discount(int id, String name, String discountPercent, Date createAt) {
        this.id = id;
        this.name = name;
        this.discountPercent = discountPercent;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Discount{" + "id=" + id + ", name=" + name + ", discountPercent=" + discountPercent + ", createAt=" + createAt + '}';
    }

}
