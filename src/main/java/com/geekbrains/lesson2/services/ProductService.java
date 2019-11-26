package com.geekbrains.lesson2.services;

import com.geekbrains.lesson2.entities.Cart;
import com.geekbrains.lesson2.entities.Product;
import com.geekbrains.lesson2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private Cart cart;


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void insert(Product product){
        productRepository.insert(product);
    }

    public List<Product> getAllCarts() {
        return cart.getAllCart();
    }

    public void addCart(Long id){
        cart.addCart(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
