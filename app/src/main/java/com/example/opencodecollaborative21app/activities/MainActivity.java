package com.example.opencodecollaborative21app.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.api.FetchApiSingleton;
import com.example.opencodecollaborative21app.classes.Project;
import com.example.opencodecollaborative21app.fragments.Leaderboard;
import com.example.opencodecollaborative21app.fragments.Mentors;
import com.example.opencodecollaborative21app.fragments.Participants;
import com.example.opencodecollaborative21app.fragments.Projects;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.opencodecollaborative21app.classes.Participant;
import com.example.opencodecollaborative21app.classes.Mentor;
import java.util.ArrayList;

import com.example.opencodecollaborative21app.interfaces.ApiResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.example.opencodecollaborative21app.viewmodel.MainViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GetProjectData";
    NavController navController;
    FetchApiSingleton fetchApiSingleton;
    MainViewModel mainviewmodel;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, navController);
        fetchApiSingleton = new FetchApiSingleton(this);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);


        mainviewmodel = new ViewModelProvider(this).get(MainViewModel.class);
        getProjectData();
        //This was the link used to test the code. URL will have to be passed as a parameter and
        //data will be fetched accordingly
        //fetchApiSingleton.fetchApi("https://opencodeiiita.herokuapp.com/get-issue-assigned/");
        //To call fetchAPI
//        fetchApiSingleton.fetchApi("https://opencodeiiita.herokuapp.com/get-issue-assigned/",
//            new ApiResponseHandler() {
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
        getMentorData();

    }

    private ArrayList<Mentor> getMentorData(){
        ArrayList<Mentor> mentors = new ArrayList<Mentor>();
        @SuppressLint("ResourceType") View view = findViewById(R.layout.activity_main);
        fetchApiSingleton.fetchApi("https://raw.githubusercontent.com/opencodeiiita/Collaborative-Web/main/data/mentors.json",
            new ApiResponseHandler() {
                @Override
                public void onObjectResponse(JSONObject response) {
                    Toast.makeText(getApplicationContext(),"Expected JSON Array but got Object",Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onArrayResponse(JSONArray response) {
                    for(int i=0;i<response.length();i++) {

                        try {
                            JSONObject object = response.getJSONObject(i);
                            Mentor mentor = new Mentor(object.getString("name"), object.getString("github"));
                            mentor.setFacebookId(object.getString("facebook"));
                            mentor.setTwitterId(object.getString("twitter"));
                            mentors.add(mentor);
                            System.out.println(mentor.getName());
                            System.out.println(mentor.getFacebookId());
                        } catch (JSONException exe) {

                            Toast.makeText(getApplicationContext(),exe.toString(), Toast.LENGTH_SHORT).show();


                        }
                    }

                }

                @Override
                public void onErrorResponse(String error) {
                    Toast.makeText(getApplicationContext(), "Invalid JSON", Toast.LENGTH_SHORT).show();
                }

            });
        return mentors;


    }

    private ArrayList<Project> getProjectData() {
        fetchApiSingleton = new FetchApiSingleton(this);
        ArrayList<Project> projects = new ArrayList<Project>();
        fetchApiSingleton.fetchApi("https://raw.githubusercontent.com/opencodeiiita/Collaborative-Web/main/data/projects.json",
                new ApiResponseHandler() {
                    @Override
                    public void onObjectResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Didn't receive JSON Array", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onArrayResponse(JSONArray response) throws JSONException {
                        for (int j = 0; j < response.length(); j++) {
                            JSONObject object = response.getJSONObject(j);
                            Project project = new Project(object.getString("name"), object.getString("repo-url"), object.getString("description"));
                            projects.add(project);
                        }
                    }

                    @Override
                    public void onErrorResponse(String error) {
                        Toast.makeText(getApplicationContext(), "The link returned invalid data", Toast.LENGTH_SHORT).show();
                    }
                });
        return projects;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.Leaderboard:
                            fragment = new Leaderboard();
                            break;

                        case R.id.Projects:
                            fragment = new Projects();
                            break;

                        case R.id.Mentors:
                            fragment = new Mentors();
                            break;

                        case R.id.Participant:
                            fragment = new Participants();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.Nav, fragment).commit();
                    return true;
                }
            };

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
    }

    private void FetchAppContributor() {
        String str = getResources().getString(R.string.participant);
        String[] contributorArray = str.split("   ");
        ArrayList<Participant> participants = new ArrayList<>();
        for (int i = 0; i < contributorArray.length; i++) {
            String[] contributor = contributorArray[i].split(" ");
            String name = "";
            for (int j = 0; j < contributor.length - 1; j++) {
                name = name + contributor[j] + " ";
            }
            name = name.substring(0, name.length() - 1);
            String github = contributor[contributor.length - 1];
            Participant participant = new Participant(name, github);
            participants.add(participant);
        }

    }

}
