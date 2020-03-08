package com.movilehackafro.app.ui.content.list

import com.movilehackafro.domain.models.Content

interface ContentListInteractionListener {

    fun onContent(content: Content)

}