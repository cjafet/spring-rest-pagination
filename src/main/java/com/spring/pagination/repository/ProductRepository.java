package com.spring.pagination.repository;

import com.spring.pagination.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
