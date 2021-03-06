package com.movilehackafro.app.ui.event.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.movilehackafro.app.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private val eventListViewModel by viewModel<EventListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventListViewModel.list(123456)

        observeEvents()
        observeIsListing()
        observeError()
    }

    private fun observeEvents() {
        eventListViewModel.events.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeIsListing() {
        eventListViewModel.isListing.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeError() {
        eventListViewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }
}
