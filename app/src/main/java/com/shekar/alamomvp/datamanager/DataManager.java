package com.shekar.alamomvp.datamanager;

import com.shekar.alamomvp.model.CategoryModel;
import com.shekar.alamomvp.services.ApiService;
import java.util.List;
import rx.Observable;

/**
 * Created by Shekar on 6/22/16.
 */

public class DataManager {
    private ApiService mApiService;

    public DataManager(ApiService apiService) {

        mApiService = apiService;
    }

    public Observable<List<CategoryModel>> getCategorys() {
        return mApiService.getCategorys();
    }
}
