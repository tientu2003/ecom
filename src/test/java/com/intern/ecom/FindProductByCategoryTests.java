package com.intern.ecom;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindProductByCategoryTests {

    @Autowired
    TestRestTemplate restTemplate;
    @Test
    public void findProductByCategory(){
        ResponseEntity<String> response = restTemplate.getForEntity("/product-category/category/DVD", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        DocumentContext documentContext = JsonPath.parse(response.getBody());
//        String name = documentContext.read("$.title");
//        assertThat(name).isEqualTo("EFGDDF");
        System.out.println(response.getBody());

    }
}
