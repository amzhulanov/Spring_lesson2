package com.geekbrains.lesson2.repositories;

import com.geekbrains.lesson2.entities.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", new BigDecimal(67.0)));
        products.add(new Product(2L, "Bread", new BigDecimal(27.0)));
        products.add(new Product(3L, "Meat", new BigDecimal(267.0)));
    }

    public List<Product> getAllProducts() {

        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById (Long id){
        for (Product item : products) {
            if (item.getId().equals(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public boolean existById(Long id) {
        return products.stream().anyMatch(s -> s.getId().equals(id));
    }

    public void insert(Product product) {
        if (existById(product.getId())) {
            throw new RuntimeException("Product with id: " + product.getId() + " is already exists");
        }
        products.add(product);
    }
}
