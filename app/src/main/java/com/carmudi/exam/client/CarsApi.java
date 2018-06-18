package com.carmudi.exam.client;

import com.carmudi.exam.client.model.CarDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ${$USER} on 6/19/18.
 */
public interface CarsApi {

    @GET("cars/page:{page}/maxitems:{maxitems}/sort:{sort}")
    Call<CarDataModel> getCars(@Path("page") int page,
                               @Path("maxitems") int maxItems, @Path("sort") String sort);
}
