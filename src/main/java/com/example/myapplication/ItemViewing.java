package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ItemViewing extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    EditText phone_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_viewing);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        EditText name=findViewById(R.id.name);
        EditText location=findViewById(R.id.location);
        EditText phone=findViewById(R.id.phone);
        EditText price=findViewById(R.id.price);
        EditText checkin=findViewById(R.id.checkin);
        name.setText(getIntent().getStringExtra("nameFood"));
        location.setText(getIntent().getStringExtra("locationFood"));
        phone.setText(getIntent().getStringExtra("phoneFood"));
        price.setText(getIntent().getStringExtra("priceFood"));
        checkin.setText(getIntent().getStringExtra("checkinFood"));
        Log.d("Position",getIntent().getStringExtra("positionClick"));

        final String message=getIntent().getStringExtra("positionClick");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=findViewById(R.id.name);
                EditText location=findViewById(R.id.location);
                EditText phone=findViewById(R.id.phone);
                EditText price=findViewById(R.id.price);
                EditText checkin=findViewById(R.id.checkin);
                String backStringname =name.getText().toString();
                String backStringlocation =location.getText().toString();
                String backStringphone =phone.getText().toString();
                String backStringprice =price.getText().toString();
                String backStringcheckin =checkin.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("nameFoodBack",backStringname);
                intent.putExtra("locationFoodBack",backStringlocation);
                intent.putExtra("phoneFoodBack",backStringphone);
                intent.putExtra("priceFoodBack",backStringprice);
                intent.putExtra("checkinFoodBack",backStringcheckin);
                intent.putExtra("positionClickBack",message);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        ImageView phonecall;
        phone_edittext = findViewById(R.id.phone);
        phonecall = findViewById(R.id.res_hotline);
        Log.d("Check","ss");
        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info","Button pressed");
                makePhonecall();
            }
        });
    }

    private void makePhonecall() {
        String number = phone_edittext.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(ItemViewing.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ItemViewing.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel: " + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(this,"Enter phone number",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhonecall();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
