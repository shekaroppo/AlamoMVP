package com.shekar.alamomvp.injection.module;

import com.shekar.alamomvp.MVPApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Shekar on 7/3/15.
 */

@Module
public class AppModule {
    MVPApplication application;

    public AppModule(MVPApplication app) {
        application = app;
    }

    @Provides
    MVPApplication provideBaseApplication() {
        return application;
    }
}
