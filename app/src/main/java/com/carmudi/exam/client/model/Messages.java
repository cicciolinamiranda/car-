package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Messages
{
    private String[] success;

    public String[] getSuccess ()
    {
        return success;
    }

    public void setSuccess (String[] success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [success = "+success+"]";
    }
}

