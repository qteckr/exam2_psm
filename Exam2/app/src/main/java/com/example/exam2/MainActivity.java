package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener , View.OnClickListener {

    Button m_btn1;
    Button m_btn2;
    Button m_btn3;
    Button m_btn4;
    Button m_btn5;

    TextView m_tv_label;

    ListView listView;

    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oninit();
        oninitAdpater();
        onAddItem();
    }

    private void oninit(){

        m_btn1 = (Button) findViewById(R.id.btn_1);
        m_btn2 = (Button) findViewById(R.id.btn_2);
        m_btn3 = (Button) findViewById(R.id.btn_3);
        m_btn4 = (Button) findViewById(R.id.btn_4);
        m_btn5 = (Button) findViewById(R.id.btn_5);

        m_tv_label = (TextView) findViewById(R.id.tv_label);

        listView = (ListView) findViewById(R.id.listview);

        m_btn1.setOnClickListener(this);
        m_btn2.setOnClickListener(this);
        m_btn3.setOnClickListener(this);
        m_btn4.setOnClickListener(this);
        m_btn5.setOnClickListener(this);
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
        for(int i = 0; i<10 ; i++){
            ListItem item = new ListItem();
            item.Text = i+1  + "번쨰 아이템";
            myAdapter.add(item);
        }

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_1:
                Toast.makeText(this , "Click1" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2:
                Toast.makeText(this , "Click2" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_3:
                Toast.makeText(this , "Click3" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4:
                Toast.makeText(this , "Click4" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_5:
                Toast.makeText(this , "Click5" , Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListItem item = myAdapter.getItem(position);

        Toast.makeText(this , item.Text , Toast.LENGTH_SHORT).show();
    }


    public class ListItem {
        public String Text = "";

    }


    private static class MyAdapter extends ArrayAdapter<ListItem> {

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

            ListItem item = getItem(position);

            vItem.tv_text.setText(item.Text);

            return convertView;
        }

        private static class ViewItem {
            TextView tv_text;
        }

    }





}