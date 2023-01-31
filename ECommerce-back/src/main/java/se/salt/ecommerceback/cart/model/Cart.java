package se.salt.ecommerceback.cart.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import se.salt.ecommerceback.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cart {

    @Id
    String id;

    @ToString.Exclude
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    User user;

    @OneToMany
    @JoinColumn(name = "cart_id")
    List<CartProduct> cartProducts = new ArrayList<>();


}