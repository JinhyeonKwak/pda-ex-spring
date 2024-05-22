package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {

        if(Validator.isAlpha(product.getName()) &&
                Validator.isNumber(product.getPrice())) {
            log.info(product.getName());

            Product savedProduct = productService.registerProduct(product);

            try {
                log.info(savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value="id") int id) {
        if(!Validator.isNumber(id)) {
//            Logger log = LoggerFactory.getLogger(ProductController.class);
            log.info(id + " haha");
            log.trace("id {}", "haha");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product resultProduct = productService.findProduct(id);

        if(resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(resultProduct, HttpStatus.OK);
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
        ) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        // TODO null 체크는 어디서 해야할까?
        if(categoryId == null) {
            List<Product> products = productService.findProducts(limit, currentPage);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            List<Product> products = productService.findProducts(limit, currentPage, categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
        if(!Validator.isNumber(id))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        productService.deleteProduct(id);
        Product product = productService.findProduct(id);

        if(product == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/products/delete")
    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {

        List<Integer> productIds = deleteRequest.get("productIds");

        if (productIds.isEmpty()) {
            log.info("productIds가 없어..");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
