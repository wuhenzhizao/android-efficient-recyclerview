package com.wuhenzhizao.view.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.gomeos.mvvm.utils.ScreenUtils;
import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseActivity;
import com.gomeos.mvvm.viewmodel.ViewModelFactory;
import com.wuhenzhizao.MainModule;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ActivityDragBinding;
import com.wuhenzhizao.viewmodule.DragViewModel;

/**
 * Created by liufei on 2017/9/13.
 */

public class DragActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDragBinding binding = DataBindingFactory.setContentView(this, R.layout.activity_drag);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("DragRecyclerView");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        DragViewModel viewModel = factory.createViewModel("drag_view_model", DragViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return true;
    }
}