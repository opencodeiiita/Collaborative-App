package com.example.opencodecollaborative21app.interfaces;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public interface ApiResponseHandler {
    public void onObjectResponse(JSONObject response);
    public void onErrorResponse(String error);
    public void onArrayResponse(JSONArray response) throws JSONException;
}
