package com.intern.ecom;

import com.intern.ecom.entity.attribute.ProductAttribute;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductAttributeTests {
    @Autowired
    TestRestTemplate restTemplate;
    ProductAttribute newProductAttribute;


    @BeforeEach
    public void setUp() {
        newProductAttribute = new ProductAttribute();
        newProductAttribute.setUuidAttribute("1");
        newProductAttribute.setUuidProduct("1");
    }

    @Test
    @Order(1)
    void shouldReturnAProductAttributeWhenNewOneCreated(){
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/product-attributes",
                newProductAttribute,
                String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String productId = documentContext.read("$.uuidProduct");
        assertThat(productId).isEqualTo("1");
        String attributeId = documentContext.read("$.uuidAttribute");
        assertThat(attributeId).isEqualTo("1");
    }

    @Test
    @Order(2)
    void shouldReturnAProductAttributeFindByProductId(){
        ResponseEntity<String> response =restTemplate.getForEntity(
                "/product-attributes/2",
                String.class
        );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String productId = documentContext.read("$.uuidProduct");
        assertThat(productId).isEqualTo("2");
        String attributeId = documentContext.read("$.uuidAttribute");
        assertThat(attributeId).isEqualTo("2");
    }

    @Test
    @Order(3)
    void shouldUpdatedProductAttribute(){
        ProductAttribute updated = new ProductAttribute();
        updated.setUuidAttribute("4");
        updated.setUuidProduct("1");
        updated.setValue("3");

        ResponseEntity<String> response = restTemplate.exchange(
                "/product-attributes",
                HttpMethod.PUT,
                new HttpEntity<>(updated)
                ,String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);

        DocumentContext documentContext = JsonPath.parse(response.getBody());

        String productId = documentContext.read("$.uuidProduct");
        assertThat(productId).isEqualTo("1");
        String attributeId = documentContext.read("$.uuidAttribute");
        assertThat(attributeId).isEqualTo("4");
        String updatedValue = documentContext.read("$.value");
        assertThat(updatedValue).isEqualTo("3");
    }

    @Test
    @Order(4)
    void shouldCanDeleteProductAttribute(){
        ResponseEntity<String> response = restTemplate.exchange(
                "/product-attributes/1",
                HttpMethod.DELETE,
                new HttpEntity<>(null),
                String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);

        ResponseEntity<String> response1 = restTemplate.getForEntity(
                "/product-attributes/1",
                String.class
        );

        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
