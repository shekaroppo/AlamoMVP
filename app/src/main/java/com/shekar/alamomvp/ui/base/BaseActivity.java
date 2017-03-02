package com.shekar.alamomvp.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.shekar.alamomvp.MVPApplication;
import com.shekar.alamomvp.injection.component.ActivityComponent;
import com.shekar.alamomvp.injection.component.DaggerActivityComponent;
import com.shekar.alamomvp.injection.module.ActivityModule;
import javax.inject.Inject;

public abstract class BaseActivity<B extends Presenter> extends AppCompatActivity {
  protected ActivityComponent component;

  @Inject protected B mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onComponentCreated(getComponent());
    mPresenter.attachView((MvpView) this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }

  public ActivityComponent getComponent() {
    if (component == null) {
      component = DaggerActivityComponent.builder()
          .applicationComponent(((MVPApplication) getApplication()).getComponent())
          .activityModule(new ActivityModule())
          .build();
    }
    return component;
  }
  protected abstract void onComponentCreated(ActivityComponent component);
}
