package com.example.blogenbootdemo.dao;

import com.example.blogenbootdemo.ds.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post,Integer> {
}
