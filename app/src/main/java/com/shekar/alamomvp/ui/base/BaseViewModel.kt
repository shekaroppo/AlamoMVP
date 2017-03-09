package com.shekar.alamomvp.ui.base

import android.databinding.BaseObservable
import rx.subscriptions.CompositeSubscription
import timber.log.Timber

abstract class BaseViewModel<T : MvvmView> : BaseObservable(), MvvmViewModel<T> {

  protected var compositeSubscription: CompositeSubscription? = null
  var mvvmView: T? = null

  override fun attachView(mvvmView: T) {
    this.mvvmView = mvvmView
  }

  override fun detachView() {
    mvvmView = null
  }

  val isViewAttached: Boolean
    get() = mvvmView != null

  fun checkViewAttached() {
    if (!isViewAttached) throw MvpViewNotAttachedException()
  }

  open fun unsubscribeFromDataStore() {
    Timber.d("unsubscribeFromDataStore(): ")
    if (compositeSubscription != null) {
      compositeSubscription!!.unsubscribe()
      compositeSubscription!!.clear()
      compositeSubscription = null
    }
  }

  class MvpViewNotAttachedException : RuntimeException(
      "Please call Presenter.attachView(CategoryMvpView) before" + " requesting data to the Presenter")
}