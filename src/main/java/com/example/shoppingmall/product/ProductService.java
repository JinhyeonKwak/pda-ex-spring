package com.example.shoppingmall.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productRepository;

    public Product registerProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
    }

    public Slice<Product> findProducts(int limit, int currentPage) {
        return productRepository.findAll(PageRequest.of(currentPage, limit));
    }

    public Slice<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProductsByCategoryId(categoryId, PageRequest.of(currentPage, limit));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteProducts(List<Long> productIds) {
        productRepository.deleteAllById(productIds);
    }
}
