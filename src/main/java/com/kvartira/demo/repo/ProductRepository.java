package com.kvartira.demo.repo;

import com.kvartira.demo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {



}
