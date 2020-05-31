package com.example.multiple_layout_recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.multiple_layout_recyclerviews.ModelClass.AD_LAYOUT;
import static com.example.multiple_layout_recyclerviews.ModelClass.IMAGE_LAYOUT;
import static com.example.multiple_layout_recyclerviews.ModelClass.USERINFO_LAYOUT;

public class Adapter extends RecyclerView.Adapter {

    List<ModelClass>modelClassList;
    private int lastPosition=-1;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modelClassList.get(position).getViewType())
        {
            case 0:
                return USERINFO_LAYOUT;
            case 1:
                return AD_LAYOUT;
            case 2:
                return IMAGE_LAYOUT;

            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case USERINFO_LAYOUT:
                View userInView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
                return new userInfoLayout(userInView);
            case AD_LAYOUT:
                View adView=LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_layout,parent,false);
                return new adLayout(adView);
            case IMAGE_LAYOUT:
                View imageView=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
                return new imageLayout(imageView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (modelClassList.get(position).getViewType())
        {
            case USERINFO_LAYOUT:
                int image=modelClassList.get(position).getImageResource();
                String title=modelClassList.get(position).getTitle();
                String  body=modelClassList.get(position).getBody();
                ((userInfoLayout)holder).setdata(image,title,body);
                break;
            case AD_LAYOUT:
                String ad=modelClassList.get(position).getAdtext();
                ((adLayout)holder).setAddata(ad);
                break;
            case IMAGE_LAYOUT:
                int img=modelClassList.get(position).getImageLayout();
                ((imageLayout)holder).setImagedata(img);
                break;
            default:
                return;
        }
        if (lastPosition<position)
        {
            Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),android.R.anim.fade_in);
            holder.itemView.setAnimation(animation);
            lastPosition=position;
        }
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }


    ///viewholder
    class userInfoLayout extends RecyclerView.ViewHolder{

        ImageView userImage;
        TextView title,body;
        public userInfoLayout(@NonNull View itemView) {
            super(itemView);
            userImage=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.titleId);
            body=itemView.findViewById(R.id.bodyId);
        }

        private void setdata(int image,String tit,String bod)
        {
            userImage.setImageResource(image);
            title.setText(tit);
            body.setText(bod);
        }


    }

    class adLayout extends RecyclerView.ViewHolder{

        TextView adtext;
        public adLayout(@NonNull View itemView) {
            super(itemView);
            adtext=itemView.findViewById(R.id.addTextId);
        }

        private void setAddata(String ad)
        {
            adtext.setText(ad);

        }
    }

    class imageLayout extends RecyclerView.ViewHolder{

        ImageView iamgevioe;
        public imageLayout(@NonNull View itemView) {
            super(itemView);
            iamgevioe=itemView.findViewById(R.id.imageLayoutId);
        }
        private void setImagedata(int img)
        {
            iamgevioe.setImageResource(img);
        }
    }
}
