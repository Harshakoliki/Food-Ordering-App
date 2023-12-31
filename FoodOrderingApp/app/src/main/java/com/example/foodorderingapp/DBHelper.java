package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderingapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static  String DBName = "mydatabase.db";
    final static int DBVersion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement,"+
                        "name text," +
                        "phone text," +
                        "price int," +
                        "quantity int,"+
                        "image int," +
                        "description text," +
                        "foodName text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);

    }

    public boolean insertOrder(String name, String phone, String description, String price, int image, String foodName, int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("description",description);
        values.put("price",price);
        values.put("image",image);
        values.put("foodname",foodName);
        values.put("quantity",quantity);

        long id =database.insert("orders",null,values);
        if (id<=0){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<OrderModel> getOrders(){
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,name,image,price from orders",null);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrderModel model = new OrderModel();
                model.setOrderId(cursor.getInt(0)+"");
                model.setOrderName(cursor.getString(1));
                model.setOrderImage(Integer.parseInt(cursor.getInt(2)+""));
                model.setPrice(cursor.getString(3));
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
}
