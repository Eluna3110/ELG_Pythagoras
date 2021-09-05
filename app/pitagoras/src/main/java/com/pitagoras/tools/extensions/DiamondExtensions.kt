package com.pitagoras.tools.extensions

import com.pitagoras.tools.Tools

fun Tools.Diamond.Companion.getArea(diagonalHigher : String, diagonalLess : String) : String {
    return ((diagonalHigher.toDouble() * diagonalLess.toDouble()) / 2).toString()
}