package com.carmudi.exam.client.asynctask;

import android.os.AsyncTask;

/**
 * Created by cicciolina on 5/18/18.
 */

public class RestGetItemsAsyncTask extends AsyncTask<Void, Void, String> {

    private String endpoint;
    private int page;
    private int numperPage;
    private String sortBy;
    private RestGetItemsAsyncTask.Listener listener;

    public RestGetItemsAsyncTask(String endpoint,
                                 int page,
                                 int numperPage,
                                 String sortBy,
                                 RestGetItemsAsyncTask.Listener listener) {
        this.endpoint = endpoint;
        this.page = page;
        this.numperPage = numperPage;
        this.sortBy = sortBy;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... voids) {

//        JSONObject obj = HttpClient.SendHttpGetWithoutParamAndAuth(this.endpoint
//                +"/page:" +this.page+
//                "/maxitems:" +this.numperPage+
//                "/sort:"+this.sortBy);

//        String result = obj.toString();

        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        listener.result(result);
    }

    public interface Listener {
        void result(String result);
    }
}
