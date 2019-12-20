package com.example.iothouse20.Model;

public class item {
    public int type;
    public String BottomText,imageURL;

    public item(int type, String bottomText, String imageURL) {
        this.type = type;
        BottomText = bottomText;
        this.imageURL = imageURL;
    }

    public item() {
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
