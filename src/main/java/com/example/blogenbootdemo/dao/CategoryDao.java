package com.example.blogenbootdemo.dao;

import com.example.blogenbootdemo.ds.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
