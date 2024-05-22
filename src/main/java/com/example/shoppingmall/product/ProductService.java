package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    ProductRepository productRepository;

    public Product registerProduct(Product product) {
        System.out.println(
                "/products : service - " + product.getName());

        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteProducts(productIds);
    }
}
