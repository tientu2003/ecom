package com.intern.ecom;

import com.intern.ecom.entity.attribute.ProductAttribute;
import com.intern.ecom.entity.product.Product;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnViewCartData(){
        ResponseEntity<String> response = this.restTemplate.getForEntity("/carts/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String cartId = documentContext.read("$.cartId");
        assertThat(cartId).isEqualTo("1");
        System.out.println(response.getBody());
    }

//    @Test
//    public void shouldAddProductToCart(){
//
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product());
//        ResponseEntity<String> response = this.restTemplate.postForEntity(
//                "/carts/1/products/",
//                productList,
//                String.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//
//        DocumentContext documentContext = JsonPath.parse(response.getBody());
//
//    }
}
