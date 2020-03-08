package com.movilehackafro.app.ui.area.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.domain.models.SubArea
import kotlinx.android.synthetic.main.item_list.view.*

class SubAreaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(subArea: SubArea) {
        itemView.textView4.text = subArea.name
    }

}