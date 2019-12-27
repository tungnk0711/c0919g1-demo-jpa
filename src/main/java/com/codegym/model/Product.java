package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQuery( name="findAllProduct",
        query="select p from Product p")
@NamedQuery( name="findProductById",
        query="select p from Product p where p.id=:proId")
@NamedStoredProcedureQuery(
        name = "getAllProductsStoredProcedure",
        procedureName = "findAllProducts"
)
@NamedStoredProcedureQuery(
        name = "addProductStoredProcedure",
        procedureName = "addProduct",
        parameters = {
                @StoredProcedureParameter(name = "in_proname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "in_proprice", mode = ParameterMode.IN, type = Double.class),
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double price;

    public Product() {
    }

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
