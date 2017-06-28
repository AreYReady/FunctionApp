package com.hsc.functionapp.mvp.talk;

import android.os.Bundle;
import android.view.View;

import com.hsc.functionapp.R;
import com.hsc.functionapp.base.BaseFragment;

/**
 * Created by hsc on 2017/6/28 0028.
 * TODO:即时通讯app功能模块
 * LastChanger:
 * Date:
 * Chang：
 */

public class TalkFragment extends BaseFragment {
    public static TalkFragment newInstance() {
        Bundle args = new Bundle();
        TalkFragment fragment = new TalkFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_talk;
    }

    @Override
    protected void initRegister() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
