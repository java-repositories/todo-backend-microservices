package com.example.micro.planner.todo.service;

import com.example.micro.planner.entity.Stat;
import com.example.micro.planner.todo.repo.StatRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// всегда нужно создавать отдельный класс Service для доступа к данным, даже если кажется,
// что мало методов или это все можно реализовать сразу в контроллере
// Такой подход полезен для будущих доработок и правильной архитектуры (особенно, если работаете с транзакциями)
@Service

// все методы класса должны выполниться без ошибки, чтобы транзакция завершилась
// если в методе возникнет исключение - все выполненные операции откатятся (Rollback)
@Transactional
public class StatService {

    private final StatRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(Long userId) {
        return repository.findByUserId(userId);
    }

}
