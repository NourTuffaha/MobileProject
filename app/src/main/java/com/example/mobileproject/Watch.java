package com.example.mobileproject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Watch {

    private String watch_id = "";
    private String brand = "";
    private String model = "";
    private String gender = "";
    private String aspect1 = "";
    private String aspect2 = "";
    private String aspect3 = "";
    private Double cost = 0.0;

    public Watch(){

    }

    public Watch(ResultSet row) {
        try {
            this.watch_id = row.getString("watch_id");
            this.brand = row.getString("brand");
            this.model = row.getString("model");
            this.gender = row.getString("gender");
            this.cost = row.getDouble("cost");
        } catch (SQLException e) {
            System.out.println();
        }
    }   
    public Watch(String brand, String model, String gender, Double cost) {
        this.brand = brand;
        this.model = model;
        this.gender = gender;
        this.cost = cost;

    }
    public Watch(String watch_id, String brand, String model, String gender, Double cost, String aspect1,String aspect2,String aspect3) {
        this.watch_id = watch_id;
        this.brand = brand;
        this.model = model;
        this.gender = gender;
        this.cost = cost;
        this.aspect1 = aspect1;
        this.aspect2 = aspect2;
        this.aspect3 = aspect3;
    }

    public String getWatch_id() {
        return watch_id;
    }

    public void setWatch_id(String watch_id) {
        this.watch_id = watch_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAspect1() {
        return aspect1;
    }

    public void setAspect1(String aspect1) {
        this.aspect1 = aspect1;
    }

    public String getAspect2() {
        return aspect2;
    }

    public void setAspect2(String aspect2) {
        this.aspect2 = aspect2;
    }

    public String getAspect3() {
        return aspect3;
    }

    public void setAspect3(String aspect3) {
        this.aspect3 = aspect3;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
