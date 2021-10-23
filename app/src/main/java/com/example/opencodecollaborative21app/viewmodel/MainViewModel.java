package com.example.opencodecollaborative21app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.opencodecollaborative21app.classes.Participant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    
    public MainViewModel(){

    }

    private ArrayList<Participant> participants;

    public void initParticipants(ArrayList<Participant> x) {
        participants = x;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }
   
}
