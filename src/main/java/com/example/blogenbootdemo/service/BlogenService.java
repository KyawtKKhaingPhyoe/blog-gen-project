package com.example.blogenbootdemo.service;

import com.example.blogenbootdemo.dao.CategoryDao;
import com.example.blogenbootdemo.dao.PostDao;
import com.example.blogenbootdemo.dao.UserDao;
import com.example.blogenbootdemo.ds.Category;
import com.example.blogenbootdemo.ds.Post;
import com.example.blogenbootdemo.ds.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BlogenService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    @GetMapping("/list-users")
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public List<Post> findAllPosts(){
        return postDao.findAll();
    }

    @Transactional
    public void savePost(Post post){
        post.setCategory(categoryDao.findById(post.getCategory().getId()).get());
        post.setUser(userDao.findById(post.getUser().getId()).get());
        postDao.save(post);
    }
}
