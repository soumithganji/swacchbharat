package com.example.swatchbharat;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private ArrayList<AndroidVersion> android_versions;
    private final LinkedList<String> mWordList;
    //private final LinkedList<Image> mImageList;
    private LayoutInflater mInflater;
    private String imageUrl;
    private Context context;

    public WordListAdapter(Context context, LinkedList<String> wordList, Context imageList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        //this.mImageList=imageList;
        this.context=context;
        this.android_versions = android_versions;

    }

    public WordListAdapter(Context context,LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;

    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mItemView = mInflater.inflate(R.layout.list, parent, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

    }

    //@Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position,int i) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
        Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(WordViewHolder.img_android);
    }


    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    static class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static ImageView img_android;
        public final TextView wordItemView;
        public ImageView imageView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            imageView =(ImageView)itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
            //tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView)itemView.findViewById(R.id.imageView);


        }

        @Override
        public void onClick(View v) {

        }
    }
    public String getImageUrl(){
        return imageUrl;
    }


}
