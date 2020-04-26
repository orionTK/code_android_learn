package com.example.imgaeadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.imageslider.R;

public class ImageAdapter extends PagerAdapter {
    Context mContext;
    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ImageView) object;
    }

    private int[] sliderImage = new int[] {
            R.drawable.meo1,
            R.drawable.meo2,
            R.drawable.meo3,
            R.drawable.meo4,
            R.drawable.meo5
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImage[position]);
        ((ViewPager) container).addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return sliderImage.length;
    }
}
