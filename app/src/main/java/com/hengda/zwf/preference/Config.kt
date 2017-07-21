package com.hengda.zwf.preference

import com.marcinmoskala.kotlinpreferences.PreferenceHolder


/**
 * 作者：祝文飞（Tailyou）
 * 邮箱：tailyou@163.com
 * 时间：2017/7/18 16:08
 * 描述：
 */

const val CHINESE: Int = 1
const val ENGLISH: Int = 2
const val JAPANESE: Int = 3
const val DEFAULT_DEVICE_NO: String = "AG10000000000"

object AppConfig : PreferenceHolder() {
    var deviceNo: String by bindToPreferenceField(DEFAULT_DEVICE_NO, "DeviceNo")
    var language: Int by bindToPreferenceField(CHINESE, "Language")
}

object UserConfig : PreferenceHolder() {
    var user: User? by bindToPreferenceFieldNullable("User")
    var token: String? by bindToPreferenceFieldNullable("Token")
}

data class User(var name: String, var age: Int)