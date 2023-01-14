package com.example.blogapplication.services;

import com.example.blogapplication.payloads.PostDto;
import com.example.blogapplication.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //Create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //Update
    PostDto updatePost(PostDto postDto, Integer postId);

    //getAll
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir); // pass pageNumber and pageSize as parameter for pagination and sortBy for sorting

    //getById

    PostDto getPostById(Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all post by category

    List<PostDto> getPostsByCategory(Integer categoryId);

    // get all post by User

    List<PostDto> getPostsByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keyword);
}
