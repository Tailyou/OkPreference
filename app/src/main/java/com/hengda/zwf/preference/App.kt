package com.hengda.zwf.preference

import android.app.Application
import com.marcinmoskala.kotlinpreferences.PreferenceHolder

/**
 * 作者：祝文飞（Tailyou）
 * 邮箱：tailyou@163.com
 * 时间：2017/7/18 16:33
 * 描述：
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHolder.setContext(applicationContext)
    }

}