package com.example.administrator.test;

import android.content.Intent;

import java.util.ArrayList;

public class MyDB {
    public static ArrayList<Product> product_list = new ArrayList<>();
    public static ArrayList<Integer> cart_items = new ArrayList<>();
    public static int product_id=0;

    public MyDB() {
        this.product_list.add(new Product("Sneaker AB5F", 1000, "With a full length Boost midsole", R.drawable.g1));
        this.product_list.add(new Product("Sneaker EG5F", 700, "Rather than combining an equally", R.drawable.g2));
        this.product_list.add(new Product("Sneaker DG5F", 333, "Upper they rolled out their answer to Nike's flyknit material", R.drawable.g3));
        this.product_list.add(new Product("Sneaker FG5F", 470, "Somehow sloppy when actually training in the shoe. If you're a serious runner looking to experience Boost cushioning, you'd ", R.drawable.g4));
        this.product_list.add(new Product("Sneaker FH5F", 60, "Be far better served wearing other shoes in Adidas", R.drawable.g5));

    }

    public static float getTotal() {
        float total = 0;
        for (int i = 0; i < product_list.size(); i++) {
            for (int item:cart_items){
                if (item == i){
                    total+= product_list.get(i).getPrice();
                }
            }

        }
        return total;
    }
}