package com.example.image_picker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.opensooq.supernova.gligar.GligarPicker

class MainActivity : AppCompatActivity() {

    val PICKER_REQUEST_CODE = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GligarPicker().limit(10).disableCamera(false).cameraDirect(false).requestCode(PICKER_REQUEST_CODE)
            .withActivity(this).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }

        when (requestCode) {
            PICKER_REQUEST_CODE -> {
                val imagesList = data?.extras?.getStringArray(GligarPicker.IMAGES_RESULT)
                if (!imagesList.isNullOrEmpty()) {
                   val imagesCount = "Number of selected Images: ${imagesList.size}"
                    Log.e("img", imagesCount)
                }
            }
        }
    }

}