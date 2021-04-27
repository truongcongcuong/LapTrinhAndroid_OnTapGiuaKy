package com.example.otktgk_andoird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChiTietSabPham extends AppCompatActivity {
    TextView txtProductName,txtPrice,txtQuantity,txtDetail,txtProductDetail;
    ImageView imgProduct;
    Button bttAddToCart;
    ImageButton imbIncre,imbSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sab_pham);
        Bundle bundle = getIntent().getExtras();
        Product product = (Product) bundle.getSerializable("product");
        imgProduct = findViewById(R.id.imgProduct);
        txtProductName = findViewById(R.id.txtProductNameDetail);
        txtPrice = findViewById(R.id.txrPriceDetail);
        txtQuantity = findViewById(R.id.txtQuanjtity);
        txtDetail = findViewById(R.id.txtDetail);
        txtProductDetail = findViewById(R.id.txtProductDetail);
        bttAddToCart = findViewById(R.id.bttAddToCart);
        imbIncre = findViewById(R.id.imbIncrease);
        imbSub = findViewById(R.id.imbSub);

        imgProduct.setImageResource(product.getImage());
        txtProductName.setText(product.getProductName());
        txtPrice.setText(product.getPrice()+"");
        txtQuantity.setText("1");
        txtDetail.setText("Product Detail");
        txtProductDetail.setText(product.toString());
        imbSub.setBackgroundResource(R.drawable.ic_twotone_remove_circle_24);
        imbIncre.setBackgroundResource(R.drawable.ic_baseline_add_circle_24);
        imbIncre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(txtQuantity.getText().toString());
                i++;
                txtQuantity.setText(i+"");
            }
        });

        imbSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(txtQuantity.getText().toString());
                if(i>0)
                    i--;
                txtQuantity.setText(i+"");
            }
        });

        bttAddToCart.setText("Add To Cart");
        bttAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToCart = new Intent(ChiTietSabPham.this,Cart.class);
                Bundle bundleSendCartItem = new Bundle();
                CartItem cartItem = new CartItem(product,Integer.parseInt(txtQuantity.getText().toString()));
                bundleSendCartItem.putSerializable("cartItem",cartItem);
                intentToCart.putExtras(bundleSendCartItem);
                startActivity(intentToCart);
            }
        });
    }
}