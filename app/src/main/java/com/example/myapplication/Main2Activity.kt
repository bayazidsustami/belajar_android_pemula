package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Main2Activity : AppCompatActivity() {
    private lateinit var names: TextView
    private lateinit var details: TextView
    private lateinit var images: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        names = findViewById(R.id.tv_names)
        details = findViewById(R.id.tv_details)
        images = findViewById(R.id.img_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val linkBio = intent.getStringExtra(EXTRA_LINK)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        names.text = name
        details.text = detail
        Glide.with(this).load(photo).into(images)
        images.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkBio))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.android.com")
            try {
                applicationContext.startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                intent.setPackage(null)
                applicationContext.startActivity(intent)
            }
        })
    }

    companion object {
        const val EXTRA_NAME = "extra name"
        const val EXTRA_DETAIL = "extra detail"
        const val EXTRA_PHOTO = "extra photo"
        const val EXTRA_LINK = "link bio"
    }
}