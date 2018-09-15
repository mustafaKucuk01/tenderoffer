package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.Orderr;
import com.volantx.tenderoffer.tenderoffer.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orderr> listOrders(){
        return orderService.listAll();
    }

    @GetMapping("/{id}")
    public Orderr readOrder(@PathVariable Long id){
        return orderService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }


    @PostMapping
    public Orderr addOrder(@RequestBody Orderr order){
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public Orderr updateOrder(@PathVariable("id")Long id,@RequestBody Orderr order){
        return orderService.updateOrder(id, order);
    }
}
