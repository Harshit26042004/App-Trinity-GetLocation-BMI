package com.example.mylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {
    public static final String NAME="Name";
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        TextView var = findViewById(R.id.welcome);
        MaterialButton lout = findViewById(R.id.out);

        ImageButton locat = findViewById(R.id.loca1);
        ImageButton regi = findViewById(R.id.regiment1);
        ImageButton bmer = findViewById(R.id.bmgo);

        Intent i = getIntent();
        name = i.getStringExtra(NAME);

        SharedPreferences sharedPreferences = getSharedPreferences("NameSharer",MODE_PRIVATE);
        name = sharedPreferences.getString("namee","");

        var.setText("Welcome  " + name);
        lout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i2);
            }
        });
        locat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i3);
            }
        });
        regi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(i4);
            }
        });
        bmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(MainActivity2.this , MainActivity6.class);
                startActivity(i6);
            }
        });




    }
}