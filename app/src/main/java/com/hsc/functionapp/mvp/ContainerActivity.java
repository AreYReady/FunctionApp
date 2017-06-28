package com.hsc.functionapp.mvp;

import com.hsc.functionapp.base.AppActivity;
import com.hsc.functionapp.base.BaseFragment;
import com.hsc.functionapp.mvp.talk.TalkFragment;

/**
 * Created by hsc on 2017/6/28 0028.
 * TODO:容器activity
 * LastChanger:
 * Date:
 * Chang：
 */

public class ContainerActivity extends AppActivity {
    @Override
    protected BaseFragment getFirstFragment() {
        return TalkFragment.newInstance();
    }
}
