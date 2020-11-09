package com.example.recebe


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleReceive()

    }
    private fun handleReceive(){
        if (intent.action == Intent.ACTION_SEND && intent.type != null) {
            if ("text/plain" == intent.type) {
                val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
                if (sharedText != null)
                    tvReceivedText.text = sharedText
            }
            if ("image/*" == intent.type) {
                val stream = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM);
                if (stream != null)
                    ivReceivedImage.setImageURI(stream)
            }
        }
    }
}