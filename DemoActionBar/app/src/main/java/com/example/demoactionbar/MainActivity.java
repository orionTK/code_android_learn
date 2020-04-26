package com.example.demoactionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.ogo);
        actionBar.setTitle("Home");
        actionBar.setDisplayUseLogoEnabled(true);
    }

    // để hiển thị
    @Override
    public  boolean onCreateOptionsMenu(Menu itemmenu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, itemmenu);
        return true;
    }

    //tương tác
    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_help:
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_activity1:
                Intent sub1 = new Intent(this, sub1Activity.class);
                startActivity(sub1);
                return true;
            case R.id.sub_activity2:
                Intent sub2 = new Intent(this, Sub2Activity.class);
                startActivity(sub2);
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }
}
