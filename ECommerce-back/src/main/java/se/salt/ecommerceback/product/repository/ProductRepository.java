package se.salt.ecommerceback.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.ecommerceback.product.model.Product;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepository {

    @Autowired
    ProductJPARepository repo;

    public Product getById(String id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(String id) {
        Product product = getById(id);
        repo.delete(product);
    }

    public void postProducts(List<Product> products) {
        repo.saveAll(products);
    }
}
