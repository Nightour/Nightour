package com.infact.nightour.model;

/**
 * Created by Neto on 24/11/2015.
 */
public class ImagemETituloItem {
    public int title;
    public int img;
    public boolean selected;

    public ImagemETituloItem() {

    }

    public ImagemETituloItem(int title, int img) {
        this.title = title;
        this.img = img;
    }
    public int getTitle() {
        return title;
    }

    public void setTitle(int title)
    {
        this.title = title;
    }

    public void setImg(int img)
    {
        this.img = img;
    }
    public int getImg()
    {
        return img;
    }
}
