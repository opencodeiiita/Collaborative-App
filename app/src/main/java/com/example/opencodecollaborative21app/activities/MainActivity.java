package com.example.opencodecollaborative21app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.opencodecollaborative21app.R;

import api.FetchApiSingleton;

public class MainActivity extends AppCompatActivity {
    FetchApiSingleton fetchApiSingleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchApiSingleton = new FetchApiSingleton(this);

        //This was the link used to test the code. URL will have to be passed as a parameter and
        //data will be fetched accordingly

        //fetchApiSingleton.FetchApi("https://api.publicapis.org/entries");
    }
}