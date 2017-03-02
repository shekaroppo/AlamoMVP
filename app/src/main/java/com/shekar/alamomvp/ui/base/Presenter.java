package com.shekar.alamomvp.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the CategoryMvpView type that wants to be attached with.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
