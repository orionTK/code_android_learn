package com.example.demonotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtTitle, txtMessage;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        btnSend = (Button) findViewById(R.id.btnMessage);

        createNotificationChanel();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }
    private void addNotification() {
        String strTitle = txtTitle.getText().toString();
        String strMessage = txtMessage.getText().toString();
        Intent notificationItent = new Intent(this, NotificationDetailActivity.class);
        notificationItent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        notificationItent.putExtra("message", strMessage);
        notificationItent.putExtra("title",strTitle);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationItent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Chanel-TH71")
                .setSmallIcon(R.drawable.hoa5)
                .setContentTitle(strTitle)
                .setContentText(strMessage)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) //độ ưu tiên
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
    private void createNotificationChanel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.chanel_name);
            String description = getString(R.string.chanel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Chanel-TH71", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
