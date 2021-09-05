package com.example.pitagoras.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pitagoras.R
import com.example.pitagoras.databinding.GeometricItemBinding
import com.example.pitagoras.mvvm.model.Figure

class FigureAdapter(private var listFigure : List<Figure>, private val listener : IListenerFigure) : RecyclerView.Adapter<FigureAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<GeometricItemBinding>(inflater, R.layout.geometric_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listFigure.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFigure[position])
    }

    inner class ViewHolder(val binding: GeometricItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: Figure) {
            binding.figure = item
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

    fun updateDataSet(newsList : MutableList<Figure>) {
        this.listFigure = newsList
        notifyDataSetChanged()
    }
}