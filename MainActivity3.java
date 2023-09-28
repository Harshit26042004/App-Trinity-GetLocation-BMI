package com.example.mylocation;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.text.HtmlCompat;


import androidx.core.app.ActivityCompat;


import android.widget.Button;
import android.widget.TextView;

import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    Button btLocation;
    TextView textview1, textview2, textview3, textview4, textview5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btLocation = findViewById(R.id.bt_location);
        textview1 = findViewById(R.id.text_view1);
        textview2 = findViewById(R.id.text_view2);
        textview3 = findViewById(R.id.text_view3);
        textview4 = findViewById(R.id.text_view4);
        textview5 = findViewById(R.id.text_view5);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity3.this , MainActivity2.class);
                startActivity(i1);
            }
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btLocation.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              if (ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                                                  // Permission granted, proceed with getting the location
                                                  getLocation();
                                              } else {
                                                  // Permission not granted, request it
                                                  ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                                              }

                                          }
                                      }
        );
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {

                    try {
                        Geocoder geocoder = new Geocoder(MainActivity3.this, Locale.getDefault());

                        List<Address> adresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        textview1.setText(HtmlCompat.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b><br></font>"
                                        + adresses.get(0).getLatitude()
                                ,HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                        textview2.setText(HtmlCompat.fromHtml(
                                "<font color='#6200EE'><b>Longitude : </b><br></font>"
                                        + adresses.get(0).getLongitude()
                                        ,HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                        textview3.setText(HtmlCompat.fromHtml(
                                "<font color='#6200EE'><b>Country : </b><br></font>"
                                        + adresses.get(0).getCountryName()
                                ,HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                        textview4.setText(HtmlCompat.fromHtml(
                                "<font color='#6200EE'><b>Region : </b><br></font>"
                                        + adresses.get(0).getLocality()
                                ,HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                        textview5.setText(HtmlCompat.fromHtml(
                                "<font color='#6200EE'><b>Address Line : </b><br></font>"
                                        + adresses.get(0).getAddressLine(0)
                                ,HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }
        });


    }


}