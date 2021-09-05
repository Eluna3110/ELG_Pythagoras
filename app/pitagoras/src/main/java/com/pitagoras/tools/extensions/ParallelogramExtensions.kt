package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Parallelogram.Companion.getArea(base : String, height : String) : String {
    return (base.toDouble() * height.toDouble()).toString()
}