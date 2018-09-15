package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Product;
import com.volantx.tenderoffer.tenderoffer.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductService implements ApplicationRunner {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Product p1 = new Product("Bilgisayar", "Casper", 2500);
        Product p2 = new Product("Telefon", "Samsung", 1100);

        try {
            Stream.of(p1, p2).forEach(this::addProduct);
        } catch (Exception e) {

        }

    }

    public List<Product> listAll(){return productRepository.findAll();}

    public Product addProduct(Product product){
        System.out.println("Adding product :" + product.toString());

        Optional<Product> byId = productRepository.findByProductId(product.getProductId());
        if (byId.isPresent()){
            throw new RuntimeException("Product already added");
        }
        return productRepository.save(product);
    }

    public Product getProduct(Long id){
        Optional<Product> byId = productRepository.findByProductId(id);
        if (!byId.isPresent()){
            throw new RuntimeException("Product not founded");
        }
        return productRepository.getOne(id);
    }

    public Product updateProduct(Long id, Product product){
        getProduct(id);
        product.setProductId(id);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        System.out.println("Deleting product :" + getProduct(id).toString());
        productRepository.delete(getProduct(id));
    }

}
