package com.example.android.movieapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pc on 11/12/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> array;
    private int width;
    public ImageAdapter(Context c, ArrayList<String> paths, int x){
        mContext=c;
        array=paths;
        width=x;

    }
    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView ;
        if (convertView==null){
            imageView = new ImageView(mContext);
        }else {

            imageView = (ImageView)convertView;
        }
        // 7an3mel placeholder 3shan lo 2l sora 2t5ret sora tanya hea 2l tfta7
        Drawable d = resizeDrawable(mContext.getResources().getDrawable(R.drawable.placeholder));
        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185" + array.get(position)).resize(width, (int) (width*1.5)).placeholder(d).into(imageView);
        return imageView;
    }
    private Drawable resizeDrawable(Drawable image){
        Bitmap b= ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b,width,(int)(width *1.5),false );
        return  new BitmapDrawable(mContext.getResources(),bitmapResized);
    }
}
