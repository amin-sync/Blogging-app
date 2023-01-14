package com.example.blogapplication.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public interface FileService {
    String uploadImage(String path, MultipartFile file) throws IOException;

    InputStream getResource (String path , String fileName) throws FileNotFoundException;

}
