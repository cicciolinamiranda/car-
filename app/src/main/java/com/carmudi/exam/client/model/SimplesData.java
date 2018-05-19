package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/19/18.
 */

public class SimplesData {
    private Attributes attributes;

    private Meta meta;

    public Attributes getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (Attributes attributes)
    {
        this.attributes = attributes;
    }

    public Meta getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta meta)
    {
        this.meta = meta;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [attributes = "+attributes+", meta = "+meta+"]";
    }
}
