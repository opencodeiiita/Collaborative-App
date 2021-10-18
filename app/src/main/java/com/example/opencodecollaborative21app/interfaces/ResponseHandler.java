package com.example.opencodecollaborative21app.interfaces;

import org.json.JSONObject;

public interface ResponseHandler {
    public void onResponse(JSONObject response);
    public void onErrorResponse(String error);


}
