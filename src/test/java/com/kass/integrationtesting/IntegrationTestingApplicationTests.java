package com.kass.integrationtesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestingApplicationTests {

     @LocalServerPort
     private int port;

     @Autowired
     private TestRestTemplate testRestTemplate;

    @Test
    void testCustomerController () {
        String url="http://localhost:"+port+"/getAllCustomer";
        List<Customer> customer=testRestTemplate.getForObject(url,List.class);
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(3,customer.size());


    }

}
