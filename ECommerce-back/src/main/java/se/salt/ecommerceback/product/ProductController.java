package se.salt.ecommerceback.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.salt.ecommerceback.product.model.AddProductDTO;
import se.salt.ecommerceback.product.model.Product;
import se.salt.ecommerceback.product.service.ProductService;
import se.salt.ecommerceback.user.model.Role;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<Page<Product>> getPaginatedProducts(@RequestParam(defaultValue = "0") String page,
                                                              @RequestParam(defaultValue = "12") String limit) {
        return ResponseEntity.ok(service.getPaginatedProducts(Integer.parseInt(page), Integer.parseInt(limit)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        try {
            Product product = service.getById(id);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // @PreAuthorize("principal.authorities == 'ADMIN'")
    @PostMapping
    public ResponseEntity<Void> postProducts(@RequestBody List<AddProductDTO> dtos) {
        service.postProducts(dtos);
        return ResponseEntity.created(URI.create("/products/PRODUCT_ID")).build();
    }


    @PreAuthorize("principal.authorities == 'ADMIN'")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
