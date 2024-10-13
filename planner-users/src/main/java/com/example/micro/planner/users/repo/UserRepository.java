package com.example.micro.planner.users.repo;

import com.example.micro.planner.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // возвращает только либо 0 либо 1 объект, т.к. email уникален для каждого пользователя
    User findByEmail(String email); // email уникально для всей таблицы

    void deleteByEmail(String email); // строгое соотвествие email (не вхождени)

    @Query("SELECT u FROM User u where " +
            "(:email is null or :email='' or lower(u.email) like lower(concat('%', :email,'%'))) and" +
            " (:username is null or :username='' or lower(u.username) like lower(concat('%', :username,'%')))"
    )

        // искать по всем переданным параметрам (пустые параметры учитываться не будут)
    Page<User> findByParams(@Param("email") String email,
                            @Param("username") String username,
                            Pageable pageable
    );

}

