package com.example.otktgk_andoird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductApdapter productApdapter;
    private TextView txtPrice,txtProductName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcvProduct);
        productApdapter = new ProductApdapter(new ProductList().getProductList(),this);
        recyclerView.setAdapter(productApdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        txtProductName = findViewById(R.id.txtProductName);

    }
}