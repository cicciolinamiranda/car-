package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Metadata
{
    private Results[] results;

    private String product_count;

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String getProduct_count ()
    {
        return product_count;
    }

    public void setProduct_count (String product_count)
    {
        this.product_count = product_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", product_count = "+product_count+"]";
    }
}
