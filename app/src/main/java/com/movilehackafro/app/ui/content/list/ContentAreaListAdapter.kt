package com.movilehackafro.app.ui.content.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.Content

class ContentAreaListAdapter(
    private val contents: List<Content>,
    private val listener: ContentListInteractionListener
): RecyclerView.Adapter<ContentListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContentListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_content_list, parent, false)
    )

    override fun getItemCount() = contents.size

    override fun onBindViewHolder(holder: ContentListViewHolder, position: Int) {
        val content = contents[position]
        holder.bind(content)
        holder.itemView.setOnClickListener { listener.onContent(content) }
    }

}