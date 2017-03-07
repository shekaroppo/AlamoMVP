package com.shekar.alamomvp.ui.category;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shekar.alamomvp.R;
import com.shekar.alamomvp.data.model.CategoryModel;
import com.shekar.alamomvp.databinding.ExampleListItemBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<CategoryModel> mData = new ArrayList<>();

    public void setData(List<CategoryModel> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.example_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      holder.binder.setViewModel(mData.get(position));
      holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
      private final ExampleListItemBinding binder;

        public ViewHolder(View v) {
            super(v);
          binder = DataBindingUtil.bind(v);
        }
    }
}