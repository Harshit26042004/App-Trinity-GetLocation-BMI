package com.example.mylocation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity{
    String name="";
    String pass = "";
    String confi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        SharedPreferences sharedPreferences = getSharedPreferences("NameSharer",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText nameText = findViewById(R.id.Namer);
        EditText passText= findViewById(R.id.passer);
        EditText conf = findViewById(R.id.confirmer);

//        EditText logn = findViewById(R.id.logname);
//        EditText logp= findViewById(R.id.logpass);

        Button butt = findViewById(R.id.submitter);

        Button prelog = findViewById(R.id.logy);

        butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                name = nameText.getText().toString().trim();
                pass = passText.getText().toString().trim();
                confi = conf.getText().toString().trim();
                if(name.isEmpty()&&pass.isEmpty() || !pass.equals(confi)){
                    Toast.makeText(MainActivity4.this,"Something Wrong retry",Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString("name",name.toString());
                    editor.putString("pass",pass.toString());
                    editor.commit();
                    nameText.setText("");
                    passText.setText("");
                    Toast.makeText(MainActivity4.this,"Register Completed \n" +
                            "Now you can login below with credentials",Toast.LENGTH_LONG).show();
                    Intent i5 = new Intent(MainActivity4.this,MainActivity5.class);
                    startActivity(i5);
                }

            }
        });
//        Button logb = findViewById(R.id.log);
//
//        logb.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sharedPreferences1 = getSharedPreferences("NameSharer",MODE_PRIVATE);
//                String s1 = sharedPreferences1.getString("name","");
//                String s2 = sharedPreferences1.getString("pass","");
//                if(name.isEmpty()&&pass.isEmpty()){
//                    Toast.makeText(MainActivity4.this,"Fill the content",Toast.LENGTH_SHORT).show();
//                }
//                else if(name.equals(s1) && pass.equals(s2)){
//                    Toast.makeText(MainActivity4.this,"Login Successfull via Local Storage",Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//        });
        Button logex = findViewById(R.id.exi);
        logex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity4.this , MainActivity2.class);
                startActivity(i2);
            }
        });

        prelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent il = new Intent(MainActivity4.this , MainActivity5.class);
                startActivity(il);
            }
        });

    }

}
