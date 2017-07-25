package com.ai.kara.demo.Template;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.ai.kara.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouliang on 2017/7/25.
 */

public class TemplateActivity extends AppCompatActivity {
    @Bind(R.id.template_bt)
    Button templateBt;
    @Bind(R.id.template_iv)
    ImageView templateIv;

    public static void startTemplateActivity(Context context) {
        Intent mIntent = new Intent(context, TemplateActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.template_bt)
    public void onViewClicked() {
        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        AbstractImageLoader loader = new WebpImageLoader();
        loader.downLoadImage(TemplateActivity.this,templateIv,imageUrl, 200, 200);
    }
}
