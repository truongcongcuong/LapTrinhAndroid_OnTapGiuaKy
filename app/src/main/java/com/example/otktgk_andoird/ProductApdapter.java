package com.example.otktgk_andoird;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductApdapter extends RecyclerView.Adapter<ProductApdapter.NameViewHolder> {
    ArrayList<Product> products;
    LayoutInflater inflater;
    Context context;

    public ProductApdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ProductApdapter.NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return new NameViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductApdapter.NameViewHolder holder, int position) {
        Product product = products.get(position);
        holder.txtProductName.setText(product.getProductName());
        holder.txtPrice.setText(product.getPrice()+"$");
        holder.imgProduct.setImageResource(product.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,product.getProductName(),Toast.LENGTH_SHORT);
                Intent intent = new Intent(context,ChiTietSabPham.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",products.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder{
        TextView txtPrice , txtProductName;
        ImageView imgProduct;
        ProductApdapter apdapter;
        public NameViewHolder(@NonNull View itemView, ProductApdapter apdapter) {
            super(itemView);
            this.apdapter = apdapter;
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgProduct = itemView.findViewById(R.id.imvProduct);
        }
    }
}
