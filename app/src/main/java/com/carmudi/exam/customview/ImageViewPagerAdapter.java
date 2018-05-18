package com.carmudi.exam.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.carmudi.exam.R;
import com.carmudi.exam.customview.listener.OnItemClickListener;
import com.carmudi.exam.customview.listener.OnSetImageListener;
import com.carmudi.exam.util.ImageUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageViewPagerAdapter extends ViewPagerAdapter {

    protected static final String TAG = ImageViewPagerAdapter.class.getSimpleName();
    protected Context mContext;
    protected OnItemClickListener mOnPagerItemClick;
    protected OnSetImageListener mOnSetImageListener;

    protected ArrayList<String> paths;

    public ImageViewPagerAdapter(Context context,@NonNull OnSetImageListener onSetImageListener ) {
        mContext = context;
        mOnSetImageListener = onSetImageListener;
        paths = new ArrayList<String>();
    }

    @Override
    public View getItem(final int position) {
        final ImageView imageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.item_view_pager_image,null);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnPagerItemClick != null){
                    mOnPagerItemClick.onPagerItemClick(v,position);
                }


//                        Intent intent = new Intent(mContext,
//                                ImageFullScreenActivity.class);
//                        intent.putExtra("image_path", paths.get(position));
//                mContext.startActivity(intent);
              /*  ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(context,
                                imageSwitcher.getCurr, "image");
                startActivityForResult(intent, REQUEST_IMAGE_VIEW, options.toBundle());*/

            }
        });

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 2;
        //place bitmapoptions back when needed
        Bitmap bitmap = BitmapFactory.decodeFile(paths.get(position), options);

        int rotationDegree = ImageUtil.getExifRotation(ImageUtil
                .getFromMediaUri(
                        mContext,
                        mContext.getContentResolver(),
                        Uri.parse(new File(paths.get(position)).toString())));

        if (rotationDegree > 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(rotationDegree);
            Log.w(TAG, "recreating bitmap with rotation of " + rotationDegree + " degrees" );
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        if(mOnSetImageListener != null ){
            mOnSetImageListener.setImage(imageView,position);
        }
        else{
            //imageView.setImageResource(mImageResources[position]);
            //if(bitmap != null)
            {
                imageView.setImageBitmap(
                        //scaleBitmapDown(
                        bitmap
                        //      , 1200)
                );
            }
            //imageView.setImagesetImageURI(Uri.fromFile(new File(paths.get(position))));
        }
        return imageView;
    }

    @Override
    public int getCount() {
        return paths.size();
    }

    public void setImageResources(@NonNull @ArrayRes @Size(min = 2) int[] imageResources){
    }

    public void addImage(String path){
        paths.add(path);
        notifyDataSetChanged();
    }

    public void setOnPagerItemClick(@NonNull OnItemClickListener onPagerItemClickListener){
        mOnPagerItemClick = onPagerItemClickListener;
    }
}
