package com.hsc.functionapp.base;

import android.content.Intent;
import android.os.Bundle;

import com.hsc.functionapp.R;


/**
 * Created by Administrator on 2017/6/21 0021.
 * TODO:
 * LastChang:
 */

public abstract class AppActivity extends BaseActivity {
    /**
     * 获取第一个要展示的fragment
     * @return
     */
    protected abstract BaseFragment getFirstFragment();

    /**
     * 如果有intent传来，可以覆盖方法
     * @param intent
     */
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        //避免重复添加Fragment
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.rl_fragment_container;
    }
}
