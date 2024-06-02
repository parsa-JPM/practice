package com.example.interview_practice.mockmvc.model;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByName(String name);

    // to load this attribute with Join (single query) and avoid n+1 problem
    @EntityGraph(attributePaths = {"sendTransactions", "recTransactions"})
    List<User> findAll();
}