package com.shekar.alamomvp.ui.category;

import android.util.Log;
import com.shekar.alamomvp.data.DataManager;
import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.ui.base.BaseViewModel;
import java.util.List;
import javax.inject.Inject;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Shekar on 3/3/17.
 */

public class CategoryViewModel extends BaseViewModel<CategoryView> {
  private CompositeSubscription compositeSubscription;
  private DataManager mDataManager;

  @Inject
  public CategoryViewModel(DataManager dataManager) {
    mDataManager = dataManager;
  }

  public void loadData() {
    if (compositeSubscription == null) {
      compositeSubscription = new CompositeSubscription();
    }
    getMvvmView().showProgress();
    compositeSubscription.add(mDataManager.getCategorys()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<CategoryModel>>() {
          @Override public void onCompleted() {
          }

          @Override public void onError(Throwable e) {
            getMvvmView().hideProgress();
            getMvvmView().showError();
          }

          @Override public void onNext(List<CategoryModel> categoryModels) {
            getMvvmView().hideProgress();
            getMvvmView().showContent(categoryModels);
          }
        }));
  }

  @Override public void unsubscribeFromDataStore() {
    Log.d("TAG", "unsubscribeFromDataStore ");
    compositeSubscription.unsubscribe();
    compositeSubscription.clear();
    compositeSubscription = null;
  }
}
