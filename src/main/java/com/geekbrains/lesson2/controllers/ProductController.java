package com.geekbrains.lesson2.controllers;


import com.geekbrains.lesson2.entities.Product;
import com.geekbrains.lesson2.repositories.ProductRepository;
import com.geekbrains.lesson2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

// http://localhost:8189/app/products/...
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private Product product;

    @Autowired
    public void setStudentsService(ProductService productService) {
        this.productService = productService;
    }


    // GET http://localhost:8189/app/products/show_form
    @GetMapping("/show_form")
    public String showSimpleForm(Model model) {
        Product product = new Product(1L,"potatoes",new BigDecimal(47.6));
        model.addAttribute("product", product);
        return "product_form";
    }
    // GET http://localhost:8189/app/products/show_add_form
    @GetMapping("/show_add_form")
    public String showAddForm(Model model) {
        Product product = new Product(1L,"potatoes",new BigDecimal(47.6));
        model.addAttribute("product", product);
        return "product_add";
    }

    // GET http://localhost:8189/app/products/show_search_form
    @GetMapping("/show_search_form")
    public String showSearchForm(Model model) {
        //Product product = new Product(1L,"potatoes",new BigDecimal(47.6));
        //model.addAttribute("product", product);
        return "product_search";
    }

    // POST http://localhost:8189/app/products/process_form
    @PostMapping("/process_form")
    public String processForm(@ModelAttribute("product") Product product) {
        this.product=product;
        return "product_form_result";
    }

    // POST http://localhost:8189/app/products/add_product
    @PostMapping("/add_product")
    public String processAddProduct(@ModelAttribute("product") Product product,Model model) {
        this.product=product;
        productService.insert(product);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    // http://localhost:8189/app/products/product_form/1
    @RequestMapping(path = "/product_form/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product searchProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException());
    }
    // http://localhost:8189/app/products/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException());
    }

    // http://localhost:8189/app/products/show
    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }
}
