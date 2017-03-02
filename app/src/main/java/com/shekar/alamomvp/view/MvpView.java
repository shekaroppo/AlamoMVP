package com.shekar.alamomvp.view;

import com.shekar.alamomvp.model.CategoryModel;
import java.util.List;

/**
 * Created by Sekhar on 4/6/15.
 */
public interface MvpView {
    public void showProgress();

    public void hideProgress();

    public void showContent(List<CategoryModel> data);

    public void showError();

}
