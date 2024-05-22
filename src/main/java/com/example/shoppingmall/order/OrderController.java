package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {
    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void orderProduct(@RequestBody OrderDTO orderDto) {
        Product orderdProduct = productService.findProduct(orderDto.getProductId());

        // TODO : Service로 이사 갈거에요. DTO -> Entity
        Order requestOrder = new Order(
                orderdProduct, orderDto.getCount()
        );
////        requestOrder.setId();
//        requestOrder.setProduct(orderdProduct);
//        requestOrder.setCount(orderDto.getCount());

        orderService.orderProduct(requestOrder);
    }
}
