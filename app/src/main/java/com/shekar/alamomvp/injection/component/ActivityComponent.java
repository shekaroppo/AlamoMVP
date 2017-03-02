package com.shekar.alamomvp.injection.component;

import com.shekar.alamomvp.injection.module.ActivityModule;
import com.shekar.alamomvp.injection.scope.ActivityScope;
import com.shekar.alamomvp.ui.category.CategoryActivity;
import dagger.Component;

/**
 * Created by Shekar on 7/1/15.
 */


@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class
        })
public interface ActivityComponent {
    void inject(CategoryActivity categoryActivity);
}
