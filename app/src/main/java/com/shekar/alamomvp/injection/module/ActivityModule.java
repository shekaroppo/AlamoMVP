package com.shekar.alamomvp.injection.module;

import com.shekar.alamomvp.adapter.CategoryAdapter;
import com.shekar.alamomvp.datamanager.DataManager;
import com.shekar.alamomvp.injection.scope.ActivityScope;
import com.shekar.alamomvp.presenter.CategoryPresenter;
import com.shekar.alamomvp.presenter.CategoryPresenterImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Sekhar on 4/8/15.
 */
@Module
public class ActivityModule {

    @Provides
    @ActivityScope
    public CategoryAdapter provideCategoryAdapter() {
        return new CategoryAdapter();
    }

    @Provides
    @ActivityScope
    public CategoryPresenter provideCategoryPresenter(DataManager dataManager) {
        return new CategoryPresenterImpl(dataManager);
    }
}
