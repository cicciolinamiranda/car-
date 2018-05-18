package com.carmudi.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.carmudi.exam.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener {

    private static final int PAGE_START = 1;
    private static final int NUM_PER_PAGE = 10;

    private int currentPage = PAGE_START;
    private MainPresenter mainPresenter;
    private String sortBy = "newest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainPresenter = new MainPresenter(this, this, this);
        this.mainPresenter.getData(currentPage, sortBy, NUM_PER_PAGE);

    }
}
