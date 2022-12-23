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
    private String image = "";

    public Watch(){

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
        this.image = watch_id;
    }

    protected Watch(Parcel in) {
        watch_id = in.readString();
        brand = in.readString();
        model = in.readString();
        gender = in.readString();
        aspect1 = in.readString();
        aspect2 = in.readString();
        aspect3 = in.readString();
        if (in.readByte() == 0) {
            cost = null;
        } else {
            cost = in.readDouble();
        }
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
        dest.writeString(aspect1);
        dest.writeString(aspect2);
        dest.writeString(aspect3);
        if (cost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(cost);
        }
    }
}
