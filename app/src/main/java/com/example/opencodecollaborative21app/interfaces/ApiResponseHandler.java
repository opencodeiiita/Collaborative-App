package com.example.opencodecollaborative21app.interfaces;

import org.json.JSONObject;

public interface ApiResponseHandler {
    public void onResponse(JSONObject response);
    public void onErrorResponse(String error);


}
