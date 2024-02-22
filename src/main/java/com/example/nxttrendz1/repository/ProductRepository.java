package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.repository.ProductRepository;

import com.example.nxttrendz1.model.Product;
import java.util.*;

public interface ProductRepository {

    public ArrayList<Product> getAllProduct();

    public Product getAllProductById(int productId);

    public Product createProduct(Product product);

    public Product UpdateProduct(int productId, Product product);

    public void DeleteProduct(int productId);
}