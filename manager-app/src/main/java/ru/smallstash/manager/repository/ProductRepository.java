package ru.smallstash.manager.repository;

import ru.smallstash.manager.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);


}
