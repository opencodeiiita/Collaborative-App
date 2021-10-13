package api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FetchApiSingleton {
    private static final String TAG = "FetchApiSingleton";
    private Context context;
    private RequestQueue requestQueue;
    private String url;
    private static FetchApiSingleton instance;

    public FetchApiSingleton(Context context) {
        this.context = context;
    }

    public boolean isJSONValid(String response) {
        try {
            new JSONObject(response);
        } catch (JSONException ex) {
            try {
                new JSONArray(response);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    public void FetchApi(String url) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (isJSONValid(response)) {
                            //Log.i(TAG, "Response:" +response.substring(0,500));
                            Toast.makeText(context, "Response" + response.substring(0, 500), Toast.LENGTH_SHORT).show();
                        } else {
                            //Log.i(TAG, "Error");
                            Toast.makeText(context, "Erros", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.i(TAG, "Error");
                Toast.makeText(context, "Erros", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }

    public static synchronized FetchApiSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new FetchApiSingleton(context);
        }
        return instance;
    }

    public void onJsonObjectFetch() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //    Log.i(TAG, "Response:" + response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.i(TAG, "Error");
                        Toast.makeText(context, "Erros", Toast.LENGTH_SHORT).show();
                    }
                });
        FetchApiSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void onJsonArrayFetch() {
        List<String> jsonResponses = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    //Log.i(TAG, "Response:" + response.toString());
                    Toast.makeText(context, "Response" + response.substring(0, 500), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
