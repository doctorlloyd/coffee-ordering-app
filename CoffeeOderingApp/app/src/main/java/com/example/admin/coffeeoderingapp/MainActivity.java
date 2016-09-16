package com.example.admin.coffeeoderingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int quantity;
    private TextView tvDisplay,tvOutput;
    private final int price = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = (TextView)findViewById(R.id.quantity);
        tvOutput = (TextView)findViewById(R.id.tvQuantity);
        quantity = 1;
    }
    public void negative(View view)
    {
        if(quantity > 1)
        {
            quantity --;
            tvDisplay.setText(""+quantity);
        }
        else{
            Toast.makeText(getBaseContext(),"You can only order one or more coffee",Toast.LENGTH_LONG).show();
        }
    }
    public void positive(View view)
    {
        quantity++;
        tvDisplay.setText(""+quantity);
    }
    public void order(View view)
    {
        double amtDue = quantity*price;
        if(quantity == 1)
        {
            String message = "You ordered "+quantity+" cup of coffee\n"
                    +"Total amount is: R" +amtDue
                    +"\nThank you for your support!!";
            tvOutput.setText(message);
        }else{
            String message = "You ordered "+quantity+" cups of coffee\n"
                    +"Total amount is: R" +amtDue
                    +"\nThank you for your support!!";
            tvOutput.setText(message);
        }
    }
}
