package com.ai.kara.demo.strategy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ai.kara.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouliang on 2017/7/11.
 */

public class StrategyActivity extends AppCompatActivity {

    @Bind(R.id.celueBt1)
    Button celueBt1;
    @Bind(R.id.celueBt2)
    Button celueBt2;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mContext = StrategyActivity.this;
    }

    public static void startStrategyActivity(Context context) {
        Intent intent = new Intent(context, StrategyActivity.class);
        context.startActivity(intent);
    }

    @OnClick({R.id.celueBt1, R.id.celueBt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.celueBt1:
                LoginRsa rsa = new LoginRsa();
                Toast.makeText(mContext, rsa.encryptStr("请求的数据"), Toast.LENGTH_SHORT).show();
                break;
            case R.id.celueBt2:
                LoginDes des = new LoginDes();
                Toast.makeText(mContext, des.encryptStr("请求的数据"), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
