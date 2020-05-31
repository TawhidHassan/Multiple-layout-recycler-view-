package com.example.multiple_layout_recyclerviews;

public class ModelClass {

    public  static final int USERINFO_LAYOUT=0;
    public  static final int AD_LAYOUT=1;
    public  static final int IMAGE_LAYOUT=2;


    //view type
    int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
    //view type


    ///userinfo layout
    int imageResource;
    String title,body;

    public ModelClass(int viewType,int imageResource, String title, String body) {
        this.viewType = viewType;
        this.imageResource = imageResource;
        this.title = title;
        this.body = body;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    ///userinfo layout

//------------------------------------------------
    //ad layout
    String adtext;

    public ModelClass(int viewType,String adtext) {
        this.viewType = viewType;
        this.adtext = adtext;
    }

    public String getAdtext() {
        return adtext;
    }

    public void setAdtext(String adtext) {
        this.adtext = adtext;
    }
    //ad layout
//--------------------------------------------------
    //image layout
    int imageLayout;

    public ModelClass(int viewType,int imageLayout) {
        this.viewType = viewType;
        this.imageLayout = imageLayout;
    }

    public int getImageLayout() {
        return imageLayout;
    }

    public void setImageLayout(int imageLayout) {
        this.imageLayout = imageLayout;
    }
    //image layout



}
