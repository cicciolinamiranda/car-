package com.carmudi.exam.presenter;

import android.app.Activity;
import android.content.Context;

import com.carmudi.exam.R;
import com.carmudi.exam.client.asynctask.RestGetItemsAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

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
                            JSONObject jsnobject = new JSONObject(result);
//
//                            if(null != jsnobject.get("metadata")) {
//                            }
//                            else if(null != jsnobject.get("detail")) {
//                                RestCallServices.this.failedPost(listener, RestCalls.PRODUCTS
//                                        , jsnobject.get("detail").toString());
//                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }


                    }
                }).execute();

    }

    public interface Listener {

    }
}
