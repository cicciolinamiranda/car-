package com.carmudi.exam.client.model;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Meta
{
    private String price_conditions_id;

    private String price;

    private String price_not_available;

    private String original_price;

    private String original_price_currency;

    private String sku;

    private String price_conditions_position;

    public String getPrice_conditions_id ()
    {
        return price_conditions_id;
    }

    public void setPrice_conditions_id (String price_conditions_id)
    {
        this.price_conditions_id = price_conditions_id;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getPrice_not_available ()
    {
        return price_not_available;
    }

    public void setPrice_not_available (String price_not_available)
    {
        this.price_not_available = price_not_available;
    }

    public String getOriginal_price ()
    {
        return original_price;
    }

    public void setOriginal_price (String original_price)
    {
        this.original_price = original_price;
    }

    public String getOriginal_price_currency ()
    {
        return original_price_currency;
    }

    public void setOriginal_price_currency (String original_price_currency)
    {
        this.original_price_currency = original_price_currency;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }

    public String getPrice_conditions_position ()
    {
        return price_conditions_position;
    }

    public void setPrice_conditions_position (String price_conditions_position)
    {
        this.price_conditions_position = price_conditions_position;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [price_conditions_id = "+price_conditions_id+", price = "+price+", price_not_available = "+price_not_available+", original_price = "+original_price+", original_price_currency = "+original_price_currency+", sku = "+sku+", price_conditions_position = "+price_conditions_position+"]";
    }
}
