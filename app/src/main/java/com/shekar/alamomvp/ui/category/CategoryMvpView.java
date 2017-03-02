package com.shekar.alamomvp.ui.category;

import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.ui.base.MvpView;
import java.util.List;

/**
 * Created by Sekhar on 4/6/15.
 */
public interface CategoryMvpView extends MvpView {
  public void showProgress();

  public void hideProgress();

  public void showContent(List<CategoryModel> data);

  public void showError();
}
