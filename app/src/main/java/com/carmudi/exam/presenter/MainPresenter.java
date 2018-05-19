package com.carmudi.exam.presenter;

import android.util.Log;

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

    private Listener mListener;

    public MainPresenter(MainPresenter.Listener listener) {
        this.mListener = listener;
    }

    public void getData(final String endpoint, final int page, final String sortby, final int numperpage) {
        new RestGetItemsAsyncTask(endpoint, page, numperpage, sortby,
                new RestGetItemsAsyncTask.Listener() {
                    @Override
                    public void result(String result) {

                        try {
                            CarDataModel carDataModel = (CarDataModel) JsonUtil.deserialize(result,  "", CarDataModel.class);

                            Log.d(MainPresenter.class.getName(), carDataModel.toString());

                            int total = 0;
                            List<Results> resultsList = new ArrayList<>();

                            if(carDataModel != null)
                            {
                                if(carDataModel.getMetadata() != null &&
                                        carDataModel.getMetadata().getProduct_count() != null &&
                                        !carDataModel.getMetadata().getProduct_count().isEmpty()) {
                                    total = Integer.parseInt(carDataModel.getMetadata().getProduct_count());
                                }

                                if(carDataModel.getMetadata() != null &&
                                        carDataModel.getMetadata().getResults() != null) {
                                    resultsList = Arrays.asList(carDataModel.getMetadata().getResults());
                                }
                            }

                            mListener.getDataResponse(resultsList, total, page);

                        } catch (ApiException e) {
                            mListener.errorOccurred(e.getLocalizedMessage());
                        } catch (NumberFormatException e) {
                            mListener.errorOccurred(e.getLocalizedMessage());
                        }


                    }
                }).execute();

    }

    public interface Listener {
        void getDataResponse(List<Results> results, int totalProductCount, int page);
        void errorOccurred(String error);
    }
}
