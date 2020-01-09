package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.IProductSpringDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

@Controller
public class ProductController {

    /*@Autowired
    IProductService productService;*/

    @Autowired
    IProductSpringDataService productSpringDataService;

    @RequestMapping("/products")
    public ModelAndView getAllProduct() {

        long kq = productSpringDataService.countByName("Motorola");

        Iterable<Product> p = productSpringDataService.findByName("Samsung");

        //List<Product> products = productService.findAll();
        Iterable<Product> products = productSpringDataService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView addProduct() {

        //add Product to database
        Product product = new Product("Samsung", 4000d);
        //productService.add(product);
        productSpringDataService.add(product);

        ModelAndView modelAndView = new ModelAndView("/product/list");
        return modelAndView;
    }

    @RequestMapping("/findbyid")
    public ModelAndView findById() {

        //Product product = productService.findById(Long.parseLong("3"));
        Product product = productSpringDataService.findById(Long.parseLong("3"));

        ModelAndView modelAndView = new ModelAndView("/product/list");
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping("/save-product")
    public ModelAndView saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/product/create");
            return modelAndView;
        }

        productSpringDataService.add(product);

        ModelAndView modelAndView = new ModelAndView("/product/create");
        return modelAndView;
    }


}
