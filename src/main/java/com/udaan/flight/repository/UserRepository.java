package com.udaan.flight.repository;

import com.udaan.flight.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String name);
    User findById(long id);
}
