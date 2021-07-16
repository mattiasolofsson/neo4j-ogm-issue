package com.example.ogmsample;

import com.example.ogmsample.boundary.DesignResult;
import com.example.ogmsample.entity.Design;
import com.example.ogmsample.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApplicationTest {

    private UUID designId = UUID.fromString("2e3e61eb-7725-4c0a-93be-219c8961ad92");

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testResolver() {
        Product product = new Product();
        Design design = new Design(designId);
        product.setDesign(design);
        DesignResult designResult = restTemplate.postForObject("http://localhost:" + port + "/designs/" + designId.toString() + "/products", product, DesignResult.class, designId);
        System.out.println("designResult = " + designResult);
    }
}
