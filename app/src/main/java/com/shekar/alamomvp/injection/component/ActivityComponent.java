package com.shekar.alamomvp.injection.component;

import com.shekar.alamomvp.ui.base.BaseActivity;
import com.shekar.alamomvp.ui.category.CategoryActivity;
import com.shekar.alamomvp.injection.module.ActivityModule;
import com.shekar.alamomvp.injection.scope.ActivityScope;
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
    void inject(BaseActivity baseActivity);

    void inject(CategoryActivity categoryActivity);
}
