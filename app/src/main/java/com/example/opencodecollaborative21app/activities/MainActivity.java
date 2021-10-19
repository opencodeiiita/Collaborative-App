package com.example.opencodecollaborative21app.activities;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.api.FetchApiSingleton;
import com.example.opencodecollaborative21app.classes.Participant;
import java.util.ArrayList;
import com.example.opencodecollaborative21app.interfaces.ApiResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Set;

import com.example.opencodecollaborative21app.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    FetchApiSingleton fetchApiSingleton;
    MainViewModel mainviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, navController);
        fetchApiSingleton = new FetchApiSingleton(this);


        mainviewmodel = new ViewModelProvider(this).get(MainViewModel.class);

        //This was the link used to test the code. URL will have to be passed as a parameter and
        //data will be fetched accordingly
        //fetchApiSingleton.fetchApi("https://opencodeiiita.herokuapp.com/get-issue-assigned/");
        //To call fetchAPI
//        fetchApiSingleton.fetchApi("https://opencodeiiita.herokuapp.com/get-issue-assigned/",
//            new ResponseHandler() {
//                @Override
//                public void onResponse(JSONObject response) {
//
//                }
//
//                @Override
//                public void onErrorResponse(String error) {
//
//                }
//            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        setIconInMenu(menu, R.id.about_us, R.string.about_us, R.drawable.ic_about_us);
        setIconInMenu(menu, R.id.contact_us, R.string.contact_us, R.drawable.ic_contact_us);
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

    private void setIconInMenu(Menu menu, int menuItemID, int labelID, int iconID) {
        MenuItem menuItem = menu.findItem(menuItemID);
        SpannableStringBuilder string = new SpannableStringBuilder("   " + getResources().getString(labelID));
        string.setSpan(new ImageSpan(this, iconID), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(string);
        FetchAppContributor();
    }

    private void FetchAppContributor(){
        String str = getResources().getString(R.string.participant);
        String[] contributorArray = str.split("   ");
        ArrayList<Participant> participants = new ArrayList<>();
        for(int i=0; i< contributorArray.length;i++){
            String[] contributor = contributorArray[i].split(" ");
            String name = "";
            for(int j=0;j<contributor.length-1 ;j++){
                name = name + contributor[j] + " ";
            }
            String github = contributor[contributor.length -1];
            Participant participant = new Participant(name,github);
            participants.add(participant);
        }

    }

}
