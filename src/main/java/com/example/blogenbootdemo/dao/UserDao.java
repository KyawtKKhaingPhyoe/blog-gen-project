package com.example.blogenbootdemo.dao;

import com.example.blogenbootdemo.ds.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
