package com.example.administrator.test;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ArrayList<Product> data;
    MyCustomAdapterCart adapter;
    RecyclerView recyclerView;
    TextView txtTotal;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cart);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        txtTotal = (TextView)findViewById(R.id.txtTotal_cart_item);

        txtTotal.setText(MyDB.getTotal()+"$");
    }

    @Override
    protected void onResume() {

        super.onResume();
        data = new ArrayList<>();
        for (int i = 0; i < MyDB.product_list.size(); i++) {
            for (int item : MyDB.cart_items) {
                if (item == i) {
                    data.add(MyDB.product_list.get(i));
                }
            }
        }
        adapter = new MyCustomAdapterCart(data);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "on resume", Toast.LENGTH_SHORT).show();
    }
}
