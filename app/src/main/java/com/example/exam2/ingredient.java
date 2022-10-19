package com.example.exam2;

public class ingredient {

    private int beans = 10000;
    private int water = 10000;
    private int milk = 5000;


    public void Addbeans(int beans){
        this.beans = this.beans + beans;
    }

    public void Minusbeans(int beans){
       this.beans = this.beans - beans;
    }

    public int onGetBeans(){
        return beans;
    }


    public void Addwater(int water){
        this.water = this.water + water;
    }

    public void Minuswater(int water){
        this.water = this.water - water;
    }

    public int onGetWater(){
        return water;
    }



    public void AddMilk(int milk){
        this.milk = this.milk + milk;
    }

    public void MinusMilk(int milk){
        this.milk = this.milk - milk;
    }

    public int onGetMilk(){
        return milk;
    }

}
