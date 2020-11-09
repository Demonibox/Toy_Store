package com.example.toy_store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Стич");
        spinnerArrayList.add("Медведь");
        spinnerArrayList.add("Панда");

        spinnerAdapter = new ArrayAdapter( this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("Стич",500.0);
        goodsMap.put("Медведь",300.0);
        goodsMap.put("Панда",350.0);
    }

    public void setSubscribe(View view) {
        Button Subscribe = findViewById(R.id.Subscribe);
        Subscribe.setText("Вы подписаны!");
    }

    public void decreaseQuantity(View view) {
        quantity = quantity - 1;
        if (quantity < 0)
            quantity = 0;
        TextView QuantitypriceTextView = findViewById(R.id.QuantitypriceTextView);
        QuantitypriceTextView.setText("" + quantity);
        TextView priceTextview = findViewById(R.id.priceTextView);
        priceTextview.setText("" + quantity * price);
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView QuantitypriceTextView = findViewById(R.id.QuantitypriceTextView);
        QuantitypriceTextView.setText("" + quantity);
        TextView priceTextview = findViewById(R.id.priceTextView);
        priceTextview.setText("" + quantity * price);

    }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            goodsName = spinner.getSelectedItem().toString();
            price = (double)goodsMap.get(goodsName);
            TextView priceTextview = findViewById(R.id.priceTextView);
            priceTextview.setText("" + quantity * price);

            ImageView goodsImageView = findViewById(R.id.imageView2);
            if (goodsName.equals("Медведь")) {
                goodsImageView.setImageResource(R.drawable.bear);
            } else if (goodsName.equals("Стич")){
                goodsImageView.setImageResource(R.drawable.stich);
            } else if (goodsName.equals("Панда")){
                goodsImageView.setImageResource(R.drawable.panda);
            }





        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void AddtoCartButton(View view) {
        Button AddtoCartButton = findViewById(R.id.AddtoCart);
        AddtoCartButton.setText("Товар добавлен!");
    }
    }