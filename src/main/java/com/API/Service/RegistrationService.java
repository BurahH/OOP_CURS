package com.API.Service;

import com.API.domain.User;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RegistrationService {

    public User postLogin(String username, String password) {            //псевдо вход возвращает null если он не успешен либо пользователя усли успешен
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/login";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity<User> request = new HttpEntity<User>(new User(username, password, true));

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public boolean postRegistration(String username, String password){          //возвращает true если успешная регистрация или false если такой login уже существует
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/registration";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity<User> request = new HttpEntity<User>(new User(username, password, true));

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        System.out.println(response.getBody());
        return response.getBody();
    }


}
