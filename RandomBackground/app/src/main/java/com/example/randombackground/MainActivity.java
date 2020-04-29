package com.example.randombackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ArrayList<Integer> listImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linearout);
        listImage = new ArrayList<>();
        listImage.add(R.drawable.binh);
        listImage.add(R.drawable.kieu);
        listImage.add(R.drawable.sen);
        listImage.add(R.drawable.tra);
        listImage.add(R.drawable.meo);
        Random random = new Random();
        int re = random.nextInt(listImage.size());
        linearLayout.setBackgroundResource(listImage.get(re));
    }
}
