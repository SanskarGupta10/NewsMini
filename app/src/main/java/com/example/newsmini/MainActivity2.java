package com.example.newsmini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.util.AbstractCollection;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView textView4;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView4 = findViewById(R.id.textView4);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        // Instantiate the RequestQueue.
       ArrayList<String> title = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<String> imageurl = new ArrayList<>();
        RecycleAdapter ad = new RecycleAdapter(MainActivity2.this,title,description,date,imageurl);
          title.add("Sanskar Gupta");
          date.add("20 October 2022");
          description.add("My news app");
          imageurl.add("https://ichef.bbci.co.uk/news/1024/branded_news/9DCD/production/_127279304_no-10-branded.jpg");
          rv.setAdapter(ad);
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlis = "http://newsapi.org/v2/top-headlines?country=in&apiKey=5f9bab126eb44bd0ade9f45061b5ae00";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlis, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity2.this, "Sansy!", Toast.LENGTH_SHORT).show();
                        try {  JSONArray jsonArray = response.getJSONArray("articles");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject article = jsonArray.getJSONObject(i);
                                String titl = article.getString("title");
                                String desc = article.getString("description");
                                String da = article.getString("publishedAt");
                                String image = article.getString("urlToImage");
                                title.add(titl);
                                description.add(desc);
                                date.add(da);
                                imageurl.add(image);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("error","Hii ");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);

    }
}