package com.carmudi.exam.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.carmudi.exam.ItemDetailsActivity;
import com.carmudi.exam.R;
import com.carmudi.exam.client.ApiException;
import com.carmudi.exam.client.JsonUtil;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.util.Util;

import java.util.List;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ListCarAdapter extends ArrayAdapter<Results> {

    private final List<Results> web;
    private final Activity activity;

    public ListCarAdapter(Activity activity, List<Results> web) {
        super(activity, R.layout.list_car_data, web);
        this.activity = activity;
        this.web = web;
    }

    @NonNull
    @Override
    public View getView(final int position, final @Nullable View convertView, final @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_car_data, null, true);
        TextView tvCarName = rowView.findViewById(R.id.tv_car_name_list_car_data);
        TextView tvCarPrice = rowView.findViewById(R.id.tv_car_price_list_car_data);

        double price = 0;

        if(web.get(position).getData() != null &&
                web.get(position).getData().getPrice() != null) {

            try {
                price = Double.parseDouble(web.get(position).getData().getPrice());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        tvCarPrice.setText(Util.getInstance().withSuffix(price));
        tvCarName.setText(web.get(position).getData().getName());

        TextView tvCarBrand = rowView.findViewById(R.id.tv_car_brand_list_car_data);
        tvCarBrand.setText(web.get(position).getData().getBrand());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, ItemDetailsActivity.class);
                try {
                    intent.putExtra(Results.class.getName(), JsonUtil.serialize(web.get(position)));
                    activity.startActivity(intent);
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        });


        return rowView;
    }

}
