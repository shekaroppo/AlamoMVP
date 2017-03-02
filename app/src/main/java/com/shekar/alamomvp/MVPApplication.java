package com.shekar.alamomvp;

import android.app.Application;
import com.shekar.alamomvp.injection.component.ApplicationComponent;
import com.shekar.alamomvp.injection.component.DaggerApplicationComponent;
import com.shekar.alamomvp.injection.module.AppModule;

public class MVPApplication extends Application {

  private ApplicationComponent component;

  public ApplicationComponent getComponent() {
    if (component == null) {
      component = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
    }
    return component;
  }
}

