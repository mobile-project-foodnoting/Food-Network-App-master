package com.example.myapplication;

import android.location.Location;
import android.media.Image;

import java.io.Serializable;

public class myItem implements Serializable {
//    Image myImage;
    String nameFood;
    String price;
    String Checkin;
    String Location;
    String phoneNumber;
    //friend attribute
    public myItem()//defaultConstructor
    {
        nameFood="Change Food Name Here";
        phoneNumber="Enter Phone Number";
        Location="Change Location Here";
    }
    public myItem(String nameFood,String location,String phoneNumber,String Checkin,String price)
    {
        this.nameFood=nameFood;
        this.phoneNumber=phoneNumber;
        this.Location=location;
        this.Checkin=Checkin;
        this.price=price;
    }
    public myItem(myItem myItemIn)
    {
        nameFood=myItemIn.nameFood;
        Location=myItemIn.Location;
        phoneNumber=myItemIn.phoneNumber;
        price=myItemIn.price;
        Checkin=myItemIn.Checkin;
    }
//    public void setMyImage(Image in)
//    {
//        myImage=in;
//    }
//    public void setPrice(String price)
//    {
//        this.price=price;
//    }
    public void setNameFood(String nameFood)
    {
        this.nameFood=nameFood;
    }
//    public void setFoodLocation(Location foodLocation)
//    {
//        this.foodLocation=foodLocation;
//    }
    public void setPhonenNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
}
