package com.movilehackafro.app.ui.area.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.movilehackafro.app.R
import com.movilehackafro.app.ui.content.list.ContentListFragment
import com.movilehackafro.domain.models.SubArea
import kotlinx.android.synthetic.main.fragment_area_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AreaListFragment : Fragment(), SubAreaListInteractionListener {

    private var disciplineId: Long = 0
    private lateinit var disciplineName: String
    private val areaListViewModel by viewModel<AreaListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disciplineId = arguments?.getLong(ARG_DISCIPLINE_ID)!!
        disciplineName = arguments?.getString(ARG_DISCIPLINE_NAME)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_area_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        areaListViewModel.listByDisciplineId(disciplineId)

        observeAreas()
        observeIsListing()
        observeError()

        configureViews()
    }

    override fun onSelectSubArea(subArea: SubArea) {
        val bundle = Bundle()
        bundle.putLong(ContentListFragment.ARG_DISCIPLINE_ID, disciplineId)
        bundle.putString(ContentListFragment.ARG_DISCIPLINE_NAME, disciplineName)
        bundle.putString(ContentListFragment.ARG_SUB_AREA_NAME, subArea.name)
        bundle.putString(ContentListFragment.ARG_SUB_AREA_DESCRIPTION, subArea.description)
        findNavController().navigate(R.id.contentListFragment, bundle)
    }

    private fun configureViews() {
        textView_area_list_name.text = disciplineName
    }

    private fun observeAreas() {
        areaListViewModel.areas.observe(viewLifecycleOwner, Observer { areas ->
            recyclerView_area_list.adapter = SubAreaListAdapter(areas.flatMap { it.subAreas }, this)
        })
    }

    private fun observeIsListing() {
        areaListViewModel.isListing.observe(viewLifecycleOwner, Observer {
            //TODO
        })
    }

    private fun observeError() {
        areaListViewModel.error.observe(viewLifecycleOwner, Observer {
            //TODO
        })
    }

    companion object {
        const val ARG_DISCIPLINE_ID = "argDisciplineId"
        const val ARG_DISCIPLINE_NAME = "argDisciplineName"
    }
}