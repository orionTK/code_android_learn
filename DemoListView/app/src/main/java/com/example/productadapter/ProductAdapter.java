package com.example.productadapter;

import android.app.Activity;
import android.content.Context;
import android.icu.lang.UScript;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demolistview.MainActivity;
import com.example.demolistview.R;

import org.w3c.dom.Text;

public class ProductAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitle;
    private final String[] subTitle;
    private final Integer[] imgid;

    public ProductAdapter(Activity context, String[] mainTitle, String[] subTitle, Integer[] imgid) {
        super(context, R.layout.product, mainTitle);
        this.context = context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.imgid = imgid;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.product, null, true);
        TextView title = (TextView) row.findViewById(R.id.product_title);
        TextView subtitle = (TextView) row.findViewById(R.id.product_subtitle);
        ImageView imageView = (ImageView) row.findViewById(R.id.product_img);
        title.setText(mainTitle[position]);
        subtitle.setText(subTitle[position]);
        imageView.setImageResource(imgid[position]);

        return row;
    }
}
