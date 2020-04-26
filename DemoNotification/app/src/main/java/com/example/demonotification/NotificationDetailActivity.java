package com.example.demonotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        TextView textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        String message = getIntent().getStringExtra("message");
        String title = getIntent().getStringExtra("title");
        textViewMessage.setText(message);
        textViewTitle.setText(title);
    }
}
