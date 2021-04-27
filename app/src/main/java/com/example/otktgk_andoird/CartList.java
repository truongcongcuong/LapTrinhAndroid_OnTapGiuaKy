package com.example.otktgk_andoird;

import java.util.ArrayList;
import java.util.List;

public class CartList {
    private List<CartItem> list ;
    private static CartList cartList = null;

    public CartList() {
            list = new ArrayList<CartItem>();
    }

    public static CartList getCartList() {
        if (cartList==null)
            cartList = new CartList();
        return cartList;
    }

    public List<CartItem> getList() {
        return list;
    }
    public void addToCart(CartItem cart){
        list.add(cart);
    }
    public double getSubTotal(){
        double subTotal =0;
        for(CartItem item : list){
            subTotal += item.getQuantity()*item.getProduct().getPrice();
        }
        return  subTotal;
    }
}
