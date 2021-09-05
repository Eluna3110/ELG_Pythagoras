package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Hexagon.Companion.getArea(side : String, apt : String) : String {
    val p = (side.toDouble() + side.toDouble() + side.toDouble() + side.toDouble() + side.toDouble() + side.toDouble())
    return ((p * apt.toDouble()) / 2).toString()
}