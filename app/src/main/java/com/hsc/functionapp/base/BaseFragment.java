package com.hsc.functionapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by huangsc on 2017/6/21 0021.
 * TODO:
 * LastChang:
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected Context mContext;
    protected Unbinder unbinder;


    /**
     * 获取布局id
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
        this.mContext=context;
    }

    /**
     * add整个覆盖activity的fragment
     * @param fragment
     */
    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            mActivity.addFragment(fragment);
        }
    }
    /**
     * remove整个activity的fragment
     */
    protected void removeFragment() {
        mActivity.removeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRegister();
        initStatus(view,savedInstanceState);
        initData();
        initView(view, savedInstanceState);
    }

    /**
     *请求数据返回前的加载界面
     * @param view
     * @param savedInstanceState
     */
    protected void initStatus(View view, Bundle savedInstanceState) {
    }

    protected abstract void initRegister();

    protected abstract void initData();

    protected abstract void initView(View view, Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }


}
