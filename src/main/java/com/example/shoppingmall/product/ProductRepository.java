package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable
            = new HashMap<>();
    int id = 0; // DB auto_increment

    public Product save(Product product) {
        product.setId(id++);

        productTable.put(product.getId(), product);
        System.out.println(
                "/products : repository - " + productTable.get(id-1));

        return productTable.get(id-1);
    }

    public Product findProduct(int id) {
        return productTable.get(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productTable.values().stream().toList();
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        List<Product> resultProducts = new ArrayList<>();

        for (Product product : productTable.values()) {
            if (product.getCategoryId() == categoryId)
                resultProducts.add(product);
        }

        return resultProducts;
    }

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for (int idx = 0; idx < productIds.size(); idx++) {
            productTable.remove(productIds.get(idx));
        }
    }
}
