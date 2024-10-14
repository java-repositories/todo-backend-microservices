package com.example.micro.planner.todo.mq.func;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import com.example.micro.planner.todo.service.TestDataService;

import java.util.function.Consumer;


// spring считывает бины и создает соотв. каналы
// описываются все каналы с помощью функциональных методов
// этот способ - рекомендуемый, вместо старого способа (@Binding, интерфейсы)
@Configuration
public class MessageFunc {

    // для заполнения тестовых данных
    private TestDataService testDataService;

    public MessageFunc(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    // получает id пользователя и запускает создание тестовых данных
    // название метода должно совпадать с настройками definition и bindings в файлах properties (или yml)
    @Bean
    public Consumer<Message<Long>> newUserActionConsume() {
        return message -> testDataService.initTestData(message.getPayload());
    }
}



