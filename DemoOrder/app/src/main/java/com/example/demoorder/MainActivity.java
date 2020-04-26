package com.example.demoorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private CheckBox ckBun, ckPho, ckHuTieu, ckBanhMi;
    private Button btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListener();
    }

    public void setOnClickListener() {
        ckBun = (CheckBox) findViewById(R.id.ckBun);
        ckPho = (CheckBox) findViewById(R.id.ckPho);
        ckBanhMi = (CheckBox) findViewById(R.id.ckBanhMi);
        ckHuTieu = (CheckBox) findViewById(R.id.ckHuTieu);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double toAmt = 0;
                StringBuilder result = new StringBuilder();
                result.append("Món được chọn: ");

                if (ckBun.isChecked()) {
                    result.append("\n\t   -Bún bò (50k)");
                    toAmt += 50;
                }

                if (ckPho.isChecked()) {
                    result.append("\n\t   -Phở bò (50k)");
                    toAmt += 50;
                }

                if (ckBanhMi.isChecked()) {
                    result.append("\n\t   -Bánh mì ốp la (20k)");
                    toAmt += 20;
                }

                if (ckHuTieu.isChecked()) {
                    result.append("\n\t   -Hủ tiếu nam vang (45k)");
                    toAmt += 45;
                }

                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                String to = decimalFormat.format(toAmt);
                result.append("   \n\t Tổng tiền: " + to + " VNĐ");
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
