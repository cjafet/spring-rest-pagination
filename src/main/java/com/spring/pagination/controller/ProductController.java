package com.spring.pagination.controller;

import com.spring.pagination.exception.PageNotFoundException;
import com.spring.pagination.model.Product;
import com.spring.pagination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedModel<EntityModel<Product>>> findProducts(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Product> resultPage = productService.getAllProductsPaginated(page, size);

        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(resultPage);

        if (page >= resultPage.getTotalPages()) {
            System.out.println("Page does not exist");
            System.out.println("Number of pages: " + resultPage.getTotalPages());
            throw new PageNotFoundException();
        }

        return new ResponseEntity<PagedModel<EntityModel<Product>>>(pagedModel, HttpStatus.OK);
    }
}
