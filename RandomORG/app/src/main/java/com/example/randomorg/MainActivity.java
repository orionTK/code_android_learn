package com.example.randomorg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText txtNum1, txtNum2;
    private Button btnRandom;
    private TextView textViewRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        textViewRandom = (TextView) findViewById(R.id.textViewRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num1 = txtNum1.getText().toString().trim();
                String num2 = txtNum2.getText().toString().trim();
                //num1.length() == 0 === num1.isEmpty

                if (num1.length() == 0 || num2.isEmpty())
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập đủ số!", Toast.LENGTH_SHORT).show();
                else{
                    int so1 = Integer.parseInt(num1);
                    int so2 = Integer.parseInt(num2);
                    if (so1 > so2)
                        Toast.makeText(getApplicationContext(), "Số thứ 2 cần lớn hơn số thứ nhất!", Toast.LENGTH_SHORT).show();
                    else {
                        Random random = new Random();
                        int ran = random.nextInt(so2 - so1 + 1) + so1;
                        textViewRandom.setText(String.valueOf(ran));
                    }

                }

            }
        });
    }
}
