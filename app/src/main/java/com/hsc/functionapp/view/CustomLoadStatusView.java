package com.hsc.functionapp.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hsc.functionapp.R;


/**
 * Created by hsc on 2017/6/23 0023.
 * TODO:自定义加载过度动画
 * LastChanger:
 * Date:
 * Chang：
 */

public class CustomLoadStatusView extends RelativeLayout {

    View inflate;
    Context mContext;
    CustomLoadStatusView mCustomLoadStatusView;
    OnclickReTryListener mOnclickReTryListener;
    Button mIdBtnRetry;


    public CustomLoadStatusView(Context context) {
        this(context, null);
    }

    public CustomLoadStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomLoadStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mCustomLoadStatusView = this;
        mContext = context;
    }

    public void showReTry() {
        if (isMainThread()) {
            setReTry();
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    setReTry();
                }
            });
        }
    }

    private void setReTry() {
        mCustomLoadStatusView.removeAllViews();
        inflate = LayoutInflater.from(mContext).inflate(R.layout.base_retry, mCustomLoadStatusView);
        mIdBtnRetry=(Button)inflate.findViewById(R.id.id_btn_retry);
        mIdBtnRetry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnclickReTryListener!=null){
                    mOnclickReTryListener.onclick(v);
                }
            }
        });
    }

    public void showLoading() {
        if (isMainThread()) {
            setLoading();
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    setLoading();
                }
            });
        }
    }
    private void setLoading(){
        mCustomLoadStatusView.removeAllViews();
        inflate=LayoutInflater.from(mContext).inflate(R.layout.base_loading,mCustomLoadStatusView);
    }
    public void showEmpty() {
        if (isMainThread()) {
            setEmpty();
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    setEmpty();
                }
            });
        }
    }

    private void setEmpty() {
        mCustomLoadStatusView.removeAllViews();
        inflate = LayoutInflater.from(mContext).inflate(R.layout.base_empty, mCustomLoadStatusView);
    }

    public void showContent() {
        if (isMainThread()) {
            setContent();
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    setContent();
                }
            });
        }
    }

    private void setContent() {
        mCustomLoadStatusView.removeAllViews();
        mCustomLoadStatusView.setVisibility(GONE);
    }


    private boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }


    public interface  OnclickReTryListener{
       void onclick(View view);
    }
    public void setOnClickReTrylistener(OnclickReTryListener onClickReTrylistener){
        this.mOnclickReTryListener=onClickReTrylistener;
    }
}
