package com.example.exam2;

public class Coffee {

    private String Name;

    private int type = 0; // 0 에스프레소 , 1 라떼 , 2 아메리카노
    private int beans;
    private int water;

    private int price;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void onSetBeans(int beans){
        this.beans = beans;
    }

    public int onGetBeans(){
        return beans;
    }

    public void onSetWater(int water){
        this.water = water;
    }

    public int onGetWater(){
        return water;
    }

    public void onSetPrice(int price){
        this.price = price;
    }

    public int onGetPrice(){
        return price;
    }

}
