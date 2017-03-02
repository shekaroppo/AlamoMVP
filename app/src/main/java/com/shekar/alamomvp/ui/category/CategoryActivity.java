package com.shekar.alamomvp.ui.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.shekar.alamomvp.R;
import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.ui.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryActivity extends BaseActivity implements CategoryMvpView {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.loadingView)
    ProgressBar mLoadingView;
    @Bind(R.id.errorView)
    TextView mErrorView;
    @Inject CategoryPresenter mPresenter;
    @Inject CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_category);
        mPresenter.attachView(this);
        ButterKnife.bind(this);
        setUI();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void loadData() {
        mPresenter.loadData();
    }

    private void setUI() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.unsubscribeFromDataStore();
    }

    @Override
    public void showProgress() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showContent(List<CategoryModel> data) {
        mAdapter.setData(data);
    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
    }
}
