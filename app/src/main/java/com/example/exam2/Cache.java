package com.example.exam2;

import java.util.ArrayList;
import java.util.Vector;

public class Cache {

    private int money = 0;

    private int cntEspreso = 0;
    private int cntLatte = 0;
    private int cntAmericano = 0;

    private ArrayList<String> sellList = new ArrayList<>();


    public int getMoney() {
        return money;
    }

    public void AddMoney(int money) {
        this.money = this.money + money;
    }

    public int getCntEspreso() {
        return cntEspreso;
    }

    private void AddCntEspreso(int cntEspreso) {
        this.cntEspreso = this.cntEspreso + cntEspreso;
    }

    public int getCntLatte() {
        return cntLatte;
    }

    private void AddCntLatte(int cntLatte) {
        this.cntLatte =  this.cntLatte + cntLatte;
    }

    public int getCntAmericano() {
        return cntAmericano;
    }

    private void AddCntAmericano(int cntAmericano) {
        this.cntAmericano = this.cntAmericano + cntAmericano;
    }

    public ArrayList<String> getSellList() {
        return sellList;
    }

    public void AddSellList(String coffee) {
        sellList.add(coffee);
    }

    public void onAddCntCoffee(int type){
        switch (type)
        {
            case 0:
                AddCntEspreso(1);
                break;

            case 1:
                AddCntLatte(1);
                break;

            case 2:
                AddCntAmericano(1);
                break;
        }
    }

}
