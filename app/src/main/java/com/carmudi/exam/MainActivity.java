package com.carmudi.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.carmudi.exam.adapter.ListCarAdapter;
import com.carmudi.exam.client.model.Results;
import com.carmudi.exam.customview.ExpandableHeightListView;
import com.carmudi.exam.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener {

    private static final int PAGE_START = 1;
    private static final int NUM_PER_PAGE = 10;

    private int currentPage = PAGE_START;
    private MainPresenter mainPresenter;
    private String sortBy = "newest";

    private ExpandableHeightListView listCar;
    private ListCarAdapter listCarAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCar = (ExpandableHeightListView) findViewById(R.id.list_car_item);
        listCar.setExpanded(true);
        this.mainPresenter = new MainPresenter(this, this, this);
        this.mainPresenter.getData(currentPage, sortBy, NUM_PER_PAGE);

    }

    @Override
    public void getDataResponse(List<Results> results, int totalProductCount) {

        if(results != null) {
            listCarAdapter = new ListCarAdapter(this, results);
            listCarAdapter.notifyDataSetChanged();

            listCar.setAdapter(listCarAdapter);
        }
    }

    @Override
    public void errorOccurred(String error) {

    }
}
