package com.example.micro.planner.users.mq.legacy;

//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(TodoBinding.class)
@Deprecated
public class MessageProducer {

//    private final TodoBinding todoBinding;
//
//    public MessageProducer(TodoBinding todoBinding) {
//        this.todoBinding = todoBinding;
//    }
//
//    public void initUserData(Long userId) {
//        Message<Long> message = MessageBuilder.withPayload(userId).build();
//        todoBinding.todoOutputChannel().send(message); // выбираем канал и отправляем сообщение
//    }
}
