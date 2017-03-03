package com.shekar.alamomvp.injection.component;

import com.shekar.alamomvp.data.DataManager;
import com.shekar.alamomvp.injection.module.AppModule;
import com.shekar.alamomvp.injection.module.NetworkModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Shekar on 3/3/17.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
})
public interface ApplicationComponent {
    DataManager getDataManager();
}
