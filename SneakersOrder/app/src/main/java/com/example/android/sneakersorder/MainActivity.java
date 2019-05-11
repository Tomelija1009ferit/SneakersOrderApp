package com.example.android.sneakersorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


// This App displays order for sneackers

public class MainActivity extends AppCompatActivity {


    //Quantity defined like a global variable

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //This method is called when order buttonis clicked

    public void submitOrder(View view){

        //Create Edittext for name

        EditText name = (EditText) findViewById(R.id.name_description_view);
        String nameid = name.getText().toString();

        // Create Edittext for address

        EditText address = (EditText) findViewById(R.id.Address_description_view);
        String addressid = address.getText().toString();

        //Create Edittext for sneakersmodel

        EditText model = (EditText) findViewById(R.id.model_description_view);
        String modelid = model.getText().toString();

        // Figure out witch size customer whants

        CheckBox size39 = (CheckBox) findViewById(R.id.size_39);
        boolean size39id = size39.isChecked();

        CheckBox size40 = (CheckBox) findViewById(R.id.size_40);
        boolean size40id = size40.isChecked();

        CheckBox size41 = (CheckBox) findViewById(R.id.size_41);
        boolean size41id = size41.isChecked();

        CheckBox size42 = (CheckBox) findViewById(R.id.size_42);
        boolean size42id = size42.isChecked();

        CheckBox size43 = (CheckBox) findViewById(R.id.size_43);
        boolean size43id = size43.isChecked();

        CheckBox size44 = (CheckBox) findViewById(R.id.size_44);
        boolean size44id = size44.isChecked();

        CheckBox size45 = (CheckBox) findViewById(R.id.size_45);
        boolean size45id = size45.isChecked();

        CheckBox size46 = (CheckBox) findViewById(R.id.size_46);
        boolean size46id = size46.isChecked();


        // Calculate the price

        int price = calculatePrice();

        //Call size method

        int size = selectedSize(size39id, size40id, size41id, size42id, size43id, size44id, size45id, size46id);

        // Display the order summary on the screen
        String pricemassage = createOrderSummery(price, nameid, addressid, modelid, size);

        //Open a order in emailA pp

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sneakers order for " + nameid);
        intent.putExtra(Intent.EXTRA_TEXT, pricemassage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    // Increase quantity for one

    public void increment(View view){

        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 Sneakers", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity+=1;
        displayQuantity(quantity);

    }

    // Decrease quantity for one

    public void decrement(View view){

        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 Sneakers", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }

        quantity-=1;
        displayQuantity(quantity);

    }

    //This method displays the quantity on the screen

    private void displayQuantity(int quantitynumber){

        TextView displayQuantityTextView = (TextView) findViewById(R.id.quntity_view);
        displayQuantityTextView.setText("" + quantitynumber);
    }

    //This method calculate order price

    private int calculatePrice(){

        int basePrice = 130;
        return quantity * basePrice;
    }
    //Create summery order

    private String createOrderSummery(int price, String name, String address, String model, int size){
        String pricemassage = "\nName: " + name + "\nAddres: " + address + "\nModel: " + model + "\nSize: " + size + "\nQuantity: " + quantity + "\nPrice:$" + price;
        return pricemassage;
    }

    //Figure out whitch size customer needed

    private int selectedSize(boolean size39, boolean size40, boolean size41, boolean size42, boolean size43, boolean size44, boolean size45, boolean size46){

        int size = 0;

        if(size39){
            size = 39;

        }
        if(size40){
            size = 40;

        }
        if(size41){
            size = 41;

        }
        if(size42){
            size = 42;

        }
        if(size42){
            size = 42;

        }
        if(size43){
            size = 43;

        }
        if(size44){
            size = 44;

        }
        if(size45){
            size = 45;

        }
        if(size46){
            size = 46;
        }
        return size;
    }
}
