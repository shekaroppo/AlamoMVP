package com.shekar.alamomvp.services;

import com.shekar.alamomvp.model.CategoryModel;
import java.util.List;
import retrofit.http.GET;
import rx.Observable;

public interface ApiService {
    @GET("/categories/") Observable<List<CategoryModel>> getCategorys();
}