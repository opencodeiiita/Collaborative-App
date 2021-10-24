package com.example.opencodecollaborative21app.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.opencodecollaborative21app.classes.LeaderBoard;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<LeaderBoard>> selected=new MutableLiveData<>();

    public MainViewModel(){

    }

    public void sendData(ArrayList<LeaderBoard> input){
        selected.setValue(input);
    }

    public MutableLiveData<ArrayList<LeaderBoard>> getSelected(){
        return selected;
    }

}