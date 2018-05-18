package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Session
{
    private String id;

    private String YII_CSRF_TOKEN;

    private String expire;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getYII_CSRF_TOKEN ()
    {
        return YII_CSRF_TOKEN;
    }

    public void setYII_CSRF_TOKEN (String YII_CSRF_TOKEN)
    {
        this.YII_CSRF_TOKEN = YII_CSRF_TOKEN;
    }

    public String getExpire ()
    {
        return expire;
    }

    public void setExpire (String expire)
    {
        this.expire = expire;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", YII_CSRF_TOKEN = "+YII_CSRF_TOKEN+", expire = "+expire+"]";
    }
}
