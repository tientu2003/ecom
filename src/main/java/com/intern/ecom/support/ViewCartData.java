package com.intern.ecom.support;


import java.util.HashMap;
import java.util.Map;

public class ViewCartData {
    private String cartId;
    private Map<String,Short> productList = new HashMap<String,Short>();
    private Double totalPrice;


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, Short> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, Short> productList) {
        this.productList = productList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
