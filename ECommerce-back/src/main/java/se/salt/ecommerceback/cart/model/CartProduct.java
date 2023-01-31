package se.salt.ecommerceback.cart.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import se.salt.ecommerceback.product.model.Product;

import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartProduct {

    @Id
    String id = UUID.randomUUID().toString();

    @EqualsAndHashCode.Include
    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @NonNull
    Integer quantity;

}
