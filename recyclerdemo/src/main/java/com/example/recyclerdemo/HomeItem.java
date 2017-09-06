package com.example.recyclerdemo;

/**
 * Created by johnson on 17-9-6.
 */

public class HomeItem {
    private String title;
    private int imageResource;
    private int avatarImgResource;

    public String  getTitle() {
        return "The fucking test title: " + title;
    }

    public HomeItem() {
        title = "";
        imageResource = 0;
        avatarImgResource = 0;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getAvatarImgResource() {
        return avatarImgResource;
    }

    public void setAvatarImgResource(int avatarImgResource) {
        this.avatarImgResource = avatarImgResource;
    }
}
