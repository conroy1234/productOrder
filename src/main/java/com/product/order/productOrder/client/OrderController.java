package com.product.order.productOrder.client;

import com.product.order.productOrder.dto.Order;
import com.product.order.productOrder.dto.Product;
import com.product.order.productOrder.service.OrderService;
import com.product.order.productOrder.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping("/fictional/organisation/order")
    public ResponseEntity< Iterable<Order>> findAllOrders(){
        Iterable<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/fictional/organisation/order/{id}")
    public Order findById(@PathVariable int id){
        Order orders = orderService.findById(id).get();
        return orders;
    }

    @GetMapping("/fictional/organisation/product/{productId}")
    Product findProduct(@PathVariable String productId){
        return productService.findById(productId).get();
        //test
    }

    @PostMapping("/fictional/organisation/order/{productId}")
   public ResponseEntity<Order> saveOrder(@RequestBody Order order,@PathVariable String productId){
       Order entity = orderService.saveOrder(productId);
       logger.info("order has been created....",entity);
       if(entity==null) {
    	  throw new RuntimeException("empty request");

       }
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(entity.getId())
               .toUri();     
       return ResponseEntity.created(location).build();
       
   } 
    
    
 
}