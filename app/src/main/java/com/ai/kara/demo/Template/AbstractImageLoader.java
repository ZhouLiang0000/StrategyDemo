package com.ai.kara.demo.Template;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by zhouliang on 2017/7/25.
 */

public abstract class AbstractImageLoader {

    public final void downLoadImage(Context context, ImageView imageView, String imageUrl, int width, int height) {
        String downLoadImageUrl = getUrl(imageUrl, width, height);
        Glide.with(context).load(downLoadImageUrl).into(imageView);
    }
    protected abstract String getUrl(String imageUrl, int width, int height);

}
