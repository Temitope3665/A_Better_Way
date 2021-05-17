package com.abetterway

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abetterway.databinding.HomeScreenItemBinding

class HomeScreenAdapter (var list: List<HomeScreenModel>, val listener:OnClickListener): RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    //private var list = mutableListOf<HomeScreenModel>()

//    fun setUpLists(list: List<HomeScreenModel>) {
//        this.list.addAll(list)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeScreenItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lists = list[position]
        holder.bindItem(lists)

//        holder.itemView.setOnClickListener {
//
//        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }


    inner class ViewHolder(private val binding: HomeScreenItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindItem(homeScreenModel: HomeScreenModel) {
            binding.listTitle.text = homeScreenModel.listTitle
            binding.imageIcon.setImageResource(homeScreenModel.image)
        }

        init {
            binding.layout.setOnClickListener {
                // get position of item
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

}