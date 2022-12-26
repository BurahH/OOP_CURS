package com.API.Service;

import com.API.domain.Message;
import com.API.domain.Personal;
import com.API.domain.Phone;
import com.API.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProfileService {

    public User postPersonal(User user, int age, String name) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/personal";

        HttpEntity<Personal> request = new HttpEntity<Personal>(new Personal(age, name, user));

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public Personal getPersonal(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/personal/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<Personal> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Personal.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public User postPhone(User user, String number) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/phone";

        HttpEntity<Phone> request = new HttpEntity<Phone>(new Phone(number, user));

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public List<Phone> getPhone(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/phone/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<Phone>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<Phone>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }
        System.out.println(response.getBody());
        return response.getBody();
    }

    public Boolean deletePhone(Phone phone) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/phone/delete";

        HttpEntity<Phone> request = new HttpEntity<Phone>(phone);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public User postMessage(User user, String mes) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/message/find";

        HttpEntity<Message> request = new HttpEntity<Message>(new Message(mes, user));

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public List<Message> getMessage(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/message/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<Message>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<Message>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }
        System.out.println(response.getBody());
        return response.getBody();
    }
}
