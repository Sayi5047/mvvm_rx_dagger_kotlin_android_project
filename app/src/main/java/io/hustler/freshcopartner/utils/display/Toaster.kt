package io.hustler.freshcopartner.utils.display

import android.content.Context
import android.graphics.PorterDuff
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.utils.TextUtils

//import ph.bilidito..driver.R
//import ph.bilidito..driver.utils.TextUtils

object Toaster {
    fun makeSmallToast(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.view.background.setColorFilter(ContextCompat.getColor(context, R.color.primary_dark), PorterDuff.Mode.SRC_IN)
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        TextUtils.setFont(context, textView, TextUtils.FONT_PROXIMAL_NOVA)

        toast.show()
    }

    fun makeSmallErrorToast(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.view.background.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        TextUtils.setFont(context, textView, TextUtils.FONT_PROXIMAL_NOVA)
        toast.show()
    }

    fun makeBigToast(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_LONG)
        toast.view.background.setColorFilter(ContextCompat.getColor(context, R.color.primary_dark), PorterDuff.Mode.SRC_IN)
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        TextUtils.setFont(context, textView, TextUtils.FONT_PROXIMAL_NOVA)

        toast.show()
    }

    fun makeBigErrorToast(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_LONG)
        toast.view.background.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        TextUtils.setFont(context, textView, TextUtils.FONT_PROXIMAL_NOVA)

        toast.show()
    }
}