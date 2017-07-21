## 一、概述

在开发过程中通常需要保存用户或App的一些配置信息，如token，DeviceNo，OkPreference是一个管理配置信息的工具库，
可以方便的管理需要配置的字段，字段支持Long，Int，Boolean，String，Float五种基本类型，也可以是任意类。

## 二、版本

已上传JitPack，最新版本1.2，直接在gradle中添加依赖即可。  
compile 'com.github.Tailyou:OkPreference:1.2'

## 三、使用

#### 3.1 app build.gradle中添加依赖
```groovy
dependencies {
    compile 'com.github.Tailyou:OkPreference:1.2'
}
```

#### 3.2 root build.gradle中添加
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

#### 3.3 继承PreferenceHolderApplication或在自定义的Application中添加如下代码：
```kotlin
    override fun onCreate() {
        super.onCreate()
        ...
        PreferenceHolder.setContext(applicationContext)
    }
```

#### 3.4 继承PreferenceHolder，添加需要配置的字段
```kotlin
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

data class User(
        var name: String,
        var age: Int
)
```

#### 3.5 取值、赋值
```kotlin
tvDeviceNo.text = AppConfig.deviceNo
btnChangeDeviceNo.setOnClickListener {
    AppConfig.deviceNo = "AG100000000" + String.format("%02d", Random().nextInt(100))
    tvDeviceNo.text = AppConfig.deviceNo
}
btnSaveEntity.setOnClickListener {
    UserConfig.user = User("tailyou", 20)
    toast((UserConfig.user as User).name)
}
```

