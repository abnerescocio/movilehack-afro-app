package com.movilehackafro.app.ui.discipline.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.Discipline

class DisciplineListAdapter(
    private val disciplines: List<Discipline>,
    private val listener: DisciplineListInteractionListener
): RecyclerView.Adapter<DisciplineListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DisciplineListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = disciplines.size

    override fun onBindViewHolder(holder: DisciplineListViewHolder, position: Int) {
        val discipline = disciplines[position]
        holder.bind(discipline)
        holder.itemView.setOnClickListener { listener.onSelectDiscipline(discipline) }
    }
}