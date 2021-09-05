package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Traingle.Companion.getArea(base : String, height : String) : String {
    return ((base.toDouble() *  height.toDouble()) / 2).toString()
}