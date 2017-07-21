package com.hengda.zwf.okpreference

import kotlin.reflect.KProperty

internal fun getKey(keySet: String?, property: KProperty<*>) = keySet ?: "${property.name}Key"
