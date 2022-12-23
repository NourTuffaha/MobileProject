package com.example.mobileproject;

public class ModelClass {

    private int imageview;
    private String cost;
    private String model;
    //new code
    private int imageBtn;

    ModelClass(int imageview, String model, String cost, int imageBtn){
        this.imageview = imageview;
        this.model = model;
        this.cost = cost;
        this.imageBtn = imageBtn;
    }


    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getImageBtn() {
        return imageBtn;
    }

    public void setImageBtn(int imageBtn) {
        this.imageBtn = imageBtn;
    }
}