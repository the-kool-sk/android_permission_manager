package com.tksk.permission.permission_manager

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity

fun Context.scanForActivity(): AppCompatActivity? {
    return when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> baseContext.scanForActivity()
        else -> {
            null
        }
    }
}

fun Array<String>.itemContains(match: String) = this.any { it.contains(match) }