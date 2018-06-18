package com.carmudi.exam.client.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cicciolina on 5/18/18.
 */

public class CarDataModel
{
    @SerializedName("session")
    private Session session;

    @SerializedName("success")
    private String success;

    @SerializedName("messages")
    private Messages messages;

    @SerializedName("metadata")
    private Metadata metadata;

    public Session getSession ()
    {
        return session;
    }

    public void setSession (Session session)
    {
        this.session = session;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public Messages getMessages ()
    {
        return messages;
    }

    public void setMessages (Messages messages)
    {
        this.messages = messages;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [session = "+session+", success = "+success+", messages = "+messages+", metadata = "+metadata+"]";
    }
}
