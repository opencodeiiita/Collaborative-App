package com.example.opencodecollaborative21app.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.api.FetchApiSingleton;
import com.example.opencodecollaborative21app.classes.Mentor;
import com.example.opencodecollaborative21app.classes.Participant;
import com.example.opencodecollaborative21app.classes.Project;
import com.example.opencodecollaborative21app.interfaces.ApiResponseHandler;
import com.example.opencodecollaborative21app.viewmodel.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
        navController = Navigation.findNavController(this, R.id.navHostMain);
        fetchApiSingleton = new FetchApiSingleton(this);
        bottomNavigationView = findViewById(R.id.bottomNav);

        mainviewmodel = new ViewModelProvider(this).get(MainViewModel.class);

        getProjectData();
        getMentorData();
        FetchAppContributor();
    }

    private ArrayList<Mentor> getMentorData() {
        ArrayList<Mentor> mentors = new ArrayList<>();
        fetchApiSingleton.fetchApi("https://raw.githubusercontent.com/opencodeiiita/Collaborative-Web/main/data/mentors.json",
                new ApiResponseHandler() {
                    @Override
                    public void onObjectResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Expected JSON Array but got Object", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onArrayResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {

                            try {
                                JSONObject object = response.getJSONObject(i);
                                Mentor mentor = new Mentor(object.getString("name"), object.getString("github"));
                                mentor.setFacebookId(object.getString("facebook"));
                                mentor.setTwitterId(object.getString("twitter"));
                                mentors.add(mentor);
                                System.out.println(mentor.getName());
                                System.out.println(mentor.getFacebookId());
                            } catch (JSONException exe) {

                                Toast.makeText(getApplicationContext(), exe.toString(), Toast.LENGTH_SHORT).show();

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
        ArrayList<Project> projects = new ArrayList<>();
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

    private ArrayList<Participant> FetchAppContributor() {
        String str = getResources().getString(R.string.participant);
        String[] contributorArray = str.split("   ");

        ArrayList<Participant> participants = new ArrayList<>();
        for (String s : contributorArray) {
            String[] contributor = s.split(" ");

            String name = "";
            for (int j = 0; j < contributor.length - 1; j++) {
                name = name + contributor[j] + " ";
            }
            name = name.substring(0, name.length() - 1);
            String github = contributor[contributor.length - 1];
            Participant participant = new Participant(name, github);
            participants.add(participant);
        }
        return participants;
    }

}

