package com.geekbrains.lesson2.entities;

import com.geekbrains.lesson2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Cart {
    ProductService productService;
    private List<Product> cart = new ArrayList<>();

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void addCart(Long id) {
        //cart.add(productService.findById(id));
    }

    public List<Product> getAllCart() {
        return Collections.unmodifiableList(cart);
    }
}
