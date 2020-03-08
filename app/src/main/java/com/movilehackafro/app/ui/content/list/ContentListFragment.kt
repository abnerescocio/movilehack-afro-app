package com.movilehackafro.app.ui.content.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.Content
import kotlinx.android.synthetic.main.fragment_content_list.*
import org.jetbrains.anko.browse
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContentListFragment : Fragment(), ContentListInteractionListener {

    private val contentListViewModel by viewModel<ContentListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentListViewModel.list(1, 1)

        observeContents()
        observeIsListing()
        observeError()
    }

    override fun onContent(content: Content) {
        requireContext().browse(content.url)
    }

    private fun observeContents() {
        contentListViewModel.contents.observe(viewLifecycleOwner, Observer { contents ->
            recyclerView_content_list.adapter = ContentAreaListAdapter(contents, this)
        })
    }

    private fun observeIsListing() {
        contentListViewModel.isListing.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeError() {
        contentListViewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }
}