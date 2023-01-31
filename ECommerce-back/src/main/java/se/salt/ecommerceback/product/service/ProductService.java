package se.salt.ecommerceback.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.product.model.Product;
import se.salt.ecommerceback.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product getById(String id) {
        return repo.getById(id);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
