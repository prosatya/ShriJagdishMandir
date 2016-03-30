package com.matictechnology.shrijagdishmandir.classes;

import android.graphics.Bitmap;

/**
 * Created by maticd1 on 29/3/16.
 */
public class ImageItem
{
    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title)
    {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
