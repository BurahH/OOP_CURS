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

    public User postPersonal(User user, Personal personal) {          //отправка новых персональных данных или их редактирование(в этом случае необходимо наличие id у класса personal)
        personal.setUser(user);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/personal";

        HttpEntity<Personal> request = new HttpEntity<Personal>(personal);

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public Personal getPersonal(User user) {                    //получить личные данные конкретного пользователя
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

    public User postPhone(User user, Phone phone) {          //отправка нового номера телефона
        phone.setUser(user);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/phone";

        HttpEntity<Phone> request = new HttpEntity<Phone>(phone);

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public List<Phone> getPhone(User user) {           //получение номеров пользователя
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/phone/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<Phone>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<Phone>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public Boolean deletePhone(Phone phone) {        //удаление телефона пользователя
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

    public Boolean postMessage(User user, Message message, String recipient) {      //recipient - username получателя сообщения
        message.setUser(user);
        message.setAuthor(recipient);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/message/find";

        HttpEntity<Message> request = new HttpEntity<Message>(message);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody(); //При успешной отправке возвращает true при отсутствие пользователя с таким username - false
    }

    public List<Message> getMessage(User user) {                //получения всех сообщений для пользователя
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/message/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<Message>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<Message>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public Boolean deleteMessage(Message message) {      //удаление сообщения конкретного пользователя
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/message/delete";

        HttpEntity<Message> request = new HttpEntity<Message>(message);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public Boolean redactUser(User user, String password) {          //отправка отредактировано пользователя (необходим текущий пароль пользователя), редактирование логина запрещено
        user.setUsername(password);                                               //Новый пароль добавляйте в класс
        RestTemplate restTemplate = new RestTemplate();                           //Метод для обычного пользователя отредактировать себя (Пока можно изменить только свой пароль)
        String resourceUrl = "http://localhost:8080/profile/redact/user";         //Контролируйте что введен новый пароль в класс иначе бан пользователя

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();     //если false значит ошибка в текущем пароле
    }
}
