package com.example.democalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNum1, txtNum2;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnSub = (Button) findViewById(R.id.btnSub);

        //Cộng
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtNum1.getText().toString());
                double b = Double.parseDouble(txtNum2.getText().toString());
                double result = a + b;
                Toast.makeText(getApplicationContext(), String.valueOf(result),Toast.LENGTH_SHORT).show();
            }
        });

        //trừ
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtNum1.getText().toString());
                double b = Double.parseDouble(txtNum2.getText().toString());
                double result = a - b;

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });

        //Nhân
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtNum1.getText().toString());
                double b = Double.parseDouble(txtNum2.getText().toString());
                double result = a * b;

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });

        //Chia
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtNum1.getText().toString());
                double b = Double.parseDouble(txtNum2.getText().toString());
                double result = a / b;

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
