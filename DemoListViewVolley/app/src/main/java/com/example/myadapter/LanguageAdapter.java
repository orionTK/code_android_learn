package com.example.myadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demolistviewvolley.R;

import org.w3c.dom.Text;

import java.util.List;

public class LanguageAdapter extends ArrayAdapter<ProgrammingLanguage> {
    private List<ProgrammingLanguage> langList;
    private Bitmap bitmap;
    private Context context;

    public LanguageAdapter (List<ProgrammingLanguage> langList, Context context) {
        super(context, R.layout.progamming_language, langList);
        this.context = context;
        this.langList = langList;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.progamming_language, null, true);
        viewHolder = new ViewHolder();

        viewHolder.textViewDescription = view.findViewById(R.id.lang_description);
        viewHolder.textViewName = view.findViewById(R.id.lang_name);
        viewHolder.imageView = view.findViewById(R.id.lang_img);
        view.setTag(viewHolder);

        ProgrammingLanguage language = langList.get(position);
        String imgUrl = language.getImageUrl();
        String langName = language.getName();
        String langDesc = language.getDescription();

        viewHolder.textViewName.setText(langName);
        viewHolder.textViewDescription.setText(langDesc);

        if (viewHolder.imageView!=null) {
            new ImageDownloaderTask(viewHolder.imageView).execute(imgUrl);
        }
        viewHolder.imageView.setImageBitmap(bitmap);
        return view;
    }

    static class ViewHolder {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;
    }
}