package com.API.Service;

import com.API.domain.Personal;
import com.API.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class profileService {

    public Personal postPersonal(User user, int age, String name) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/personal";

        HttpEntity<Personal> request = new HttpEntity<Personal>(new Personal(age, name, user));

        ResponseEntity<Personal> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Personal.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }
}
