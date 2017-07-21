package com.hengda.zwf.preference

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvDeviceNo.text = AppConfig.deviceNo
        btnChangeDeviceNo.setOnClickListener {
            AppConfig.deviceNo = "AG100000000" + String.format("%02d", Random().nextInt(100))
            tvDeviceNo.text = AppConfig.deviceNo
        }
        btnSaveEntity.setOnClickListener {
            UserConfig.user = User("tailyou", 20)
            toast((UserConfig.user as User).name)
        }
    }

}
