package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.Product;
import com.volantx.tenderoffer.tenderoffer.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts(){
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public Product readProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long id,@RequestBody Product product){
        return productService.updateProduct(id, product);
    }
}
