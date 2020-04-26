package com.example.demoalertdialog;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnExit;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.meo3);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("Cat");
        actionBar.setDisplayShowTitleEnabled(true);

        btnExit = (Button) findViewById(R.id.btnExit);
        builder = new AlertDialog.Builder(this);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Bạn có chắc chắn muốn thoát không?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishActivity(0);
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Bạn chọn không!", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Thông báo");
                alertDialog.show();
            }
        });
    }
}
