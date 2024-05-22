package com.example.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private int categoryId;

    // getter, setter
    // setter는 가능한 도메인 객체에는 만들면 안된다.
    // TODO setter는 DTO 등장하고. 지우러 오자!

}
