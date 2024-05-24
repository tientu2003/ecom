package com.intern.ecom;

import com.intern.ecom.entity.attribute.ProductAttribute;
import com.intern.ecom.entity.product.Product;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.Instant;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTests {

    @Autowired
    TestRestTemplate restTemplate;
    Product newProduct;


    @BeforeEach
    void setUp(){
        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setUuidProduct("2");
        productAttribute.setUuidAttribute("2");
        productAttribute.setValue("3");
        newProduct = new Product(productAttribute, "Title1", (short) 0,1.1, (short) 2, Instant.now(), "1");
    }


    @Test
    @Order(1)
    public void shouldCreateNewProduct(){
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/products",
                newProduct,
                String.class
        );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @Order(2)
    public void shouldReturnCorrectProduct(){
        ResponseEntity<String> response = restTemplate.getForEntity(
                "/products/2",
                String.class
        );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String uuidProduct = documentContext.read("$.uuidProduct");
        assertThat(uuidProduct).isEqualTo("2");

        String title = documentContext.read("$.title");
        assertThat(title).isEqualTo("Title1");
    }

    @Test
    @Order(3)
    public void shouldCanUpdateProduct(){

        Product updated = new Product(newProduct.getProductAttribute(), "Title2", (short) 0,1.1, (short) 2, Instant.now(), "1");

        ResponseEntity<String> response = restTemplate.exchange(
                "/products",
                HttpMethod.PUT,
                new HttpEntity<>(updated)
                ,String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);

        DocumentContext documentContext = JsonPath.parse(response.getBody());

        String title = documentContext.read("$.title");
        assertThat(title).isEqualTo("Title2");
    }

    @Test
    @Order(4)
    public void shouldCanDeleteProduct(){
        ResponseEntity<String> response = restTemplate.exchange(
                "/products/2",
                HttpMethod.DELETE,
                new HttpEntity<>(null),
                String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);

        ResponseEntity<String> response1 = restTemplate.getForEntity(
                "/products/2",
                String.class
        );

        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
