package com.example.mylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    String name = "";
    String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameText = findViewById(R.id.username);
        EditText passText= findViewById(R.id.password);

        MaterialButton butt = findViewById(R.id.login);

        SharedPreferences sharedPreferences = getSharedPreferences("NameSharer",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Intent i = new Intent(this,MainActivity2.class);
        butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                name = nameText.getText().toString().trim();
                pass = passText.getText().toString().trim();
                if(name.isEmpty()&&pass.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fill the content",Toast.LENGTH_SHORT).show();
                }
                else if(name.equalsIgnoreCase("Harshit")&&pass.equals("hari360")){
                    i.putExtra(MainActivity2.NAME,name);
                    editor.putString("namee",name);
                    editor.commit();
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Wrong UserName / Password",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}