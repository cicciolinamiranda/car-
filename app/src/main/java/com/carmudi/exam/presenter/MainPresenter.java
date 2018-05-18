package com.carmudi.exam.presenter;

import android.app.Activity;
import android.content.Context;

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




    public interface Listener {

    }
}
