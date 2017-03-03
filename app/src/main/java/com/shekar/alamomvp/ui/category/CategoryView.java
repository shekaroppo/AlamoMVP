package com.shekar.alamomvp.ui.category;

import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.ui.base.MvvmView;
import java.util.List;

/**
 * Created by Shekar on 3/3/17.
 */

interface CategoryView extends MvvmView {
  void showContent(List<CategoryModel> data);
}
