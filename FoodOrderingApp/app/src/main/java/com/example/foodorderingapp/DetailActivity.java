package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    public ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image",0);
        binding.detailImg.setImageResource(image);
        final String name = getIntent().getStringExtra("name");
        binding.detailName.setText(""+name);
        final String desc = getIntent().getStringExtra("desc");
        binding.DetailDesc.setText(""+desc);
        final String price = getIntent().getStringExtra("price");
        binding.detailPrice.setText(""+price);


        DBHelper dbHelper = new DBHelper(this);
        binding.DetailBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dbHelper.insertOrder(
                        binding.detailName.getText().toString(),
                        binding.detailYourPhone.getText().toString(),
                        desc,
                        price,
                        image,
                        name,
                        Integer.parseInt(binding.detailcount.getText().toString())

                );

                if(isInserted){
                    Toast.makeText(DetailActivity.this, "Data Sucecss", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.detailAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Increment", Toast.LENGTH_SHORT).show();
            }
        });

        binding.detailRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Decrement", Toast.LENGTH_SHORT).show();
            }
        });



    }
}