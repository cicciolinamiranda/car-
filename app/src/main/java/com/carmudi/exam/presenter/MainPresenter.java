package com.carmudi.exam.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.carmudi.exam.R;
import com.carmudi.exam.client.ApiException;
import com.carmudi.exam.client.JsonUtil;
import com.carmudi.exam.client.asynctask.RestGetItemsAsyncTask;
import com.carmudi.exam.client.model.CarDataModel;
import com.carmudi.exam.client.model.Results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cicciolina on 5/18/18.
 */

public class MainPresenter {

    private Activity mActivity;
    private Context mContext;
    private Listener mListener;

    public MainPresenter(Activity activity, Context context, MainPresenter.Listener listener) {
        this.mActivity = activity;
        this.mContext = context;
        this.mListener = listener;
    }

    public void getData(int page, String sortby, int numperpage) {
        new RestGetItemsAsyncTask(this.mContext.getString(R.string.endpoint_server), page, numperpage, sortby,
                new RestGetItemsAsyncTask.Listener() {
                    @Override
                    public void result(String result) {

                        try {
                            CarDataModel carDataModel = (CarDataModel) JsonUtil.deserialize(result,  "", CarDataModel.class);

                            Log.d(MainPresenter.class.getName(), carDataModel.toString());

                            int total = 0;
                            List<Results> resultsList = new ArrayList<Results>();

                            if(carDataModel != null)
                            {
                                if(carDataModel.getMetadata() != null &&
                                        carDataModel.getMetadata().getProduct_count() != null &&
                                        Integer.class.isInstance(carDataModel.getMetadata().getProduct_count())) {
                                    total = Integer.parseInt(carDataModel.getMetadata().getProduct_count());
                                }

                                if(carDataModel.getMetadata() != null &&
                                        carDataModel.getMetadata().getResults() != null) {
                                    resultsList = Arrays.asList(carDataModel.getMetadata().getResults());
                                }
                            }

                            mListener.getDataResponse(resultsList, total);

                        } catch (ApiException e) {
                            mListener.errorOccurred(e.getLocalizedMessage());
                        }


                    }
                }).execute();

    }

    public interface Listener {
        void getDataResponse(List<Results> results, int totalProductCount);
        void errorOccurred(String error);
    }
}
