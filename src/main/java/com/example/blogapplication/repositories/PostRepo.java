package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Category;
import com.example.blogapplication.models.Post;
import com.example.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
