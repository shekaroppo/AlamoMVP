package com.shekar.alamomvp.data.services;

import com.shekar.alamomvp.data.model.CategoryModel;
import java.util.List;
import retrofit.http.GET;
import rx.Observable;

public interface ApiService {
    @GET("/categories/") Observable<List<CategoryModel>> getCategorys();
}