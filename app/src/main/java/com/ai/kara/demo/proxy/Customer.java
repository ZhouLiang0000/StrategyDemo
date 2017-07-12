package com.ai.kara.demo.proxy;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhouliang on 2017/7/12.
 */

public class Customer implements IBuyCar {
    private int cash;
    private Context mContext;

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void buyCar() {
        if (cash < 100000) {
            Toast.makeText(mContext, "您的钱不够啊", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(mContext, "我是买车客户Customer,买车话费了我:" + cash, Toast.LENGTH_SHORT).show();
        }
    }
}
