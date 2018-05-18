package com.carmudi.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.carmudi.exam.client.ApiException;
import com.carmudi.exam.client.JsonUtil;
import com.carmudi.exam.client.model.Images;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.customview.ImageSwitcher;
import com.carmudi.exam.customview.dto.ImageData;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageSwitcher imgSwitcher;
    private Results result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        imgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        try {
            result = (Results) JsonUtil.deserialize(getIntent().getStringExtra(Results.class.getName()), "", Results.class) ;
            Log.d(ItemDetailsActivity.class.getName(), result.toString());
        } catch (ApiException e) {
            e.printStackTrace();
        }

        if(result != null && result.getImages() != null) {

            for(Images image: result.getImages()) {

                if(image != null && image.getUrl() != null &&
                        !image.getUrl().isEmpty()) {
                    ImageData imageData = new ImageData(image.getUrl());
                    imgSwitcher.addImageData(imageData);
                    imgSwitcher.goToCurrentImage();
                }
            }

        }



    }
}
