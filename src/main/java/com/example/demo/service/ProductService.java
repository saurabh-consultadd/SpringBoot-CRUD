package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void saveProduct(Product product)
    {
        repository.save(product);
    }

    public List<Product> getProduct()
    {
        return (List<Product>) repository.findAll();
    }

    public void deleteProduct(int id)
    {
        Product p = repository.findById(id).get();
        System.out.println(p);
        repository.delete(p);
    }

    public void changeProductData(Product product)
    {
        int id=product.getId();
        Product p= repository.findById(id).get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        repository.save(p);
    }

    public void updateProductData(Product product)
    {
        int id=product.getId();
        Product p = repository.findById(id).get();
        if(product.getName()!=null)
        {
            p.setName(product.getName());
        }
        if(product.getPrice()!=null)
        {
            p.setPrice(product.getPrice());
        }
        repository.save(p);
    }


}