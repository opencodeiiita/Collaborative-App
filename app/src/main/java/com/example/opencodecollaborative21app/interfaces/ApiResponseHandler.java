package com.example.opencodecollaborative21app.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ApiResponseHandler {
    public void onObjectResponse(JSONObject response);
    public void onArrayResponse(JSONArray response);
    public void onErrorResponse(String error);
}
