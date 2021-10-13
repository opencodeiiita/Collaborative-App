package com.example.opencodecollaborative21app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;

import com.example.opencodecollaborative21app.R;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController= Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar,menu);
        setIconInMenu(menu,R.id.about_us,R.string.about_us,R.drawable.ic_about_us);
        setIconInMenu(menu,R.id.contact_us,R.string.contact_us,R.drawable.ic_contact_us);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_us:
                return true;
            case R.id.contact_us:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setIconInMenu(Menu menu,int menuItemID,int labelID,int iconID) {
        MenuItem menuItem = menu.findItem(menuItemID);
        SpannableStringBuilder string = new SpannableStringBuilder("   " + getResources().getString(labelID));
        string.setSpan(new ImageSpan(this,iconID),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(string);
    }
}