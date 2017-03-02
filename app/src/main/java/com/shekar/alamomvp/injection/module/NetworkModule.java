package com.shekar.alamomvp.injection.module;

import com.shekar.alamomvp.datamanager.DataManager;
import com.shekar.alamomvp.services.ApiService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

/**
 * Created by Shekar on 7/4/15.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint("http://api-v2.hearthis.at");
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    @Provides
    @Singleton
    ApiService provideCategoryAPI(RestAdapter restAdapter) {
        return restAdapter.create(ApiService.class);
    }

    @Provides
    @Singleton DataManager getDataManager(ApiService apiService) {
        return new DataManager(apiService);
    }
}
