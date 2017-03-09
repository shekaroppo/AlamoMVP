package com.shekar.alamomvp.ui.kotlinsample

import android.os.Bundle
import android.widget.Toast
import com.patloew.template.ui.main.MainViewModel
import com.shekar.alamomvp.R
import com.shekar.alamomvp.databinding.ActivityMainBinding
import com.shekar.alamomvp.injection.component.ActivityComponent
import com.shekar.alamomvp.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainView, MainViewModel>(), MainView {
  override fun showToast() {
    Toast.makeText(this, "Woooooooooow", Toast.LENGTH_LONG).show()
  }

  override fun onComponentCreated(component: ActivityComponent?) {
    component?.inject(this)
  }

  override fun layoutId(): Int {
    return R.layout.activity_main
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.loadData()
  }
}
