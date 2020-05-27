package io.hustler.freshcopartner.utils

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.os.Handler
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

object TextUtils {
    const val FONT_PROXIMAL_NOVA = "fonts/ProximaNova.otf"
    fun setFont(activity: Context?, tv: TextView, fontname: String?) {
        assert(activity != null)
        tv.typeface = Typeface.createFromAsset(activity!!.applicationContext.assets, fontname)
    }

    private fun editFont(activity: Context, et: EditText) {
        et.typeface = Typeface.createFromAsset(activity.applicationContext.assets, FONT_PROXIMAL_NOVA)
    }

    private fun setRadioFont(activity: Context, et: RadioButton) {
        et.typeface = Typeface.createFromAsset(activity.applicationContext.assets, FONT_PROXIMAL_NOVA)
    }

    fun arrayitemOfString(activity: Context, name: String?, index: Int): String? {
        val arrayid: Int = activity.resources.getIdentifier(name, "array", activity.applicationContext.packageName)
        val typedArray: TypedArray
        typedArray = activity.resources.obtainTypedArray(arrayid)
        val stringFromArray = typedArray.getString(index)
        typedArray.recycle()
        return stringFromArray
    }

    fun applyTextShadow(tv: TextView, raduis: Float, x: Float, y: Float, color: Int) {
        tv.setShadowLayer(raduis, x, y, color)
    }

    fun findTextAndApplyFont(viewGroup: ViewGroup, activity: Context) {
        Handler().post {
            val childCount = viewGroup.childCount
            for (i in 0 until childCount) {
                val view = viewGroup.getChildAt(i)
                if (view is ViewGroup) {
                    findTextAndApplyFont(view, activity)
                } else if (view is TextView) {
                    setFont(activity, view, FONT_PROXIMAL_NOVA)
                } else if (view is EditText) {
                    editFont(activity, view)
                } else if (view is Button) {
                    setFont(activity, view as TextView, FONT_PROXIMAL_NOVA)
                } else if (view is RadioButton) {
                    setRadioFont(activity, view)
                }
            }
        }
    }

    fun getMatColor(activity: Activity, md_300: String?): Int {
        var returnColor = Color.BLACK
        val arrayId = activity.resources.getIdentifier(md_300, "array", activity.applicationContext.packageName)
        if (arrayId != 0) {
            val colors = activity.resources.obtainTypedArray(arrayId)
            val index = (Math.random() * colors.length()).toInt()
            returnColor = colors.getColor(index, Color.BLACK)
            colors.recycle()
        }
        return returnColor
    }

    fun getMainMatColor(arrayname: String?, activity: Activity): Int {
        var returnColor = Color.BLACK
        val arrayId = activity.resources.getIdentifier(arrayname, "array", activity.applicationContext.packageName)
        if (arrayId != 0) {
            val colors = activity.resources.obtainTypedArray(arrayId)
            val index = (Math.random() * colors.length()).toInt()
            returnColor = colors.getColor(index, Color.BLACK)
            colors.recycle()
        }
        return returnColor
    }
}