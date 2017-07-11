package com.ai.kara.demo.strategy;

/**
 * Created by zhouliang on 2017/7/11.
 */

public class LoginRsa implements IEncryptStrategy {
    @Override
    public String encryptStr(String params) {
        return "我是Rsa加密处理的数据";
    }
}
