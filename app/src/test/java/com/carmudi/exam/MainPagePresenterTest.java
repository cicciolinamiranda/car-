package com.carmudi.exam;

import android.util.Log;

import com.carmudi.exam.adapter.enums.SortByType;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.presenter.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLooper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by cicciolina on 5/19/18.
 */

//@RunWith(MockitoJUnitRunner.class)
@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class MainPagePresenterTest {

    private static final String ENDPOINT = "https://www.carmudi.co.id/api/cars/";

    private static final int PAGE = 1;

    private static final int NUMPERPAGE = 10;

    private static final String SORT_BY = SortByType.values()[0].getQueryValue();

    private List<Results> results;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        this.results = new ArrayList<>();
        Robolectric.getBackgroundThreadScheduler().pause();
        Robolectric.getForegroundThreadScheduler().pause();
    }

    @Test
    public void testGetData() {
        mainPresenter = new MainPresenter(new MainPresenter.Listener() {
            @Override
            public void getDataResponse(List<Results> results, int totalProductCount, int page) {
                MainPagePresenterTest.this.results = results;
            }

            @Override
            public void errorOccurred(String error) {

            }
        });

        mainPresenter.getData(ENDPOINT, PAGE, SORT_BY, NUMPERPAGE);
        ShadowApplication.runBackgroundTasks();

        ShadowLooper.runUiThreadTasks();

        Log.w(MainPagePresenterTest.class.getName(), results.toString());
        assertEquals(10, results.size());
    }
}
