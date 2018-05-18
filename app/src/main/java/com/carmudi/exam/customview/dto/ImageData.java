package com.carmudi.exam.customview.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageData implements Parcelable {
    String url;
    float mOrientaion;

    public ImageData(String url) {
        this.url = url;
    }
    public float getmOrientaion() {
        return mOrientaion;
    }

    public void setmOrientaion(float mOrientaion) {
        this.mOrientaion = mOrientaion;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeFloat(this.mOrientaion);
    }

    protected ImageData(Parcel in) {
        this.url = in.readString();
        this.mOrientaion = in.readFloat();
    }

    public static final Parcelable.Creator<ImageData> CREATOR = new Parcelable.Creator<ImageData>() {
        @Override
        public ImageData createFromParcel(Parcel source) {
            return new ImageData(source);
        }

        @Override
        public ImageData[] newArray(int size) {
            return new ImageData[size];
        }
    };
}
