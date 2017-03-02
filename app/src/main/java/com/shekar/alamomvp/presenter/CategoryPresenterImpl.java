package com.shekar.alamomvp.presenter;

import android.util.Log;
import com.shekar.alamomvp.datamanager.DataManager;
import com.shekar.alamomvp.model.CategoryModel;
import com.shekar.alamomvp.view.MvpView;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryPresenterImpl implements CategoryPresenter {

    private MvpView mMvpView;
    private CompositeSubscription compositeSubscription;
    private DataManager mDataManager;

    public CategoryPresenterImpl(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MvpView mvpView) {
        mMvpView = mvpView;
    }


    @Override
    public void loadData() {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        mMvpView.showProgress();

        compositeSubscription.add(mDataManager.getCategorys().observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<CategoryModel>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mMvpView.hideProgress();
                mMvpView.showError();
            }

            @Override
            public void onNext(List<CategoryModel> categoryModels) {
                mMvpView.hideProgress();
                mMvpView.showContent(categoryModels);
            }
        }));
    }

    @Override
    public void unsubscribeFromDataStore() {
        Log.d("TAG", "unsubscribeFromDataStore ");
        compositeSubscription.unsubscribe();
        compositeSubscription.clear();
        compositeSubscription = null;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }
}
