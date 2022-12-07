package com.bebooo43.cv.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun Context.openExternalApp(uriString: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
        startActivity(intent)
    } catch (ignored: Exception) {
        Toast.makeText(this, ignored.message, Toast.LENGTH_LONG).show()
    }
}

fun Context.sendEmail(addresses: List<String>, subject: String, body: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "message/rfc822"
        putExtra(Intent.EXTRA_EMAIL, addresses.toTypedArray())
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, body)
    }
    try {
        startActivity(Intent.createChooser(intent, "Send mail..."))
    } catch (ex: ActivityNotFoundException) {
        Toast.makeText(this, "There are no email apps installed.", Toast.LENGTH_SHORT).show()
    }
}
