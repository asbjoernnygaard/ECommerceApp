package se.salt.ecommerceback.cart.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import se.salt.ecommerceback.product.model.Product;

@Data
@Entity
public class CartProduct {

    @Id
    String id;

    @ManyToOne
    Product product;

    @NonNull Integer quantity;

}
