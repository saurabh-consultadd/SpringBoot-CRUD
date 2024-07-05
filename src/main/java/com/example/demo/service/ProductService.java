package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

//    POST
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

//    GET
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
        return repository.findByName(name) ;
    }

//    DELETE
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed || "+id;
    }

//    PUT
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

//    PATCH
    public Product patchUpdate(int id, Map<String, Object> fields){
        Product existingProduct = repository.findById(id).get();

        fields.forEach((key, value)->{
            Field field = ReflectionUtils.findField(Product.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingProduct, value);
        });

        return repository.save(existingProduct);
    }
}
