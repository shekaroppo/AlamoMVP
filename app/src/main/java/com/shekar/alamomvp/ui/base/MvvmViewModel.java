package com.shekar.alamomvp.ui.base;

public interface MvvmViewModel<V extends MvvmView>  {
    void attachView(V view);
    void detachView();
}
