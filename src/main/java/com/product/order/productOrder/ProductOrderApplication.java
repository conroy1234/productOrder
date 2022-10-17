package com.product.order.productOrder;

import com.product.order.productOrder.service.OrderService;
import com.product.order.productOrder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductOrderApplication {

   @Autowired
   ProductService productService;

   @Autowired
   OrderService orderService;


   public static void main(String[] args) {
      SpringApplication.run(ProductOrderApplication.class, args);
   }


}
