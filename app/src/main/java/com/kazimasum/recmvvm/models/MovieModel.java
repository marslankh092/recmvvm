package com.kazimasum.recmvvm.models;

public class MovieModel
{
    //http://192.168.100.199/api/json_user_fetch.php
   String name;
   String image;

    public MovieModel() {
    }

    public MovieModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
