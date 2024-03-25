package ru.smallstash.manager.service;

import ru.smallstash.manager.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(int productId);
}
