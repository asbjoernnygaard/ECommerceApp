package se.salt.ecommerceback.product.model;

import lombok.Value;

@Value
public class AddProductDTO {
    String name;
    String description;
    String price;
    Integer stock;
}
