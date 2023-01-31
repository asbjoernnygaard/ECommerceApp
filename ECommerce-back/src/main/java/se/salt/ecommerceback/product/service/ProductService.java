package se.salt.ecommerceback.product.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.product.model.AddProductDTO;
import se.salt.ecommerceback.product.model.Product;
import se.salt.ecommerceback.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    @Autowired
    ModelMapper mapper;

    public Product getById(String id) {
        return repo.getById(id);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }

    public void postProducts(List<AddProductDTO> dtos) {
        List<Product> products = dtos.stream().map(dto -> mapper.map(dto, Product.class)).toList();
        repo.postProducts(products);
    }

    public Page<Product> getPaginatedProducts(int page, int limit) {
        return repo.getPaginatedProducts(page, limit);
    }
}
