package com.example.opencodecollaborative21app.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.opencodecollaborative21app.classes.LeaderBoard;
import com.example.opencodecollaborative21app.classes.Participant;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Participant>> selected=new MutableLiveData<>();

    public MainViewModel(){

    }

    public void sendData(ArrayList<Participant> input){
        selected.setValue(input);
    }

    public MutableLiveData<ArrayList<Participant>> getSelected(){
        return selected;
    }

}