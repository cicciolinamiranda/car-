package com.carmudi.exam.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.carmudi.exam.R;
import com.carmudi.exam.customview.listener.OnItemClickListener;
import com.carmudi.exam.customview.listener.OnSetImageListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageViewPagerAdapter extends ViewPagerAdapter {

    protected static final String TAG = ImageViewPagerAdapter.class.getSimpleName();
    protected Context mContext;
    protected OnItemClickListener mOnPagerItemClick;
    protected OnSetImageListener mOnSetImageListener;

    protected ArrayList<String> urls;

    public ImageViewPagerAdapter(Context context,@NonNull OnSetImageListener onSetImageListener ) {
        mContext = context;
        mOnSetImageListener = onSetImageListener;
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


        if(mOnSetImageListener != null ){
            mOnSetImageListener.setImage(imageView,position);
        }
        return imageView;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    public void setImageResources(@NonNull @ArrayRes @Size(min = 2) int[] imageResources){
    }

    public void addImage(String url){
        urls.add(url);
        notifyDataSetChanged();
    }

    public void setOnPagerItemClick(@NonNull OnItemClickListener onPagerItemClickListener){
        mOnPagerItemClick = onPagerItemClickListener;
    }

        /*
        AsyncTask enables proper and easy use of the UI thread. This class
        allows to perform background operations and publish results on the UI
        thread without having to manipulate threads and/or handlers.
     */

    /*
        final AsyncTask<Params, Progress, Result>
            execute(Params... params)
                Executes the task with the specified parameters.
     */
    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
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
