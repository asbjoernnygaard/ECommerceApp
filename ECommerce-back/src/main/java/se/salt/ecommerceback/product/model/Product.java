package se.salt.ecommerceback.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    String id = UUID.randomUUID().toString();

    @NonNull String name;
    @NonNull String description;
    @NonNull Float price;
    @NonNull Integer stock;

}
