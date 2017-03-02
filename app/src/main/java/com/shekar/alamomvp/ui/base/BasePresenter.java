package com.shekar.alamomvp.ui.base;

/**
 * Created by Sekhar on 4/6/15.
 */

import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mMvpView;
    protected CompositeSubscription compositeSubscription;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public void unsubscribeFromDataStore() {
      Timber.d("unsubscribeFromDataStore(): ");
        if(compositeSubscription!=null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
            compositeSubscription = null;
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(CategoryMvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}

