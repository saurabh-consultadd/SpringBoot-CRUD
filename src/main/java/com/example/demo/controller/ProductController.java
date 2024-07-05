package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;


//    Add one product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
//    Add multiple products
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }


//    Get all
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }
//    Get by id
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
//    Get by name
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }


//    Update
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

//    Delete
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

//    Patch
    @PatchMapping("/patch/{id}")
    public Product patchUpdate(@PathVariable int id, @RequestBody Map<String, Object> fields){
//        System.out.println(fields);
        return service.patchUpdate(id, fields);
    }
}
