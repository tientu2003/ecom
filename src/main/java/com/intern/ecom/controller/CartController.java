package com.intern.ecom.controller;

import com.intern.ecom.entity.product.Product;
import com.intern.ecom.entity.user.CartItem;
import com.intern.ecom.repository.product.ProductRepository;
import com.intern.ecom.repository.user.CartItemRepository;
import com.intern.ecom.support.ViewCartData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    final CartItemRepository CartItemRepository;

    final ProductRepository productRepository;

    public CartController(CartItemRepository CartItemRepository, ProductRepository productRepository) {
        this.CartItemRepository = CartItemRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ViewCartData> getCartItems(@Size(max = 40) @PathVariable String cartId) {
        Optional<List<CartItem>> cartItem = CartItemRepository.findAllByUuidCart_UuidCart(cartId);
        if(cartItem.isPresent()) {
            ViewCartData viewCartData = new ViewCartData();
            List<CartItem> cartItems = cartItem.get();
            viewCartData.setCartId(cartId);
            double totalPrice = 0;
            Map<String, Short> hashMap = new HashMap<String,Short>();
            for(CartItem e: cartItems) {
                Optional<Product> optionalProduct = productRepository.findById(e.getUuidProduct());
                totalPrice += e.getPrice();
                if(optionalProduct.isPresent()) {
                    Product product = optionalProduct.get();
                    hashMap.put(product.getTitle(), e.getQuantity());
                }
            }
            viewCartData.setTotalPrice(totalPrice);

            viewCartData.setProductList(hashMap);

            return ResponseEntity.ok().body(viewCartData);
        }else {
            return ResponseEntity.notFound().build();

        }
    }

//    @PostMapping("/{cartId}/products/")
//    public ResponseEntity<List<CartItem>> addProductToCart(
//            @Valid @PathVariable String cartId,
//            @RequestBody List<CartItem> cartItemList){
//
//
//    }
//
//    @PutMapping("{cartId}/products/")
//    public ResponseEntity<List<CartItem>> updateProductInCart(
//            @Valid @PathVariable String cartId,
//            @RequestBody List<CartItem> cartItemList){
//
//
//    }
}


