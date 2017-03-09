package com.patloew.template.ui.main

import com.shekar.alamomvp.ui.base.BaseViewModel
import com.shekar.alamomvp.ui.kotlinsample.MainView
import javax.inject.Inject


class MainViewModel
@Inject
constructor() : BaseViewModel<MainView>() {
  fun loadData() {
    mvvmView?.showToast()
  }
}


