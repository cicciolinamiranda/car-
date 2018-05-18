package com.carmudi.exam.adapter.enums;

/**
 * Created by cicciolina on 5/18/18.
 */

public enum SortByType  {
    NEWEST("newest","Newest"),
    OLDEST("oldest","Oldest"),
    PRICE_LOW("price-low","Lowest Price"),
    PRICE_HIGH("price-high","Highest Price"),
    MILE_AGE_LOW("mileage-low","Lowest Mileage"),
    MILE_AGE_HIGH("mileage-high","Highest Mileage");

    String queryValue;
    String label
            ;
    SortByType(String queryValue, String label) {
        this.queryValue = queryValue;
        this.label = label;
    }

    public String getQueryValue() {
        return queryValue;
    }

    @Override
    public String toString() {
        return label;
    }
}
