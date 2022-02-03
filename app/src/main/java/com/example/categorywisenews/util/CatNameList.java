package com.example.categorywisenews.util;

import com.example.categorywisenews.models.CategoryModel;

import java.util.ArrayList;

public class CatNameList {
    ArrayList<CategoryModel> arrayList;
    ArrayList<CategoryModel> checkOutCat;
    public ArrayList<CategoryModel> getCategoryModelNameArrayList() {
        arrayList=new ArrayList<>();
        arrayList.add(new CategoryModel("https://images.unsplash.com/photo-1570126646281-5ec88111777f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1141&q=80", "Business"));
        arrayList.add(new CategoryModel("https://media.istockphoto.com/photos/the-musicians-were-playing-rock-music-on-stage-there-was-an-audience-picture-id1319479588", "Entertainment"));
        arrayList.add(new CategoryModel("https://images.unsplash.com/photo-1507925921958-8a62f3d1a50d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1176&q=80", "General"));
        arrayList.add(new CategoryModel("https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=799&q=80", "Health"));
        arrayList.add(new CategoryModel("https://media.istockphoto.com/photos/computer-hacker-with-icons-working-and-stealing-information-on-laptop-picture-id914796628?s=612x612", "Science"));
        arrayList.add(new CategoryModel("https://images.unsplash.com/photo-1579952363873-27f3bade9f55?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=735&q=80", "Sports"));
        arrayList.add(new CategoryModel("https://images.unsplash.com/photo-1485827404703-89b55fcc595e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80", "Technology"));
        return arrayList;
    }
}
