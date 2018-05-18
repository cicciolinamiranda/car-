package com.carmudi.exam.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.carmudi.exam.customview.dto.ImageData;

import java.util.ArrayList;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageSwitcher extends SlidingSplashView {

    protected static final String TAG = ImageSwitcher.class.getSimpleName();
    protected ArrayList<ImageData> imageDatas;
    protected int currImageDataIndex;


    public ImageSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    protected void init(Context context) {
        currImageDataIndex = 0;
        imageDatas = new ArrayList<>();


    }

    public ArrayList<ImageData> getImageDatas() {
        return imageDatas;
    }

    public void setImageDatas(ArrayList<ImageData> imageDatas) {
        this.imageDatas = imageDatas;
    }

    public void addImageData(ImageData imageData){
        imageDatas.add(imageData);
        this.addImage(imageData.getUrl());
    }
    public ImageData getImageData(int index){
        return imageDatas.get(index);
    }

    public void setImagePath(String path){
        //this.setImageURI(Uri.fromFile(new File(path)));
    }

    public void nextImage(){
        if(currImageDataIndex < imageDatas.size()-1){
            currImageDataIndex++;
            this.setImagePath(imageDatas.get(currImageDataIndex).getUrl());
        }/*else{
            currImageDataIndex = 0; //index go around
        }*/
    }

    public void prevImage(){
        if(currImageDataIndex > 0){
            currImageDataIndex--;
            this.setImagePath(imageDatas.get(currImageDataIndex).getUrl());
        }
    }

    public void goToCurrentImage(){
        currImageDataIndex = imageDatas.size()-1;
        this.setImagePath(imageDatas.get(currImageDataIndex).getUrl());
        Log.d(TAG,"goToCurrentImage:"+ imageDatas.get(currImageDataIndex).getUrl());
    }

    public ImageData getCurrentImage(){
        return imageDatas != null ? imageDatas.get(currImageDataIndex) : null;
    }

    public ArrayList<String> getImageList(){

        ArrayList<String> images = new ArrayList<>();

        for(ImageData data: imageDatas) {
            images.add(data.getUrl());
        }

        return images;
    }


}
