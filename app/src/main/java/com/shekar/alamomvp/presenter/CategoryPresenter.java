package com.shekar.alamomvp.presenter;

import com.shekar.alamomvp.view.MvpView;

/**
 * Created by Sekhar on 4/6/15.
 */
public interface CategoryPresenter {
    void loadData();

    void attachView(MvpView mvpView);

    void detachView();

    void unsubscribeFromDataStore();
}

