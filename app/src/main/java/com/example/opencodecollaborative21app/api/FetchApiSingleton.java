package com.example.opencodecollaborative21app.api;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.opencodecollaborative21app.interfaces.ApiResponseHandler;


public class FetchApiSingleton{
    private static final String TAG = "FetchApiSingleton";
    private final Context context;
    private RequestQueue requestQueue;

    public FetchApiSingleton(Context context) {
        this.context = context;
    }

    private enum ApiResponseType{
        OBJECT, ARRAY, ERROR;
    }
    private ApiResponseType isJSONValid(String response) {
        try {
            new JSONObject(response);
            return ApiResponseType.OBJECT;
        } catch (JSONException ex) {
            try {
                new JSONArray(response);
                return ApiResponseType.ARRAY;
            } catch (JSONException ex1) {
            }
        }
        return ApiResponseType.ERROR;
    }

    public void fetchApi(String url,ApiResponseHandler apiResponsehandler) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ApiResponseType res = isJSONValid(response);
                        if (res==ApiResponseType.OBJECT) {
                            //Used to test if JSON string was valid
                            // Log.i(TAG, "Response:" +response.substring(0,500));
                            onJsonObjectFetch(response, apiResponsehandler);
                        }
                        else if(res==ApiResponseType.ARRAY){
                            onJsonArrayFetch(response,apiResponsehandler);
                        }
                        else {
                            //If JSON string is invalid, error will be shown
                            Log.i(TAG, "JSON string is invalid");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "VolleyError error " + error.toString());
            }
        });
        queue.add(stringRequest);
    }

    private void onJsonObjectFetch(String fetchedstring, ApiResponseHandler responseHandler) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(fetchedstring);
            responseHandler.onObjectResponse(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            responseHandler.onErrorResponse(e.toString());
        }
        // Used to test whether onJsonObjectFetch was working
        // Log.d(TAG, "onJsonObjectFetch: " + jsonObject.toString());
    }

    private void onJsonArrayFetch(String fetchedstring, ApiResponseHandler responseHandler) {
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = new JSONArray(fetchedstring);
            responseHandler.onArrayResponse(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
            responseHandler.onErrorResponse(e.toString());
        }
    }

}