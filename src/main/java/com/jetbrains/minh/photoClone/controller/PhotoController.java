package com.jetbrains.minh.photoClone.controller;

import com.jetbrains.minh.photoClone.model.Photo;
import com.jetbrains.minh.photoClone.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController {

//    private List<Photo> photoList = List.of(new Photo("1", "hello.jpg"));
    @Autowired
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photo")
    public Iterable<Photo> getPhoto() {
        return photoService.getPhotos();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable Integer id) {
        return photoService.getPhoto(id);
    }

    @PostMapping("/photo")
    public Photo postPhoto(@RequestPart("data") MultipartFile file ) throws IOException {
        Photo photo = photoService.postPhoto(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }


    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.removePhoto(id);
    }
}
