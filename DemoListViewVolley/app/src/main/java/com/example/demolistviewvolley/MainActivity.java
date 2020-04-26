package com.example.demolistviewvolley;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myadapter.LanguageAdapter;
import com.example.myadapter.ProgrammingLanguage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listLanguage;
    private static final String JSON_URL = "http://occapp.ddns.net:899/network-trade-api/Lib/getprolangs";
    private List<ProgrammingLanguage> langList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.hoa3);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("LISTVIEW - VOLLEY");
        actionBar.setDisplayShowTitleEnabled(true);

        listLanguage = (ListView) findViewById(R.id.listLanguage);
        langList = new ArrayList<>();
        loadLanguageList();
    }

    private void loadLanguageList() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.VISIBLE);
                        try {
                            JSONArray langArray = new JSONArray(response);
                            for (int i = 0; i < langArray.length(); i++) {
                                JSONObject obj = langArray.getJSONObject(i);
                                ProgrammingLanguage lang = new ProgrammingLanguage(
                                        obj.getString("name"),
                                        obj.getString("imageurl"),
                                        obj.getString("description")
                                );
                                langList.add(lang);
                            }
                            LanguageAdapter adapter = new LanguageAdapter(langList, getApplicationContext());
                            listLanguage.setAdapter(adapter);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
