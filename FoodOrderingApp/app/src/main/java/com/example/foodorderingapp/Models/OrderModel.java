package com.example.foodorderingapp.Models;

public class OrderModel {
    int orderImage;
    String orderName,orderId,price;

    public OrderModel(int orderImage, String orderName, String orderId, String price) {
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.orderId = orderId;
        this.price = price;
    }

    public OrderModel() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
