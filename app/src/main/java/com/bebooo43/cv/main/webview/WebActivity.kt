package com.bebooo43.cv.main.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.bebooo43.cv.R
import com.bebooo43.cv.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "PDF Resume"

        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
                builtInZoomControls = true
            }
            loadUrl(getString(R.string.pdf_link))
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    override fun onBackPressed() =
        if (binding.webView.canGoBack())
            binding.webView.goBack()
        else{
            super.onBackPressed()

    }
}