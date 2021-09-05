package com.example.pitagoras.mvvm.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import com.example.pitagoras.R
import com.example.pitagoras.databinding.GetAreaFragmentBinding
import com.example.pitagoras.mvvm.utilities.GeometricFiguresEnum
import com.example.pitagoras.mvvm.viewmodel.GeometricFiguresViewModel
import com.pitagoras.tools.Tools
import com.pitagoras.tools.extensions.getArea

class CalculateFragment : Fragment(), View.OnClickListener
{
    private lateinit var binding : GetAreaFragmentBinding
    private lateinit var viewModel: GeometricFiguresViewModel

    companion object {
        fun newInstance() = CalculateFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = GetAreaFragmentBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = this
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initModels()
        binding.onClickListener = this
        binding.viewModel = viewModel
        configCalculate()
    }

    private fun configCalculate()
    {
        when(viewModel.figure.value!!.enum){
            GeometricFiguresEnum.FIGURE_SQUARE ->{
                binding.clyCalculaCuadrado.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_RECTANGLE -> {
                binding.clyCalculaRectangulo.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_CIRCLE -> {
                binding.clyCalculaCircle.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_TRIANGLE -> {
                binding.clyCalculaTraingulo.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_HEXAGON -> {
                binding.clyCalculaHexagon.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_DIAMOND -> {
                binding.clyCalculaRombo.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_PARALLELOGRAM -> {
                binding.clyCalculaParalelograma.visibility = View.VISIBLE
            }
            GeometricFiguresEnum.FIGURE_TRAPEZE -> {
                binding.clyCalculaTrapecio.visibility = View.VISIBLE
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.btnCalculate.id ->{
                when(viewModel.figure.value!!.enum){
                    GeometricFiguresEnum.FIGURE_SQUARE ->{
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Square.getArea(viewModel.sideSquare.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_RECTANGLE -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Rectangle.getArea(viewModel.baseRectangle.value!!,viewModel.heightRectangle.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_CIRCLE -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Circle.getArea(viewModel.radioCircle.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_TRIANGLE -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Traingle.getArea(viewModel.baseTriangle.value!!,viewModel.heightTriangle.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_HEXAGON -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Hexagon.getArea(viewModel.sideHexagon.value!!, viewModel.aptHexagon.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_DIAMOND -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Diamond.getArea(viewModel.diagonalHigher.value!!,viewModel.diagonalLess.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_PARALLELOGRAM -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Parallelogram.getArea(viewModel.baseParallelogram.value!!,viewModel.heightParallelogram.value!!)))
                    }
                    GeometricFiguresEnum.FIGURE_TRAPEZE -> {
                        viewModel.setResult(resources.getString(R.string.resultado,Tools.Trapeze.getArea(viewModel.baseHigher.value!!, viewModel.baseLess.value!!, viewModel.heightTrapeze.value!!)))
                    }
                }
            }
        }
    }

    private fun initModels() {
        viewModel = activity?.run { ViewModelProviders.of(this)[GeometricFiguresViewModel::class.java] } ?: throw Exception("Invalid Activity")
    }
}