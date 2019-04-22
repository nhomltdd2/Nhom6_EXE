package com.example.administrator.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    private ArrayList<Product> product_list;
    Intent intent;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imvImage;
        TextView txtTitle,txtDescription,txtPrice;
        Button btnAddToCart;

        public MyViewHolder(@NonNull View view) {
            super(view);
            imvImage = (ImageView)view.findViewById(R.id.imvImage);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            btnAddToCart = (Button) view.findViewById(R.id.btnAddToCart);

        }
    }
    public MyCustomAdapter(ArrayList<Product> product_list){
        this.product_list = product_list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_layout,viewGroup,false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        TextView txtTitle = myViewHolder.txtTitle;
        TextView txtDescription = myViewHolder.txtDescription;
        TextView txtPrice = myViewHolder.txtPrice;
        ImageView imvImage = myViewHolder.imvImage;
        Button btnAddToCart = myViewHolder.btnAddToCart;
        imvImage.setImageResource(product_list.get(i).getImage());
        txtTitle.setText(product_list.get(i).getName());
        txtPrice.setText(product_list.get(i).getPrice()+"$");
//        txtDescription.setText(product_list.get(i).getDescription());
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB.product_id = i;
                intent = new Intent(v.getContext(),CartActivity.class);
                v.getContext().startActivity( intent );
                Toast.makeText(v.getContext(), "Chi tiết sp: " + product_list.get(i).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        txtTitle.setText(product_list.get(i).getName());
    }


    @Override
    public int getItemCount() {
        return product_list.size();
    }
}