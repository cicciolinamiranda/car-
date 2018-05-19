package com.carmudi.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.carmudi.exam.client.ApiException;
import com.carmudi.exam.client.JsonUtil;
import com.carmudi.exam.client.model.Images;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.customview.ImageSwitcher;
import com.carmudi.exam.customview.dto.ImageData;
import com.carmudi.exam.util.Util;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Map;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageSwitcher imgSwitcher;
    private Results result;
    private TextView tvCarName;
    private TextView tvCarAddress;
    private TextView tvCarContactPersonName;
    private TextView tvCarContactPersonEmail;
    private TextView tvCarContactPersonHomePhoneNum;
    private TextView tvCarContactPersonMobileNum;
    private TextView tvCarPrice;
    private TextView tvCarMileage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        tvCarName = (TextView) findViewById(R.id.textItemDetailCarName);
        tvCarAddress = (TextView) findViewById(R.id.tvItemDetailCarLocation);
        tvCarContactPersonName = (TextView) findViewById(R.id.tvItemDetailContactPersonName);
        tvCarContactPersonEmail = (TextView) findViewById(R.id.tvItemDetailContactPersonEmail);
        tvCarContactPersonHomePhoneNum = (TextView) findViewById(R.id.tvItemDetailContactPersonHomePhoneNum);
        tvCarContactPersonMobileNum = (TextView) findViewById(R.id.tvItemDetailContactPersonMobileNum);
        tvCarPrice = (TextView) findViewById(R.id.textItemDetailCarPrice);
        tvCarMileage = (TextView) findViewById(R.id.textItemDetailCarMileage);
        imgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        try {
            result = (Results) JsonUtil.deserialize(getIntent().getStringExtra(Results.class.getName()), "", Results.class) ;
            Log.d(ItemDetailsActivity.class.getName(), result.toString());
        } catch (ApiException e) {
            e.printStackTrace();
        }

        if(result != null) {

            if(result.getData() != null) {

                getSupportActionBar().setTitle(result.getData().getOriginal_name());

                tvCarName.setText(result.getData().getName());

                tvCarAddress.setText(result.getData().getGoogle_formatted_address());

                tvCarContactPersonName.setText(result.getData().getItem_contact_name());

                tvCarContactPersonEmail.setText(result.getData().getItem_contact_email());

                tvCarContactPersonMobileNum.setText(result.getData().getItem_contact_mobile());

                tvCarContactPersonHomePhoneNum.setText(result.getData().getItem_contact_homephone());

                tvCarMileage.setText("Mileage: "+result.getData().getMileage());

                double price = 0;

                if(result.getData().getPrice() != null) {

                    try {
                        price = Double.parseDouble(result.getData().getPrice());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                String currency = "";

                if(result.getData().getSimples() != null) {

                    LinkedTreeMap<String, LinkedTreeMap> simplesDataMap = (LinkedTreeMap<String, LinkedTreeMap>) result.getData() .getSimples();

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

                tvCarPrice.setText(currency.toUpperCase()+" "+ Util.getInstance().truncateNumber(price, false).toLowerCase());
            }

            if (result.getImages() != null) {

                for (Images image : result.getImages()) {

                    if (image != null && image.getUrl() != null &&
                            !image.getUrl().isEmpty()) {
                        ImageData imageData = new ImageData(image.getUrl());
                        imgSwitcher.addImageData(imageData);
                        imgSwitcher.goToCurrentImage();
                    }
                }

            }
        }



    }
}
