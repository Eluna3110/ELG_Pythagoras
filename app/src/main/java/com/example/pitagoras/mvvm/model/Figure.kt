package com.example.pitagoras.mvvm.model

import com.example.pitagoras.mvvm.utilities.GeometricFiguresEnum

class Figure(nameValue : String, imgValue : Int, enumValue : GeometricFiguresEnum)
{
    var name : String? = nameValue
    var img : Int? = imgValue
    var enum : GeometricFiguresEnum? = enumValue
}