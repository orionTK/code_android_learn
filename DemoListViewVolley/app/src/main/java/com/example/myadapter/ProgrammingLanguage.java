package com.example.myadapter;

import android.widget.ProgressBar;

public class ProgrammingLanguage {
    String name, imageUrl, description;
    public ProgrammingLanguage(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
}

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}
