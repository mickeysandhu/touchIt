package com.example.touchit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private UserAdapter madapter;
    int columnCount = 3;
    private ArrayList<Model> mModel;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.Recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,columnCount));
        mModel = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        callIt();
    }

    private void callIt() {

        String Url = "https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/category.json";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jo = response.getJSONObject (i);
                        String img1 = jo.getString("p");
                        String tv1 = jo.getString("n");
                        mModel.add(new Model(img1, tv1));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    madapter = new UserAdapter(MainActivity.this, mModel);
                    mRecyclerView.setAdapter(madapter);
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        mRequestQueue.add(request);
    }
}
