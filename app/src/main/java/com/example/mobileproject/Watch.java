package com.example.mobileproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Watch implements Parcelable {

    private String watch_id = "";
    private String brand = "";
    private String model = "";
    private String gender = "";
    private String aspect1 = "";
    private String aspect2 = "";
    private String aspect3 = "";
    private Double cost = 0.0;
    private int stock;
    private int sold;
    private String mainImageUrl;


    public Watch() {

    }

    public Watch(String watch_id, String brand, String model, String gender, double cost, String aspect1, String aspect2, String aspect3, int stock, int sold, String mainImageUrl) {
        this.watch_id = watch_id;
        this.brand = brand;
        this.model = model;
        this.gender = gender;
        this.cost = cost;
        this.aspect1 = aspect1;
        this.aspect2 = aspect2;
        this.aspect3 = aspect3;
        this.stock = stock;
        this.sold = sold;
        this.mainImageUrl = mainImageUrl;
    }
//    public Watch(String watch_id, String brand, String model, String gender, Double cost, String aspect1,String aspect2,String aspect3) {
//        this.watch_id = watch_id;
//        this.brand = brand;
//        this.model = model;
//        this.gender = gender;
//        this.cost = cost;
//        this.aspect1 = aspect1;
//        this.aspect2 = aspect2;
//        this.aspect3 = aspect3;
//        this.image = watch_id;
//    }


    @Override
    public String toString() {
        return "Watch{" +
                "watch_id='" + watch_id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", gender='" + gender + '\'' +
                ", aspect1='" + aspect1 + '\'' +
                ", aspect2='" + aspect2 + '\'' +
                ", aspect3='" + aspect3 + '\'' +
                ", cost=" + cost +
                ", stock=" + stock +
                ", sold=" + sold +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                '}';
    }

    protected Watch(Parcel in) {
        watch_id = in.readString();
        brand = in.readString();
        model = in.readString();
        gender = in.readString();
        cost = in.readDouble();
        aspect1 = in.readString();
        aspect2 = in.readString();
        aspect3 = in.readString();
        stock = in.readInt();
        sold = in.readInt();
        mainImageUrl = in.readString();
    }

    public static final Creator<Watch> CREATOR = new Creator<Watch>() {
        @Override
        public Watch createFromParcel(Parcel in) {
            return new Watch(in);
        }

        @Override
        public Watch[] newArray(int size) {
            return new Watch[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(watch_id);
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeString(gender);
        dest.writeString(String.valueOf(cost));
        dest.writeString(aspect1);
        dest.writeString(aspect2);
        dest.writeString(aspect3);
        dest.writeInt(stock);
        dest.writeInt(sold);
        dest.writeString(mainImageUrl);
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


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }


}
