package com.shekar.alamomvp.injection.component;

import com.shekar.alamomvp.injection.module.ActivityModule;
import com.shekar.alamomvp.injection.scope.ActivityScope;
import com.shekar.alamomvp.ui.category.CategoryActivity;
import com.shekar.alamomvp.ui.kotlinsample.MainActivity;
import dagger.Component;

/**
 * Created by Shekar on 3/3/17.
 */

@ActivityScope @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class
}) public interface ActivityComponent {
  void inject(CategoryActivity categoryActivity);

  void inject(MainActivity mainActivity);
}
