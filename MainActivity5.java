package com.example.mylocation;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    String name="",pass="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        EditText logn = findViewById(R.id.logname);
        EditText logp= findViewById(R.id.logpass);
        Button logb = findViewById(R.id.log);

        logb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = logn.getText().toString().trim();
                pass = logp.getText().toString().trim();
                SharedPreferences sharedPreferences1 = getSharedPreferences("NameSharer",MODE_PRIVATE);
                String s1 = sharedPreferences1.getString("name","");
                String s2 = sharedPreferences1.getString("pass","");
                if(name.isEmpty()&&pass.isEmpty()){
                    Toast.makeText(MainActivity5.this,"Fill the content",Toast.LENGTH_SHORT).show();
                }
                else if(name.equals(s1) && pass.equals(s2)){
                    Toast.makeText(MainActivity5.this,"Login Successfull via Local Storage",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity5.this,"Wrong username/password!",Toast.LENGTH_SHORT).show();
                }


            }
        });
        Button logex = findViewById(R.id.exi);
        logex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity5.this , MainActivity2.class);
                startActivity(i2);
            }
        });
    }
}
