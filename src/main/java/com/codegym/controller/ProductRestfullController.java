package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.IProductSpringDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestfullController {

    @Autowired
    IProductSpringDataService productService;

    //-------------------Retrieve All Products--------------------------------------------------------

    @RequestMapping(value = "/products/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = (List<Product>)productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
