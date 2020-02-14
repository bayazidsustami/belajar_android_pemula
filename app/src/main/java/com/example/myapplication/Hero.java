package com.example.myapplication;

public class Hero {
    private String name;
    private String detail;

    public String getLinkBio() {
        return linkBio;
    }

    public void setLinkBio(String linkBio) {
        this.linkBio = linkBio;
    }

    private String linkBio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    private int photo;
}
