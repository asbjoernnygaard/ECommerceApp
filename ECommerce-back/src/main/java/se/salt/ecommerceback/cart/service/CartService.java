package se.salt.ecommerceback.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.cart.model.AddCartProductDTO;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.cart.model.CartProduct;
import se.salt.ecommerceback.cart.model.CartResponseDTO;
import se.salt.ecommerceback.cart.repository.CartRepository;
import se.salt.ecommerceback.product.model.Product;
import se.salt.ecommerceback.product.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepo;

    @Autowired
    ProductRepository productRepo;

    public CartResponseDTO getById(String cartid) {
        Cart cart = cartRepo.getById(cartid);
        return new CartResponseDTO(cart.getId(), cart.getCartProducts());
    }

    public CartResponseDTO addCartProductToCart(String cartid, AddCartProductDTO dto) {
        Product product = productRepo.getById(dto.getProductId());
        CartProduct cartProduct = new CartProduct(product, dto.getQuantity());

        Cart cart = cartRepo.getById(cartid);
        cart.addCartProductToCart(cartProduct);

        Cart updatedCart = cartRepo.updateCart(cart);

        return new CartResponseDTO(updatedCart.getId(), updatedCart.getCartProducts());
    }
}
