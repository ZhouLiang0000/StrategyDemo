package com.ai.kara.demo.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ai.kara.demo.R;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouliang on 2017/7/12.
 */

public class ProxyActivity extends AppCompatActivity {
    @Bind(R.id.proxy_bt)
    Button proxyBt;
    @Bind(R.id.proxy_dong_bt)
    Button proxyDongBt;
    @Bind(R.id.cash_tv)
    EditText cashTv;

    public static void startProxyActivity(Context context) {
        Intent intent = new Intent(context, ProxyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.proxy_bt, R.id.proxy_dong_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.proxy_bt:
                staticProxy();
                break;
            case R.id.proxy_dong_bt:
                dynamicProxy();
                break;
        }
    }

    /**
     * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
     * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
     * 第二个参数customer.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
     * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
     */
    private void dynamicProxy() {
        Customer customer = getCustomer();
        InvocationHandler handler = new DynamicProxy(customer);
        IBuyCar mIBuyCar = (IBuyCar) Proxy.newProxyInstance(handler.getClass().getClassLoader(), customer.getClass().getInterfaces(), handler);
        mIBuyCar.buyCar();
    }

    private void staticProxy() {
        Customer customer = getCustomer();
        BuyCarProxy proxy = new BuyCarProxy(ProxyActivity.this, customer);
        proxy.buyCar();
    }

    @NonNull
    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCash(Integer.parseInt(cashTv.getText().toString()));
        customer.setmContext(ProxyActivity.this);
        return customer;
    }

}
