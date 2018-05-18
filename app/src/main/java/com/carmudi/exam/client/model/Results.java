package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Results
{
    private String id;

    private Data data;

    private Images[] images;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public Images[] getImages ()
    {
        return images;
    }

    public void setImages (Images[] images)
    {
        this.images = images;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", data = "+data+", images = "+images+"]";
    }
}
