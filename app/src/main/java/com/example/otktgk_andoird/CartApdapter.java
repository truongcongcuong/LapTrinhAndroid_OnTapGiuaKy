package com.example.otktgk_andoird;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartApdapter extends RecyclerView.Adapter<CartApdapter.NameViewHolder> {
    List<CartItem> carts = new ArrayList<CartItem>();
    LayoutInflater inflater;

    public CartApdapter(List<CartItem> carts, Context context) {
        this.carts = carts;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartApdapter.NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_cart,parent,false);
        return new NameViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CartApdapter.NameViewHolder holder, int position) {
        CartItem item = carts.get(position);
        holder.txtCartProductName.setText(item.getProduct().getProductName());
        holder.imgCartProduct.setImageResource(item.getProduct().getImage());
        holder.txtCartPrice.setText(item.getProduct().getPrice()+"$");
        holder.txtCartQuantity.setText(item.getQuantity()+"");
        holder.ibtCartSub.setBackgroundResource(R.drawable.ic_twotone_remove_circle_24);
        holder.ibtCartInc.setBackgroundResource(R.drawable.ic_baseline_add_circle_24);
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        CartApdapter apdapter;
        TextView txtCartProductName,txtCartPrice,txtCartQuantity;
        ImageView imgCartProduct;
        ImageButton ibtCartInc, ibtCartSub;
        public NameViewHolder(@NonNull View itemView, CartApdapter apdapter) {
            super(itemView);
            this.apdapter = apdapter;
            txtCartPrice = itemView.findViewById(R.id.txtCartProductPrice);
            txtCartProductName = itemView.findViewById(R.id.txtCartProductName);
            txtCartQuantity = itemView.findViewById(R.id.txtCartQuantity);
            imgCartProduct = itemView.findViewById(R.id.imgCartProduct);
            ibtCartInc = itemView.findViewById(R.id.ibtCartIncrease);
            ibtCartSub = itemView.findViewById(R.id.ibtCartSub);
        }
    }
}
