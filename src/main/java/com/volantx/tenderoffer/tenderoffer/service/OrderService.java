package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Customer;
import com.volantx.tenderoffer.tenderoffer.entity.Orderr;
import com.volantx.tenderoffer.tenderoffer.entity.Product;
import com.volantx.tenderoffer.tenderoffer.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderService implements ApplicationRunner {

    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Orderr o1 = new Orderr(new ArrayList<Customer>(), new ArrayList<Product>(), 1);
        o1.getCustomer().add(customerService.getCustomer(30l));
        o1.getProduct().add(productService.getProduct(33l));

        Stream.of(o1).forEach(this::addOrder);
    }

    public List<Orderr> listAll(){return orderRepository.findAll();}

    public Orderr addOrder(Orderr orderr){
      //  System.out.println("Adding order :" + orderr.toString());

      //  Optional<Orderr> byId = orderRepository.findById(orderr.getOrderId());
        Optional<Orderr> byCustomer = orderRepository.findByCustomer(customerService.getCustomer(30l));

        if (byCustomer.isPresent()){
            throw new RuntimeException("Order already added");
        }
        return orderRepository.save(orderr);
    }
}
