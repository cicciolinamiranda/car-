package com.carmudi.exam;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.carmudi.exam.adapter.ListCarAdapter;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.customview.ExpandableHeightListView;
import com.carmudi.exam.customview.ScrollViewExt;
import com.carmudi.exam.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener, ScrollViewExt.ScrollViewListener {

    private static final int PAGE_START = 1;
    private static final int NUM_PER_PAGE = 10;

    private int currentPage = PAGE_START;
    private MainPresenter mainPresenter;
    private String sortBy = "newest";

    private ExpandableHeightListView listCar;
    private ListCarAdapter listCarAdapter;
    private SwipeRefreshLayout swipeContainer;
    private List<Results> resultsList;
    private ScrollViewExt scrollView;
    private boolean isLoading;
    private int totalItemsCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollViewExt) findViewById(R.id.scroll_metrics_item);
        scrollView.setScrollViewListener(this);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer_activity_main);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        listCar = (ExpandableHeightListView) findViewById(R.id.list_car_item);
        listCar.setExpanded(true);

        this.mainPresenter = new MainPresenter(this, this, this);
        startGetData();

    }

    private void refreshData(){
        currentPage = 1;
        startGetData();
    }

    public void startGetData() {

        Thread startGetData = new Thread(new Runnable() {
            @Override
            public void run() {
                mainPresenter.getData(currentPage, sortBy, NUM_PER_PAGE);
            }
        });
        startGetData.start();
    }

    @Override
    public void getDataResponse(List<Results> results, int totalProductCount, int page) {

        this.isLoading = false;
        this.totalItemsCount = totalProductCount;

        if(results != null && !results.isEmpty()) {

            if(page <= PAGE_START) {
                resultsList = new ArrayList<>(results);
            } else {
                resultsList.addAll(results);
            }

            listCarAdapter = new ListCarAdapter(this, resultsList);
            listCar.setAdapter(listCarAdapter);
            listCarAdapter.notifyDataSetChanged();
        }



        if(swipeContainer != null) {
            swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void errorOccurred(String error) {

    }

    @Override
    public void onScrollChanged(ScrollViewExt scrollView, int x, int y, int oldx, int oldy) {
        View view = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

        // if diff is zero, then the bottom has been reached
        if (diff == 0 && !isLoading && resultsList != null && resultsList.size() < totalItemsCount) {
                isLoading = true;
                currentPage++;
                startGetData();
        }
    }
}
