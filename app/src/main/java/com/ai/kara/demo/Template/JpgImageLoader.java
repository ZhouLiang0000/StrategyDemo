package com.ai.kara.demo.Template;

/**
 * Created by zhouliang on 2017/7/25.
 */

public class JpgImageLoader extends AbstractImageLoader{
    @Override
    protected String getUrl(String imageUrl, int width, int height) {
        return String.format("%s?imageView2/1/w/%d/h/%d/format/jpg", imageUrl, width, height);
    }
}
