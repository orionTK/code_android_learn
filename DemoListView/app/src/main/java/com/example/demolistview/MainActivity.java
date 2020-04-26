package com.example.demolistview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.productadapter.ProductAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listProduct;
    String[]  maintitle = {
      "Sản phẩm 1",
      "Sản phẩn 2",
      "Sản phẩm 3",
      "Sản phẩn 4",
      "Sản phẩm 5"
    };
    String[]  subtitle = {
            "Title 1",
            "Title 2",
            "Title 3",
            "Title 4",
            "Title 5"
    };
    Integer[] imgid = {
            R.drawable.hoa1,
            R.drawable.hoa2,
            R.drawable.hoa3,
            R.drawable.hoa4,
            R.drawable.hoa5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.hoa1);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("Danh sách sản phẩm");
        actionBar.setDisplayShowTitleEnabled(true);

        ProductAdapter adapter = new ProductAdapter(this, maintitle, subtitle, imgid);
        ListView lisProduct = (ListView) findViewById(R.id.listProduct);
        lisProduct.setAdapter(adapter);

        lisProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mgs = "Bạn đã chọn sản phẩm thứ " + maintitle[position] + "!";
                Toast.makeText(getApplicationContext(), mgs, Toast.LENGTH_LONG).show();
            }
        });
    }
}
