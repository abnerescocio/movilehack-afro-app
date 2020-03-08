package com.movilehackafro.app.ui.area.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.SubArea

class SubAreaListAdapter(
    private val subAreas: List<SubArea>,
    private val listener: SubAreaListInteractionListener
): RecyclerView.Adapter<SubAreaListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SubAreaListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = subAreas.size

    override fun onBindViewHolder(holder: SubAreaListViewHolder, position: Int) {
        val subArea = subAreas[position]
        holder.bind(subArea)
        holder.itemView.setOnClickListener { listener.onSelectSubArea(subArea) }
    }
}