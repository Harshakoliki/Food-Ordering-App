package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Adapters.OrderAdapter;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    RecyclerView orderRecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderRecycle = findViewById(R.id.orderRecycle);


        DBHelper dbHelper = new DBHelper(this);
        ArrayList<OrderModel> list = dbHelper.getOrders();


        OrderAdapter adapter = new OrderAdapter(list,this);
        orderRecycle.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        orderRecycle.setLayoutManager(linearLayoutManager);
    }
}