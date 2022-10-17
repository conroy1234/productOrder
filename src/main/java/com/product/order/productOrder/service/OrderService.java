package com.product.order.productOrder.service;

import com.product.order.productOrder.dto.Order;
import com.product.order.productOrder.dto.Product;
import com.product.order.productOrder.repository.OrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
	
	int min = 50;
    int max = 100;
    
    @Autowired
    OrderRepository productRepository;

    @Autowired
    ProductService productService;
    

    public List<Order> findAll(){
        return (List<Order>) productRepository.findAll();
    }

    public Optional<Order> findById(int orderId){
        return productRepository.findById(orderId);
    }
 

    public  Order saveOrder(String productId){
    	int randomId = (int)Math.floor(Math.random()*(max-min+1)+min);
        Product product = productService.findById(productId).get();       
        Order order = new Order(randomId,product.getProductName(),product.getProductPrice(),product.getQuantity(),product.getProductID());

       return  productRepository.save(order);

    }

}