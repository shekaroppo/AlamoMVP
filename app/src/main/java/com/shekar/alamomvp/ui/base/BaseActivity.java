package com.shekar.alamomvp.ui.base;

import android.app.Activity;
import android.os.Bundle;
import com.shekar.alamomvp.MVPApplication;
import com.shekar.alamomvp.injection.component.ActivityComponent;
import com.shekar.alamomvp.injection.component.DaggerActivityComponent;
import com.shekar.alamomvp.injection.module.ActivityModule;

public abstract class BaseActivity extends Activity {
    protected ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public ActivityComponent getComponent() {
        if (component == null) {
            component = DaggerActivityComponent.builder().applicationComponent(((MVPApplication) getApplication()).getComponent())
                    .activityModule(new ActivityModule()).build();
        }
        return component;
    }
}
