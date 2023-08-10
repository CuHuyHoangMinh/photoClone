package com.jetbrains.minh.photoClone.repository;

import com.jetbrains.minh.photoClone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
