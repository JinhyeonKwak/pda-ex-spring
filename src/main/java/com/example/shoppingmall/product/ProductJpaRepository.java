package com.example.shoppingmall.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    Slice<Product> findProducts(Pageable pageable);

    Slice<Product> findProductsByCategoryId(Integer categoryId, Pageable pageable);
}
