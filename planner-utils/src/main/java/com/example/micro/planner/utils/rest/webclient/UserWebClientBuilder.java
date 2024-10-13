package com.example.micro.planner.utils.rest.webclient;

import com.example.micro.planner.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component

// спец. класс для вызова микросервисов пользователей с помощью WebClient
public class UserWebClientBuilder {

    private static final String baseUrl = "http://localhost:8765/planner-users/user/";

    // проверка - существует ли пользователь
    public boolean userExists(Long userId) {

        try {

            User user = WebClient.create(baseUrl)
                    .post()
                    .uri("id")
                    .bodyValue(userId)
                    .retrieve()
                    .bodyToFlux(User.class)
                    .blockFirst(); // блокирует поток до получения 1й записи

            if (user != null) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
