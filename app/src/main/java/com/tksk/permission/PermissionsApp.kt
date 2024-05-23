package com.tksk.permission

import android.app.Application
import com.tksk.permission.permission_manager.PermissionsPreferences

class PermissionsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PermissionsPreferences.initPermissionSharedPreferences(this)
    }
}