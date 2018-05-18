package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Attributes
{
    private String price_conditions;

    public String getPrice_conditions ()
    {
        return price_conditions;
    }

    public void setPrice_conditions (String price_conditions)
    {
        this.price_conditions = price_conditions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [price_conditions = "+price_conditions+"]";
    }
}
