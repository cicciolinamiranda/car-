package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class CarDataModel
{
    private Session session;

    private String success;

    private Messages messages;

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
