package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Circle.Companion.getArea(radio : String) : String {
    return  (3.1416 * Math.pow(radio.toDouble(), 2.0)).toString()
}