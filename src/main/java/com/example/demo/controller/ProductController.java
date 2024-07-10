package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.MyUserDetailService;
import com.example.demo.service.ProductService;
import com.example.demo.webtoken.JwtService;
import com.example.demo.webtoken.LoginForm;


@RestController
public class ProductController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private ProductService per;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product)
    {
        System.out.println(product);
        per.saveProduct(product);
    }

    @PostMapping("/admin/addProduct")
    public void addProduct1(@RequestBody Product product)
    {
        System.out.println(product);
        per.saveProduct(product);
    }

    @GetMapping("/admin/showProduct")
    public List<Product> getAllUsers()
    {
        return per.getProduct();
    }

    @GetMapping("/user/showProduct")
    public List<Product> getAllUsers1()
    {
        return per.getProduct();
    }

    @GetMapping("/home")
    public String display()
    {
        return "<h1>Basic Home</h1>";
    }

    @GetMapping("/admin/home")
    public String display1()
    {
        return "<h1>Admin Home</h1>";
    }

    @GetMapping("/user/home")
    public String display2()
    {
        return "<h1>User Home</h1>";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm)
    {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));

        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
        }else{
            throw new UsernameNotFoundException("Invalid Credentials");
        }
    }


    @DeleteMapping("/admin/deleteProduct")
    public void removeProduct(@RequestParam int id)
    {
        System.out.print("To be Deleted: "+id);
        per.deleteProduct(id);
    }

    @PutMapping("/admin/changeProduct")
    public void putMethodName(@RequestBody Product product) {
        System.out.println("Product Recieved: "+product);
        per.changeProductData(product);
    }

    @PatchMapping("/admin/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        System.out.println(product);
        per.updateProductData(product);
    }
}
