package com.wuhenzhizao.viewmodule;

import android.widget.Toast;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.viewmodule.viewbean.StickyTestViewBean;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyItemViewModel extends RecyclerItemViewModel<StickyTestViewBean> {
    private String name;

    public String getName() {
        return name;
    }

    public OnClickCommand getOnClickCommand(){
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Toast.makeText(getContext(), "Item " + name + " clicked", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onItemChange(StickyTestViewBean oldItem, StickyTestViewBean item) {
        name = item.getName();
        notifyChange();
    }
}
