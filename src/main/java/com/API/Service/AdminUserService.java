package com.API.Service;

import com.API.domain.Car;
import com.API.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AdminUserService {      //для отправки/получения личных данных использовать стандартные методы из ProfileService
    public Boolean postUser(User user) {   //отправка отредактированого пользователя (пользователь должен быть целиком заполнен (т.е. получен с сервера и отредактирован))
        RestTemplate restTemplate = new RestTemplate();    //Если редактирование пароля не нужно ставте пользователю null вместо пароля
        String resourceUrl = "http://localhost:8080/user/redact";        //Метод редактирования для админа, можно отредактировать все (логин, пароль, роли)
        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public List<User> getUser(User user, String password) {        //получение списка пользователй (необходимо отправить пользователя с правами администратора)
        RestTemplate restTemplate = new RestTemplate();  //Необходим пароль для получения ответа сервера, как его получить без разницы, можете тянуть со входа заменяя поле password у user на тот пароль какой у него был
        user.setPassword(password);                       //Можете спрашивать
        String resourceUrl = "http://localhost:8080/user"; //Я отказываюсь от сервера совсем без защиты

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<User>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<User>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }
        return response.getBody();      //Вернет пустоту при отправке неправильно пользователя или пароля от этого пользователя
    }
}
