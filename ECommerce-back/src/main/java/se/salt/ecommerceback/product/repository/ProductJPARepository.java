package se.salt.ecommerceback.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salt.ecommerceback.product.model.Product;

public interface ProductJPARepository extends JpaRepository<Product, String> {
}
