package com.example.otktgk_andoird;

import java.util.ArrayList;

public class ProductList {
    private static ArrayList<Product> products = new ArrayList<Product>();

    public static ArrayList<Product> getProductList() {
        Product product1 = new Product("Matteo Armchair",550,R.drawable.images4);
        Product product2 = new Product("Morden Armchair",350,R.drawable.images1);
        Product product3 = new Product("Nice Armchair",250,R.drawable.images3);
        Product product4 = new Product("Circle Armchair",350,R.drawable.images2);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        return products;
    }

    public ProductList() {
    }
}
