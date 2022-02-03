package com.example.categorywisenews.models;

public class CategoryModel {
    String imgCat, nameCat;

    public CategoryModel(String imgCat, String nameCat) {
        this.imgCat = imgCat;
        this.nameCat = nameCat;
    }

    public String getImgCat() {
        return imgCat;
    }

    public void setImgCat(String imgCat) {
        this.imgCat = imgCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }
}
