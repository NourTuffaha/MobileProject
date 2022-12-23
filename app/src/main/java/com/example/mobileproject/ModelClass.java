package com.example.mobileproject;

public class ModelClass {

    private int imageview;
    private String watchname;
    private String price;
    private String quantity;
    //new code
    private String imageBtn;



    ModelClass(int imageview , String watchname, String price, String quantity, String imageBtn)
    {
        this.imageview=imageview;
        this.watchname=watchname;
        this.price=price;
        this.quantity=quantity;
        this.imageBtn=imageBtn;
    }

    public int getImageview() {
        return imageview;
    }

    public String getwatchname() {
        return watchname;
    }

    public String getimageBtn()
    {
        return imageBtn;
    }


    public String getprice() {
        return price;
    }

    public String getquantity() {
        return quantity;
    }


}
