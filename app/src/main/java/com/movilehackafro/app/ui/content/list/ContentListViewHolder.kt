package com.movilehackafro.app.ui.content.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.Content
import kotlinx.android.synthetic.main.item_content_list.view.*

class ContentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(content: Content) {
        if (content.disciplineId == 1L) {
            itemView.imageView_content.setImageResource(R.drawable.maxresdefault)
        } else {
            itemView.imageView_content.setImageResource(R.drawable.maxresdefault_2)
        }
        itemView.textView_content.text = content.title
    }

}