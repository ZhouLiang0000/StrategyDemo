package com.ai.kara.demo.proxy;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhouliang on 2017/7/12.
 */

public class BuyCarProxy implements IBuyCar {
    private Customer mCustomer;
    private Context mContext;

    public BuyCarProxy(Context context, Customer mCustomer) {
        this.mContext = context;
        this.mCustomer = mCustomer;
    }

    @Override
    public void buyCar() {
        if (mCustomer.getCash() < 100000) {
            Toast.makeText(mContext, "您的钱不够啊", Toast.LENGTH_SHORT).show();
            return;
        }
        mCustomer.buyCar();
    }
}
