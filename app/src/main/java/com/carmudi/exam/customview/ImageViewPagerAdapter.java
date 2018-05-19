package com.carmudi.exam.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.carmudi.exam.R;
import com.carmudi.exam.customview.listener.OnItemClickListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageViewPagerAdapter extends ViewPagerAdapter {

    protected Context mContext;
    protected OnItemClickListener mOnPagerItemClick;

    protected ArrayList<String> urls;

    public ImageViewPagerAdapter(Context context) {
        mContext = context;
        urls = new ArrayList<>();
    }

    @Override
    public View getItem(final int position) {
        final ImageView imageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.item_view_pager_image,null);


        new DownLoadImageTask(imageView).execute(urls.get(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnPagerItemClick != null){
                    mOnPagerItemClick.onPagerItemClick(v,position);
                }



            }
        });

        return imageView;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    public void addImage(String url){
        urls.add(url);
        notifyDataSetChanged();
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();

                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }


    }
}
