package com.product.order.productOrder.repository;

import com.product.order.productOrder.dto.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {
}