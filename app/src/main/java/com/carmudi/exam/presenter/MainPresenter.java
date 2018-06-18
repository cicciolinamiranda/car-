package com.carmudi.exam.presenter;

import android.util.Log;

import com.carmudi.exam.client.CarsService;
import com.carmudi.exam.client.model.CarDataModel;
import com.carmudi.exam.client.model.Results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cicciolina on 5/18/18.
 */

public class MainPresenter {

    private Listener mListener;
    private CarsService carsService;


    public MainPresenter(MainPresenter.Listener listener) {
        this.mListener = listener;

        if(this.carsService == null) {

            this.carsService = new CarsService();
        }

    }

    public void getData(final String endpoint, final int page, final String sortby, final int numperpage) {


        this.carsService.getApi(endpoint)
                .getCars(page, numperpage, sortby)
                .enqueue(new Callback<CarDataModel>() {
                    @Override
                    public void onResponse(Call<CarDataModel> call, Response<CarDataModel> response) {


                        try {
                            CarDataModel carDataModel = response.body();

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

                        }catch (NumberFormatException e) {
                            mListener.errorOccurred(e.getLocalizedMessage());
                        }

                    }

                    @Override
                    public void onFailure(Call<CarDataModel> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            mListener.errorOccurred(e.getLocalizedMessage());
                        }
                    }
                });
        //        new RestGetItemsAsyncTask(endpoint, page, numperpage, sortby,
//                new RestGetItemsAsyncTask.Listener() {
//                    @Override
//                    public void result(String result) {
//
//                        try {
//                            CarDataModel carDataModel = (CarDataModel) JsonUtil.deserialize(result,  "", CarDataModel.class);
//
//                            Log.d(MainPresenter.class.getName(), carDataModel.toString());
//
//                            int total = 0;
//                            List<Results> resultsList = new ArrayList<>();
//
//                            if(carDataModel != null)
//                            {
//                                if(carDataModel.getMetadata() != null &&
//                                        carDataModel.getMetadata().getProduct_count() != null &&
//                                        !carDataModel.getMetadata().getProduct_count().isEmpty()) {
//                                    total = Integer.parseInt(carDataModel.getMetadata().getProduct_count());
//                                }
//
//                                if(carDataModel.getMetadata() != null &&
//                                        carDataModel.getMetadata().getResults() != null) {
//                                    resultsList = Arrays.asList(carDataModel.getMetadata().getResults());
//                                }
//                            }
//
//                            mListener.getDataResponse(resultsList, total, page);
//
//                        } catch (ApiException e) {
//                            mListener.errorOccurred(e.getLocalizedMessage());
//                        } catch (NumberFormatException e) {
//                            mListener.errorOccurred(e.getLocalizedMessage());
//                        }
//
//
//                    }
//                }).execute();


    }

    public interface Listener {
        void getDataResponse(List<Results> results, int totalProductCount, int page);
        void errorOccurred(String error);
    }
}
