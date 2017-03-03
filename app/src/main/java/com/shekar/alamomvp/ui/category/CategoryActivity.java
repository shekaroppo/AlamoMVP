package com.shekar.alamomvp.ui.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.shekar.alamomvp.R;
import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.databinding.ActivityCategoryBinding;
import com.shekar.alamomvp.injection.component.ActivityComponent;
import com.shekar.alamomvp.ui.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryActivity extends BaseActivity<ActivityCategoryBinding, CategoryViewModel>
    implements CategoryView {

  @Inject CategoryAdapter mAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUI();
    loadData();
  }

  @Override protected void onComponentCreated(ActivityComponent component) {
    component.inject(this);
  }

  @Override protected void onResume() {
    super.onResume();
  }

  private void loadData() {
    viewModel.loadData();
  }

  private void setUI() {
    binding.recyclerView.setHasFixedSize(true);
    binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    binding.recyclerView.setAdapter(mAdapter);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    viewModel.unsubscribeFromDataStore();
  }

  @Override protected int layoutId() {
    return R.layout.activity_category;
  }

  @Override public void showContent(List<CategoryModel> data) {
    mAdapter.setData(data);
  }

  @Override public void showProgress() {
    binding.progressBinding.loadingView.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    binding.progressBinding.loadingView.setVisibility(View.GONE);
  }

  @Override public void showError() {
    binding.errorBinding.setVisibility(View.VISIBLE);
  }
}
