package com.ai.kara.demo.strategy;

/**
 * Created by zhouliang on 2017/7/11.
 */

public class LoginDes implements IEncryptStrategy {
    @Override
    public String encryptStr(String params) {
        return "我是Des加密处理后的数据";
    }
}
