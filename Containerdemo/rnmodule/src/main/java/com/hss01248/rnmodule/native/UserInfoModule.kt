package com.hss01248.rnmodule.native

import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule

/**
 * by hss
 * data:2020/6/9c
 * desc:
 */
class UserInfoModule( c : ReactApplicationContext) : ReactContextBaseJavaModule() {
    override fun getName(): String {
        return "userinfo"
    }


}