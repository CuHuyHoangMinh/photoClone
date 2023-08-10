package com.jetbrains.minh.photoClone.service;

import com.jetbrains.minh.photoClone.model.Photo;
import com.jetbrains.minh.photoClone.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Iterator;

@Service
public class PhotoService {
    @Autowired
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public Photo getPhoto(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void removePhoto(Integer id) {

        photoRepository.deleteById(id);
    }

    public Photo postPhoto(String originalFilename, String contentType, byte[] bytes) {
        Photo photo = new Photo();
        photo.setFileName(originalFilename);
        photo.setData(bytes);
        photo.setContentType(contentType);
        photoRepository.save(photo);
        return photo;
    }
}
