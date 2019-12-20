package com.example.iothouse20.Model;

public class itemcap {
    public int type;
    public String BottomText,imageURL;

    public itemcap(int type, String bottomText, String imageURL) {
        this.type = type;
        BottomText = bottomText;
        this.imageURL = imageURL;
    }

    public itemcap() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBottomText() {
        return BottomText;
    }

    public void setBottomText(String bottomText) {
        BottomText = bottomText;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
