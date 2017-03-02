package com.shekar.alamomvp.ui.category;

import android.util.Log;
import com.shekar.alamomvp.data.DataManager;
import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.ui.base.BasePresenter;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryPresenter extends BasePresenter<CategoryMvpView> {

    private CategoryMvpView mCategoryMvpView;
    private CompositeSubscription compositeSubscription;
    private DataManager mDataManager;

    public CategoryPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(CategoryMvpView categoryMvpView) {
        mCategoryMvpView = categoryMvpView;
    }

    public void loadData() {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        mCategoryMvpView.showProgress();

        compositeSubscription.add(mDataManager.getCategorys().observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<CategoryModel>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mCategoryMvpView.hideProgress();
                mCategoryMvpView.showError();
            }

            @Override
            public void onNext(List<CategoryModel> categoryModels) {
                mCategoryMvpView.hideProgress();
                mCategoryMvpView.showContent(categoryModels);
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
        mCategoryMvpView = null;
    }
}
