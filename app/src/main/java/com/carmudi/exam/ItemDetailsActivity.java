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

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageSwitcher imgSwitcher;
    private Results result;
    private TextView tvCarName;
    private TextView tvCarAddress;
    private TextView tvCarContactPersonName;
    private TextView tvCarContactPersonEmail;
    private TextView tvCarContactPersonHomePhoneNum;
    private TextView tvCarContactPersonMobileNum;

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
