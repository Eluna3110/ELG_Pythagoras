package com.example.pitagoras.mvvm.viewmodel

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pitagoras.mvvm.adapter.FigureAdapter
import com.example.pitagoras.mvvm.adapter.IListenerFigure
import com.example.pitagoras.mvvm.model.Figure

class GeometricFiguresViewModel : ViewModel()
{
    private val _figureAdapter = MutableLiveData<FigureAdapter>()
    private val _figureList = MutableLiveData<MutableList<Figure>>()
    private val _figure = MutableLiveData<Figure>()

    private val _sideSquare = MutableLiveData<String>()

    private val _baseTriangle = MutableLiveData<String>()
    private val _heightTriangle = MutableLiveData<String>()

    private val _baseRectangle = MutableLiveData<String>()
    private val _heightRectangle = MutableLiveData<String>()

    private val _radioCircle = MutableLiveData<String>()

    private val _sideHexagon = MutableLiveData<String>()
    private val _aptHexagon = MutableLiveData<String>()

    private val _diagonalHigher = MutableLiveData<String>()
    private val _diagonalLess = MutableLiveData<String>()

    private val _baseParallelogram = MutableLiveData<String>()
    private val _heightParallelogram = MutableLiveData<String>()

    private val _baseHigher = MutableLiveData<String>()
    private val _baseLess = MutableLiveData<String>()
    private val _heightTrapeze = MutableLiveData<String>()

    private val _result = MutableLiveData<String>()

    val figureAdapter: LiveData<FigureAdapter>
        get() = _figureAdapter

    val figureList: LiveData<MutableList<Figure>>
        get() = _figureList

    val figure: LiveData<Figure>
        get() = _figure

    val sideSquare: LiveData<String>
        get() = _sideSquare

    val baseTriangle: LiveData<String>
        get() = _baseTriangle

    val heightTriangle: LiveData<String>
        get() = _heightTriangle

    val baseRectangle: LiveData<String>
        get() = _baseRectangle

    val baseParallelogram: LiveData<String>
        get() = _baseParallelogram

    val radioCircle: LiveData<String>
        get() = _radioCircle

    val sideHexagon: LiveData<String>
        get() = _sideHexagon

    val aptHexagon: LiveData<String>
        get() = _aptHexagon

    val diagonalHigher: LiveData<String>
        get() = _diagonalHigher

    val diagonalLess: LiveData<String>
        get() = _diagonalLess

    val heightRectangle: LiveData<String>
        get() = _heightRectangle

    val heightParallelogram: LiveData<String>
        get() = _heightParallelogram

    val baseHigher: LiveData<String>
        get() = _baseHigher

    val baseLess: LiveData<String>
        get() = _baseLess

    val heightTrapeze: LiveData<String>
        get() = _heightTrapeze

    val result : LiveData<String>
        get() = _result

    init {
        _figureList.value = mutableListOf()
        _result.value = ""
    }

    fun initAdapter(listener : IListenerFigure){
        _figureAdapter.value = FigureAdapter(mutableListOf(), listener)
    }

    fun setDataList(listValue : ArrayList<Figure>){
        _figureList.value = listValue
        _figureAdapter.value!!.updateDataSet(_figureList.value!!)
    }

    fun setFigure(figure : Figure){
        _figure.value = figure
    }

    fun setResult(value : String){
        _result.value = value
    }

    fun cleanResult(){
        _result.value = ""
    }

    fun afterTextSideSquare(editText: EditText) {
        _sideSquare.value = editText.text.toString()
    }

    fun afterTextBaseTriangle(editText: EditText) {
        _baseTriangle.value = editText.text.toString()
    }

    fun afterTextHeightTriangle(editText: EditText) {
        _heightTriangle.value = editText.text.toString()
    }

    fun afterTextBaseRectangle(editText: EditText) {
        _baseRectangle.value = editText.text.toString()
    }

    fun afterTextHeightRectangle(editText: EditText) {
        _heightTriangle.value = editText.text.toString()
    }

    fun afterTextRadioCircle(editText: EditText) {
        _radioCircle.value = editText.text.toString()
    }

    fun afterTextSideHexagon(editText: EditText) {
        _sideHexagon.value = editText.text.toString()
    }

    fun afterTextAptHexagon(editText: EditText) {
        _aptHexagon.value = editText.text.toString()
    }

    fun afterTextDiagonalHigher(editText: EditText) {
        _diagonalHigher.value = editText.text.toString()
    }

    fun afterTextDiagonalLess(editText: EditText) {
        _diagonalLess.value = editText.text.toString()
    }

    fun afterTextBaseParallelogram(editText: EditText) {
        _baseParallelogram.value = editText.text.toString()
    }

    fun afterTextHeightParallelogram(editText: EditText) {
        _heightParallelogram.value = editText.text.toString()
    }

    fun afterTextBaseHigher(editText: EditText) {
        _baseHigher.value = editText.text.toString()
    }

    fun afterTextBaseLess(editText: EditText) {
        _baseLess.value = editText.text.toString()
    }

    fun afterTextHeightTrapeze(editText: EditText) {
        _heightTrapeze.value = editText.text.toString()
    }
}