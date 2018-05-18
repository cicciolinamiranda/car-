package com.carmudi.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.carmudi.exam.client.ApiException;
import com.carmudi.exam.client.JsonUtil;
import com.carmudi.exam.client.model.Results;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        try {
            Results results = (Results) JsonUtil.deserialize(getIntent().getStringExtra(Results.class.getName()), "", Results.class) ;
            Log.d(ItemDetailsActivity.class.getName(), results.toString());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
