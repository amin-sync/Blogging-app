package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
