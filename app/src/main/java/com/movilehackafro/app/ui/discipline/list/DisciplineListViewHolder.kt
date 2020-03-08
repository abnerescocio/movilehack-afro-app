package com.movilehackafro.app.ui.discipline.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.domain.models.Discipline
import kotlinx.android.synthetic.main.item_discipline_list.view.*

class DisciplineListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(discipline: Discipline) {
        itemView.textView4.text = discipline.name
    }

}