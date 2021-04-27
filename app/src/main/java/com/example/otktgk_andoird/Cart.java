package com.example.otktgk_andoird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    private CartList cartList ;
    RecyclerView recyclerViewCart;
    CartApdapter apdapter;
    TextView txtSubTotalTitle,txtSubTotal,txtDeliveryTitle,txtDelivery;
    Button bttCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartList = new CartList().getCartList();
        Bundle bundlGetCartItem = getIntent().getExtras();
        CartItem cartItem = (CartItem) bundlGetCartItem.getSerializable("cartItem");
        cartList.addToCart(cartItem);

        recyclerViewCart = findViewById(R.id.rcyCart);
        apdapter = new CartApdapter(cartList.getList(),this);
        recyclerViewCart.setAdapter(apdapter);
        recyclerViewCart.setLayoutManager(new GridLayoutManager(this,1));

        txtDelivery = findViewById(R.id.txtDelivery);
        txtDeliveryTitle = findViewById(R.id.txtDeliveryTitle);
        txtSubTotal = findViewById(R.id.txtSubTotal);
        txtSubTotalTitle = findViewById(R.id.txtSubTotalTitle);
        bttCheckOut = findViewById(R.id.bttCheckOut);


        txtDeliveryTitle.setText("Delivery Free");
        txtSubTotalTitle.setText("Sub Total");
        txtSubTotal.setText(cartList.getSubTotal()+"$");
        txtDelivery.setText("Free");
        bttCheckOut.setText("Check Out");

        bttCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackToMain = new Intent(Cart.this,MainActivity.class);
                startActivity(intentBackToMain);
            }
        });

    }
}