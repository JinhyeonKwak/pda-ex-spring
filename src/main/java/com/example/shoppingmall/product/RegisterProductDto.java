package com.example.shoppingmall.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterProductDto {

    @NotBlank(message = "{product.name.blank}")
    private String name;

    @Range(min = 0, max = 99999999, message = "{product.price.range}")
    private Integer price;

    private String description;

    @NotNull(message = "{product.categoryId.null}")
    private Integer categoryId;

    public Product toEntity() {
        return new Product(null, name, price, description, categoryId);
    }
}
