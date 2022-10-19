package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener , View.OnClickListener {


    ingredient ingredient = null;
    Cache cache = null;

    espreso espreso = null;
    latte latte = null;
    americano americano = null;



    Button m_btn_ingredientReport;
    Button m_btn_calculateReport;
    Button m_btn_espreso;
    Button m_btn_latte;
    Button m_btn_americano;

    TextView m_tv_label;

    ListView listView;

    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onMakeModel();

        oninit();
        oninitAdpater();
        onAddItem();


    }

    private void onMakeModel()
    {
        ingredient = new ingredient();
        cache = new Cache();

        espreso = new espreso();
        espreso.setType(0);
        espreso.setName("에스프레소");
        espreso.onSetBeans(100);
        espreso.onSetWater(30);
        espreso.onSetPrice(4000);

        latte = new latte();
        latte.setType(1);
        latte.setName("라뗴");
        latte.onSetBeans(100);
        latte.onSetWater(70);
        latte.onSetMilk(30);
        latte.onSetPrice(5000);

        americano = new americano();
        americano.setType(2);
        americano.setName("아메리카노");
        americano.onSetBeans(100);
        americano.onSetWater(100);
        americano.onSetPrice(4500);

    }

    private void oninit(){

        m_btn_ingredientReport = (Button) findViewById(R.id.btn_ingredientReport);
        m_btn_calculateReport = (Button) findViewById(R.id.btn_calculateReport);
        m_btn_espreso = (Button) findViewById(R.id.btn_espreso);
        m_btn_latte = (Button) findViewById(R.id.btn_latte);
        m_btn_americano = (Button) findViewById(R.id.btn_americano);

        m_tv_label = (TextView) findViewById(R.id.tv_label);

        listView = (ListView) findViewById(R.id.listview);

        m_btn_ingredientReport.setOnClickListener(this);
        m_btn_calculateReport.setOnClickListener(this);
        m_btn_espreso.setOnClickListener(this);
        m_btn_latte.setOnClickListener(this);
        m_btn_americano.setOnClickListener(this);
    }

    private void oninitAdpater()
    {
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }

    private void onAddItem()
    {
        myAdapter.clear();

        myAdapter.add(espreso);
        myAdapter.add(latte);
        myAdapter.add(americano);


        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_ingredientReport:
                m_tv_label.setText("");
                oningredientReport();
                break;
            case R.id.btn_calculateReport:
                m_tv_label.setText("");
                oncalculateReport();
                break;
            case R.id.btn_espreso:
                onespreso();
                break;
            case R.id.btn_latte:
                onlatte();
                break;
            case R.id.btn_americano:
                onAmericano();
                break;
        }
    }

    public void oningredientReport()
    {
        int have_beans = ingredient.onGetBeans();
        int have_water = ingredient.onGetWater();
        int have_milk = ingredient.onGetMilk();

        m_tv_label.append("남은 원두 : " + have_beans + "\n" );
        m_tv_label.append("남은 물 :  " + have_water + "\n" );
        m_tv_label.append("남은 우유 : " + have_milk + "\n");
    }

    public void oncalculateReport()
    {
        int money = cache.getMoney();
        int cntEspreso = cache.getCntEspreso();
        int cntLatte = cache.getCntLatte();
        int cntAmericano = cache.getCntAmericano();
        ArrayList<String> arrayList = cache.getSellList();

        m_tv_label.append("수익금 : " + money + "\n" );
        m_tv_label.append("에스프레소 판매량 : " + cntEspreso + "\n" );
        m_tv_label.append("라떼 판매량 : " + cntLatte + "\n");
        m_tv_label.append("아메리카노 판매량 : " + cntAmericano + "\n");

        m_tv_label.append("판매리스트 : " +"\n");

        for(String name : arrayList){
            m_tv_label.append(name + ",");
        }
    }

    public void onespreso()
    {
        if(ingredient.onGetBeans() >= espreso.onGetBeans()
                && ingredient.onGetWater() >= espreso.onGetWater()){
            m_tv_label.setText(espreso.getName() + " 주문가능" + "\n");
        }else{
            m_tv_label.setText(espreso.getName() + " 주문 불가능" + "\n");
        }

    }

    public void onlatte()
    {
        if(ingredient.onGetBeans() >= latte.onGetBeans()
                && ingredient.onGetWater() >= latte.onGetWater()
                && ingredient.onGetMilk() >= latte.onGetMilk()){
            m_tv_label.setText(latte.getName() + " 주문가능" + "\n");
        }else{
            m_tv_label.setText(latte.getName() + " 주문 불가능" + "\n");
        }
    }

    public void onAmericano()
    {
        if(ingredient.onGetBeans() >= americano.onGetBeans()
                && ingredient.onGetWater() >= americano.onGetWater()){
            m_tv_label.setText(americano.getName() + " 주문가능" + "\n");
        }else{
            m_tv_label.setText(americano.getName() + " 주문 불가능" + "\n");
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Coffee coffee = myAdapter.getItem(position);

        int type = coffee.getType();
        String name = coffee.getName();
        int beans = coffee.onGetBeans();

        int milk = 0;

        if(coffee instanceof latte){
            milk = ((latte)coffee).onGetMilk();
        }

        int water = coffee.onGetWater();
        int price = coffee.onGetPrice();


        //재료 다 있는지 확인
        if(ingredient.onGetBeans() >= beans && ingredient.onGetWater() >= water && ingredient.onGetMilk() >= milk){

            m_tv_label.setText(name + "주문성공" + "\n");

            ingredient.Minusbeans(beans);
            ingredient.Minuswater(water);
            ingredient.MinusMilk(milk);

            cache.AddMoney(price); //정산 돈 더하기
            cache.onAddCntCoffee(type); //판매한 커피 통계 cnt 올리기
            cache.AddSellList(name); //판매한 커피 판매리스트에 add

            oningredientReport();
            oncalculateReport();

        }else{
            m_tv_label.setText(name + "재료 부족으로 판매불가능 합니다");
        }

    }


    private static class MyAdapter extends ArrayAdapter<Coffee> {

        private final Context mContext;
        private final LayoutInflater mLayoutInflater;

        public MyAdapter(Context context) {
            super(context , 0);
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        public Context getContext() { return mContext; }
        public LayoutInflater getFlater() { return mLayoutInflater; }

        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewItem vItem;
            if( convertView == null ) {

                vItem = new ViewItem();

                convertView = getFlater().inflate(R.layout.item_listview, parent, false);
                vItem.tv_text = (TextView)convertView.findViewById(R.id.tv_item);
                convertView.setTag(vItem);
            } else {
                vItem = (ViewItem) convertView.getTag();
            }

            Coffee item = getItem(position);

            vItem.tv_text.setText(item.getName());

            return convertView;
        }

        private static class ViewItem {
            TextView tv_text;
        }

    }





}