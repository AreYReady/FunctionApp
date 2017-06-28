package com.hsc.functionapp.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hsc.functionapp.R;
import com.hsc.functionapp.base.BaseFragment;
import com.hsc.functionapp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hsc on 2017/6/28 0028.
 * TODO:
 * LastChanger:
 * Date:
 * Chang：
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.b_talk)
    Button mBTalk;
    Unbinder unbinder;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.b_talk)
    public void onViewClicked() {
        ToastUtils.showShort("聊天模块");
        startActivity(new Intent(mContext,ContainerActivity.class));
    }
}
