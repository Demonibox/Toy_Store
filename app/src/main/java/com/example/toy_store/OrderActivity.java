package com.example.toy_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    String [] addresses = {"demonibox@gmail.com"};
    String subject = "Ваши покупки в Toy Store";
    String emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent receveidOrderIntent = getIntent();
        String UserName = receveidOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = receveidOrderIntent.getStringExtra("goodsName");
        int quantity = receveidOrderIntent.getIntExtra("quantity",0);
        double price = receveidOrderIntent.getDoubleExtra("price", 0);
        double orderPrice = receveidOrderIntent.getDoubleExtra("orderPrice", 0);

        emailText = "Покупатель: " + UserName + "\n"+
                "Товар: " + goodsName + "\n" +
                "Количество: " + quantity + "\n" +
                "Цена: " + price+ "\n" +
                "К оплате: " + orderPrice;

        TextView orderTextView = findViewById(R.id.OrderTextView);
        orderTextView.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}