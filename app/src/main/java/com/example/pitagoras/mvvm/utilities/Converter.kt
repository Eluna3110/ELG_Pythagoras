package com.example.pitagoras.mvvm.utilities

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object Converter
{
    @JvmStatic
    fun getDrawable(context: Context, resourceId: Int): Drawable? {
        return ContextCompat.getDrawable(context, resourceId)
    }
}