package com.hsc.functionapp;

import com.hsc.functionapp.base.AppActivity;
import com.hsc.functionapp.base.BaseFragment;
import com.hsc.functionapp.mvp.MainFragment;

public class MainActivity extends AppActivity {


    @Override
    protected BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }
}
