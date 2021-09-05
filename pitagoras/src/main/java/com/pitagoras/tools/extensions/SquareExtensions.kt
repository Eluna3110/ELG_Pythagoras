package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Square.Companion.getArea(sideSquare : String) : String {
    return (sideSquare.toDouble() + sideSquare.toDouble() + sideSquare.toDouble() + sideSquare.toDouble()).toString()
}