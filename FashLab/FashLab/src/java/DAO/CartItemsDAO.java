/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class CartItemsDAO {
    private Map<String, Product> cart;

    public CartItemsDAO() {
    }

    public CartItemsDAO(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public boolean add(Product p) {
        boolean result = false;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(p.getId())) {
            int currentQuantity = this.cart.get(p.getId()).getQuantity();
            p.setQuantity(currentQuantity + p.getQuantity());

        }
        this.cart.put(String.valueOf(p.getId()), p);
        result = true;
        return result;
    }

    public boolean update(String id, Product p) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, p);
                result = true;
            }
        }
        return result;
    }

    public boolean remove(String id) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.remove(id);
                result = true;
            }
        }
        return result;
    }
}
