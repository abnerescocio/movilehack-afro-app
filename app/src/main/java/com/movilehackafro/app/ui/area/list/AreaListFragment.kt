package com.movilehackafro.app.ui.area.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.SubArea
import kotlinx.android.synthetic.main.fragment_area_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AreaListFragment : Fragment(), SubAreaListInteractionListener {

    private val areaListViewModel by viewModel<AreaListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_area_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        areaListViewModel.listByDisciplineIds(emptyList())

        observeAreas()
        observeIsListing()
        observeError()
    }

    override fun onSelectSubArea(subArea: SubArea) {
        findNavController().navigate(R.id.contentListFragment)
    }

    private fun observeAreas() {
        areaListViewModel.areas.observe(viewLifecycleOwner, Observer { areas ->
            recyclerView_area_list.adapter = SubAreaListAdapter(areas.flatMap { it.subAreas }, this)
        })
    }

    private fun observeIsListing() {
        areaListViewModel.isListing.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeError() {
        areaListViewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }
}