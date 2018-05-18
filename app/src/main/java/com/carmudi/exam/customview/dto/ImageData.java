package com.carmudi.exam.customview.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ImageData implements Parcelable {
    String id; //uuid
    String name; //pathname
    float mOrientaion;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    File file;

    public ImageData() {
    }
    public ImageData (String file, ArrayList<String> tags) {
        this.name = file;
    }


    public String getPathName() {
        return this.name;
    }

    public void setPathName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getmOrientaion() {
        return mOrientaion;
    }

    public void setmOrientaion(float mOrientaion) {
        this.mOrientaion = mOrientaion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeSerializable(this.file);
        dest.writeFloat(this.mOrientaion);
    }

    protected ImageData(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.file = (File) in.readSerializable();
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
