package com.example.blogapplication.controllers;

import com.example.blogapplication.payloads.FileResponse;
import com.example.blogapplication.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private FileService fileService;

    @Value("${project.image}") // path from the application.property file
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
        // try catch for exception
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            e.printStackTrace();

            return new ResponseEntity<FileResponse>(new FileResponse(null, "image is not uploaded due to server error !!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<FileResponse>(new FileResponse(fileName, "image is successfully uploaded"), HttpStatus.OK);
    }

        //Method to serve file
        @GetMapping(value = "/profiles/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
        public void serveImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {

            //The below 3 line code is for Serving (Download The Image )
            InputStream resource = this.fileService.getResource(path, imageName);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(resource, response.getOutputStream());


    }


}
