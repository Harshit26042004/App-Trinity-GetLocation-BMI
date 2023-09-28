package com.example.mylocation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    float h1=0.0f,w1=0.0f,bm=0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        EditText h = findViewById(R.id.heightm);
        EditText w = findViewById(R.id.weightm);


        TextView res = findViewById(R.id.Result);
        Button calc = findViewById(R.id.calculate);
        Button exitbm = findViewById(R.id.exitbm);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h1 = Float.parseFloat(h.getText().toString());
                w1 = Float.parseFloat(w.getText().toString());
                h1/=100;
                bm = w1/(h1*h1);
                if(bm<18.5f){
                    res.setText("Your BMI "+bm+" is underweight");
                }
                else if(bm<24.9f && bm>=18.5f){
                    res.setText("Your BMI "+bm+" is Normal");
                }
                else if(bm<29.9f && bm>=25.0f){
                    res.setText("Your BMI "+bm+" is Overweight");
                }
                else if(bm<34.9f && bm>=30.0f){
                    res.setText("Your BMI "+bm+" is Obese");
                }
                else if(bm>35.0f){
                    res.setText("Your BMI "+bm+" is Extremely Obese");
                }

            }
        });

        exitbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ie = new Intent(MainActivity6.this , MainActivity2.class);
                startActivity(ie);
            }
        });

    }
}
