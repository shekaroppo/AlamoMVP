package com.shekar.alamomvp.injection.module;

import com.shekar.alamomvp.injection.scope.ActivityScope;
import com.shekar.alamomvp.ui.category.CategoryAdapter;
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
}
