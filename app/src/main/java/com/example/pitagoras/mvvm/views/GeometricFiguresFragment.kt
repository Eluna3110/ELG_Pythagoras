package com.example.pitagoras.mvvm.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.pitagoras.MainActivity
import com.example.pitagoras.R
import com.example.pitagoras.databinding.GeometricFiguresFragmentBinding
import com.example.pitagoras.mvvm.adapter.IListenerFigure
import com.example.pitagoras.mvvm.model.Figure
import com.example.pitagoras.mvvm.utilities.GeometricFiguresEnum
import com.example.pitagoras.mvvm.viewmodel.GeometricFiguresViewModel

class GeometricFiguresFragment : Fragment(), IListenerFigure
{
    private lateinit var binding : GeometricFiguresFragmentBinding
    private lateinit var viewModel: GeometricFiguresViewModel

    companion object {
        fun newInstance() = GeometricFiguresFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = GeometricFiguresFragmentBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = this
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initModels()
        viewModel.initAdapter(this)
        binding.viewModel = viewModel
        setDataList()
    }

    private fun setDataList(){
        val listFigure = ArrayList<Figure>()

        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_SQUARE.figure, imgValue = R.drawable.ic_cuadrado, enumValue = GeometricFiguresEnum.FIGURE_SQUARE))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_TRIANGLE.figure, imgValue = R.drawable.ic_triangulo, enumValue = GeometricFiguresEnum.FIGURE_TRIANGLE))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_RECTANGLE.figure, imgValue = R.drawable.ic_rectangulo, enumValue = GeometricFiguresEnum.FIGURE_RECTANGLE))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_CIRCLE.figure, imgValue = R.drawable.ic_circulo, enumValue = GeometricFiguresEnum.FIGURE_CIRCLE))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_HEXAGON.figure, imgValue = R.drawable.ic_hexagono, enumValue = GeometricFiguresEnum.FIGURE_HEXAGON))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_DIAMOND.figure, imgValue = R.drawable.ic_rombo, enumValue = GeometricFiguresEnum.FIGURE_DIAMOND))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_PARALLELOGRAM.figure, imgValue = R.drawable.ic_paralelograma, enumValue = GeometricFiguresEnum.FIGURE_PARALLELOGRAM))
        listFigure.add(Figure(nameValue = GeometricFiguresEnum.FIGURE_TRAPEZE.figure, imgValue = R.drawable.ic_trapecio, enumValue = GeometricFiguresEnum.FIGURE_TRAPEZE))

        viewModel.setDataList(listFigure)
    }

    override fun onClickFigure(figure: Figure) {
        viewModel.setFigure(figure)
        viewModel.cleanResult()
        (activity as MainActivity).nextFragment(CalculateFragment.newInstance(), "")
    }

    private fun initModels() {
        viewModel = activity?.run { ViewModelProviders.of(this)[GeometricFiguresViewModel::class.java] } ?: throw Exception("Invalid Activity")
    }
}