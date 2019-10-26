package com.shbaek.webservice.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class webControllerTest {

    // arrange
    @Autowired
    private TestRestTemplate testRestTemplate;


    // action
    @Test
    public void 메인페이지_로딩() {

        String body = this.testRestTemplate.getForObject("/", String.class);

        // assert
        assertThat(body, Matchers.anything("스프링"));

    }


}
