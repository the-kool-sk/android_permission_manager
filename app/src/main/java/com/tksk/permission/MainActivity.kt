package com.tksk.permission

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tksk.permission.databinding.ActivityMainBinding
import com.tksk.permission.permission_manager.PermissionManager
import com.tksk.permission.permission_manager.Permissions

class MainActivity : AppCompatActivity() {

    private val permissionManager = PermissionManager.from(this)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.askPermissionButton.setOnClickListener {
            permissionManager
                .request(Permissions.CamPerm)
                .rationale(
                title = "Permission Required",
                description = "This app needs permission to access your camera",
            ).permissionPermanentlyDeniedContent(
                description = "You have permanently denied the permission. Please enable it from settings",
            ).checkAndRequestPermission {
                if (it) {
                    // Show toast or do something
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                } else {
                    // Show toast or do something
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}