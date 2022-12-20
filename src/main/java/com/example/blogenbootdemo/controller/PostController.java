package com.example.blogenbootdemo.controller;

import com.example.blogenbootdemo.ds.Category;
import com.example.blogenbootdemo.ds.Post;
import com.example.blogenbootdemo.ds.User;
import com.example.blogenbootdemo.service.BlogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private BlogenService blogenService;

    @GetMapping({"/","/home"})
    public String index(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("user",new User());
        model.addAttribute("post",new Post());
        return "dashboard";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors())
            return "dashboard";
        blogenService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/list-categories")
    public String listCategories(Model model,@ModelAttribute("categories")List<Category>categories){
        model.addAttribute("categories",categories);
        return "list-categories";
    }

    @GetMapping("/list-users")
    public String ListAllUsers(Model model,@ModelAttribute("users")List<User> users){
        model.addAttribute("users",users);
        return "list-users";
    }

    @GetMapping("/list-posts")
    public String ListPosts(Model model,@ModelAttribute("posts")List<Post> posts){
        model.addAttribute("posts",posts);
        return "list-posts";
    }

    @PostMapping("/save-user")
    public String saveUser(User user,BindingResult result){
        if(result.hasErrors()){
            return "dashboard";
        }
        blogenService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/save-post")
    public String savePost(Post post,BindingResult result){
        if(result.hasErrors()){
            return "dashboard";
        }
        blogenService.savePost(post);
        return "redirect:/";
    }

    @ModelAttribute("categories")
    public List<Category> listCategories(){
        return blogenService.findAllCategories();
    }

    @ModelAttribute("users")
    public List<User> listUsers(){
        return blogenService.findAllUsers();
    }

    @ModelAttribute("posts")
    public List<Post> listPosts(){
        return blogenService.findAllPosts();
    }

}
