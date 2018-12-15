package com.example.fkocak.notificationmanager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("images")
    @Expose
    private List<Image4Random> images = null;

    public List<Image4Random> getImages() {
        return images;
    }

    public void setImages(List<Image4Random> images) {
        this.images = images;
    }

}