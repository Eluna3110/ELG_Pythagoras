package com.example.pitagoras.mvvm.adapter

import com.example.pitagoras.mvvm.model.Figure
import com.example.pitagoras.mvvm.utilities.GeometricFiguresEnum

interface IListenerFigure
{
    fun onClickFigure(figure : Figure)
}