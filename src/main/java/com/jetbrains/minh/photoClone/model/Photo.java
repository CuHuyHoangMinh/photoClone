package com.jetbrains.minh.photoClone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTO")
public class Photo {
    @Id
    private Integer id;
    @JsonIgnore
    private byte[] data;

    private String contentType;

//    public Photo(Integer id, String contentType, String fileName) {
//        this.id = id;
//        this.contentType = contentType;
//        this.fileName = fileName;
//    }

//    public Photo(String id, String fileName) {
//        this.id = id;
//        this.fileName = fileName;
//    }
    @NotEmpty
    private String fileName;

    public Integer getId() {
        return id;
    }

    public Photo() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
