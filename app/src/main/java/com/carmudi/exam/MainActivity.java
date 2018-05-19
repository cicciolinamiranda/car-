package com.carmudi.exam;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.carmudi.exam.adapter.ListCarAdapter;
import com.carmudi.exam.adapter.enums.SortByType;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener
    {

    private static final int PAGE_START = 1;
    private static final int NUM_PER_PAGE = 10;

    private int currentPage = PAGE_START;
    private MainPresenter mainPresenter;
    private SortByType sortByType;

    private ListView listCar;
    private ListCarAdapter listCarAdapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeContainer;
    private Spinner spinnerSortBy;
    private List<Results> resultsList;
    private boolean isLoading;
    private int totalItemsCount;

    private int diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer_activity_main);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshData();

            }
        });
        final ArrayAdapter<SortByType> sortByAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, SortByType.values());
        sortByAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerSortBy = (Spinner) findViewById(R.id.spinner_sort_list);
        spinnerSortBy.setAdapter(sortByAdapter);

        listCar = (ListView) findViewById(R.id.list_car_item);
        listCar.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View view = listCar.getChildAt(listCar.getChildCount() - 1);
                diff = (view.getBottom() - (listCar.getHeight() + listCar.getScrollY()));

                // if diff is zero, then the bottom has been reached
                if (diff == 0 && !isLoading && resultsList != null && resultsList.size() < totalItemsCount) {
                    isLoading = true;
                    currentPage++;

                    if(currentPage > PAGE_START) {
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    startGetData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        this.mainPresenter = new MainPresenter(this);

        spinnerSortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                sortByType = SortByType.values()[position];
                progressBar.setVisibility(View.VISIBLE);
                refreshData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void refreshData(){
        listCar.setVisibility(View.GONE);
        currentPage = PAGE_START;
        startGetData();
    }

    public void startGetData() {

        Thread startGetData = new Thread(new Runnable() {
            @Override
            public void run() {

                mainPresenter.getData(getString(R.string.endpoint_server), currentPage, sortByType.getQueryValue(), NUM_PER_PAGE);
            }
        });
        startGetData.start();
    }

    @Override
    public void getDataResponse(List<Results> results, int totalProductCount, int page) {

        this.isLoading = false;
        this.totalItemsCount = totalProductCount;
        listCar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        if(results != null && !results.isEmpty()) {

            if(page <= PAGE_START) {
                resultsList = new ArrayList<>(results);
            } else {
                resultsList.addAll(results);
            }

            listCarAdapter = new ListCarAdapter(this, resultsList);
            listCar.setAdapter(listCarAdapter);
            listCarAdapter.notifyDataSetChanged();

            if(page > PAGE_START) {
                listCar.smoothScrollToPosition(listCarAdapter.getCount()-6);
            }
        }



        if(swipeContainer != null) {
            swipeContainer.setRefreshing(false);
        }
    }

    @Override
    public void errorOccurred(String error) {

    }
}
