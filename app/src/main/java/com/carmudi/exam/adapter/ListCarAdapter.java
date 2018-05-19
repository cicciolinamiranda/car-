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
import com.google.gson.internal.LinkedTreeMap;

import java.util.List;
import java.util.Map;

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

        String currency = "";

        if(web.get(position).getData().getSimples() != null) {

            LinkedTreeMap<String, LinkedTreeMap> simplesDataMap = (LinkedTreeMap<String, LinkedTreeMap>) web.get(position).getData().getSimples();

            //Key inside simples json object is dynamic. Need to manually parse
            Map.Entry<String,LinkedTreeMap> entrySimplesDataMap = simplesDataMap.entrySet().iterator().next();
            String key = entrySimplesDataMap.getKey();

            LinkedTreeMap<String, LinkedTreeMap> insideSimpleDatMap = simplesDataMap.get(key);
            LinkedTreeMap<String, String> metaMap = insideSimpleDatMap.get("meta");

            for (Map.Entry<String, String> metaEntry : metaMap.entrySet())
            {
                if(metaEntry.getKey().equals("original_price_currency")) {
                    currency = metaEntry.getValue();
                    break;
                }
            }

        }

        tvCarPrice.setText("Price ("+currency.toLowerCase()+") :"+Util.getInstance().truncateNumber(price, true));
        tvCarName.setText(web.get(position).getData().getOriginal_name());

        TextView tvCarMileage = rowView.findViewById(R.id.tv_car_mileage_list_car_data);
        tvCarMileage.setText("Mileage: "+web.get(position).getData().getMileage());

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
