package com.appstude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appstude.model.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByName(String name);

}