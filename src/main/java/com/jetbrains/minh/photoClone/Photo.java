package com.jetbrains.minh.photoClone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }
    @NotEmpty
    private String fileName;

    public String getId() {
        return id;
    }

    public Photo() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
