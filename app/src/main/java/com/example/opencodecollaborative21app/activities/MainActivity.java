package com.example.opencodecollaborative21app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import api.FetchApiSingleton;

import com.example.opencodecollaborative21app.R;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    FetchApiSingleton fetchApiSingleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController= Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, navController);
        fetchApiSingleton = new FetchApiSingleton(this);

        //This was the link used to test the code. URL will have to be passed as a parameter and
        //data will be fetched accordingly

        //fetchApiSingleton.FetchApi("https://api.publicapis.org/entries");
    }

}
