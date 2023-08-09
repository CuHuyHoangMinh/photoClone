package com.jetbrains.minh.photoClone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class photoController {

//    private List<Photo> photoList = List.of(new Photo("1", "hello.jpg"));
    private Map<String, Photo> db= new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg") );
    }};
    private int id = 2;
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> getPhoto() {
        return db.values();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable String id) {
        if (!db.containsKey(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return db.get(id);
    }

    @PostMapping("/photo/")
    public Photo postPhoto(@RequestPart("data") MultipartFile file ) {
        Photo photo = new Photo();
        photo.setId(String.valueOf(this.id));
        db.put(String.valueOf(id),photo);
        id++;
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id) {
        Photo photo  = db.remove(id);
        if (photo == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
