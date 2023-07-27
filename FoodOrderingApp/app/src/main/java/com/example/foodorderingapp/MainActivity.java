package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.MenuAdapter;
import com.example.foodorderingapp.Models.MenuModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        ArrayList<MenuModel> list = new ArrayList<>();
        list.add(new MenuModel(R.drawable.chicken,"Chicken Biryani", "$ 15.00","Tasty Biryani with extra spice and roasted chicken"));
        list.add(new MenuModel(R.drawable.paneer,"Paneer Birayani", "$ 12.00","Tasty Biryani smoothy paneer"));
        list.add(new MenuModel(R.drawable.pizza,"Pizza", "$ 10.00","Extra cheesy and extra toppings"));
        list.add(new MenuModel(R.drawable.burger,"Burger", "$ 8.00","Chicken Burger with fries and cheese"));

        MenuAdapter adapter = new MenuAdapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}