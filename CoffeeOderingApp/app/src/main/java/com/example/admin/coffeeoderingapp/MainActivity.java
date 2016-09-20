package com.example.admin.coffeeoderingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int quantity;
    private TextView tvDisplay,tvOutput;
    private final int price = 5;
    private CheckBox cbCream, cbChocolate;
    private EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = (TextView)findViewById(R.id.quantity);
        tvOutput = (TextView)findViewById(R.id.tvQuantity);
        cbChocolate = (CheckBox)findViewById(R.id.cbChocolate);
        cbCream = (CheckBox)findViewById(R.id.cbWhippedCream);
        etName = (EditText)findViewById(R.id.name);
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
        String cream = "False";
        String chocolate = "False";
        String name = etName.getText().toString();
        if(name!=null){
            double amtDue = quantity*price;
            if(cbChocolate.isChecked()){
                amtDue += quantity*2;
                chocolate = "True";
            }
            if(cbCream.isChecked())
            {
                amtDue += quantity*1;
                cream = "True";
            }
            if(quantity == 1)
            {
                String message = "Name: "+name+
                        "\nAdd whipped cream? "+cream+
                        "\nAdd chocolate? "+chocolate+
                        "\nYou ordered "+quantity+" cup of coffee"
                        +"\nTotal amount is: R" +amtDue
                        +"\nThank you for your support!!";
                tvOutput.setText(message);
            }else{
                String message = "Name: "+name+
                        "\nAdd whipped cream? "+cream+
                        "\nAdd chocolate? "+chocolate+
                        "\nYou ordered "+quantity+" cups of coffee"
                        +"\nTotal amount is: R" +amtDue
                        +"\nThank you for your support!!";
                tvOutput.setText(message);
            }
        }else{
            Toast.makeText(getBaseContext(),"PLEASE ENTER YOUR NAME FIRST",Toast.LENGTH_LONG).show();
        }

    }
}
