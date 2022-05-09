package com.spring.pagination.service;

import com.spring.pagination.model.Product;
import com.spring.pagination.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getAllProductsPaginated(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Product> getAllProductsPaginatedAndSorted(int page, int size, String filter) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by(filter)));
    }

}
