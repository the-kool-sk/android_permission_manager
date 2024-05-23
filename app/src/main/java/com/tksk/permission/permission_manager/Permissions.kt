package com.tksk.permission.permission_manager

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_AUDIO
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.Manifest.permission.RECORD_AUDIO
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE


sealed class Permissions(vararg val permissions: String) {
    // Individual permissions
//    object Camera : TlmPemrissions(CAMERA)
    // Bundled permissions
    data object ImagePick : Permissions(*getImagePickPermissions())
    data object VidPick : Permissions(*getImagePickPermissions())
    data object ImgVidCamPerm : Permissions(*getImgVidCamPermission())
    data object ImgVidAudioPerm : Permissions(*getImgVidAudioPermission())
    data object ImgCamPerm : Permissions(*getImgCamPermission())
    data object CamPerm : Permissions(*getCamPermission())
    data object ImgVidPerm : Permissions(*getImgVidPermission())
    data object AudioPickPerm : Permissions(*getAudioPermission())
    data object GoLivePerm : Permissions(*getImgAudVidCamPermission())

    // Grouped permissions
//    object Location : TlmPemrissions(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
//    object Storage : TlmPemrissions(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)

    companion object {
        private fun getImagePickPermissions(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE
                )
            }
        }
        private fun getImgVidCamPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES, READ_MEDIA_VIDEO, CAMERA)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE, CAMERA)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE,
                    CAMERA
                )
            }
        }
     private fun getImgVidAudioPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES, READ_MEDIA_VIDEO, READ_MEDIA_AUDIO)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE
                )
            }
        }

        private fun getImgCamPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES, CAMERA)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE, CAMERA)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE,
                    CAMERA
                )
            }
        }
        private fun getCamPermission(): Array<String> {
            return arrayOf(CAMERA)
        }
        private fun getImgAudVidCamPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES, RECORD_AUDIO, READ_MEDIA_VIDEO, CAMERA)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE, CAMERA, RECORD_AUDIO)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE,
                    CAMERA,
                    RECORD_AUDIO
                )
            }
        }
         private fun getAudioPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_AUDIO)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE
                )
            }
        }
      private fun getImgVidPermission(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_IMAGES, READ_MEDIA_VIDEO)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE
                )
            }
        }

      private fun getVidPick(): Array<String> {
            return if (PermissionManager.sdkEqOrAbove33()) {
                arrayOf(READ_MEDIA_VIDEO)
            } else if (PermissionManager.sdkEqOrAbove29()) {
                arrayOf(READ_EXTERNAL_STORAGE)
            } else {
                arrayOf(
                    READ_EXTERNAL_STORAGE,
                    WRITE_EXTERNAL_STORAGE
                )
            }
        }
    }
}
