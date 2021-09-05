package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Trapeze.Companion.getArea(baseMayor : String, baseLess : String, height : String) : String {
    return (((baseMayor.toDouble() + baseLess.toDouble()) / 2) * height.toDouble()).toString()
}