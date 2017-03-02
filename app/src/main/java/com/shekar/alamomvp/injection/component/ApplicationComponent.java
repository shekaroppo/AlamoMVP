package com.shekar.alamomvp.injection.component;

import com.shekar.alamomvp.datamanager.DataManager;
import com.shekar.alamomvp.injection.module.AppModule;
import com.shekar.alamomvp.injection.module.NetworkModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Shekar on 7/3/15.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
})
public interface ApplicationComponent {
    DataManager getDataManager();
}
