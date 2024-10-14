# Planner Microservices

## Useful links
- eureka http://localhost:8761/
- gateway http://localhost:8765/
- config http://localhost:8888/
- todo http://localhost:8765/planner-todo/
- users http://localhost:8765/planner-users/

## Структура

```
├── dumps       дампы БД
├── planner-... соответсвующий сервис
├── postman     запросы
└── prop-test   файлы конфигурации в репозитории
```

## RabbitMQ

### Запуск
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10.7-management
```

### Авторизация
http://127.0.0.1:15672

guest/guest