package com.movilehackafro.app.ui.discipline.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.movilehackafro.app.R
import com.movilehackafro.app.ui.area.list.AreaListFragment
import com.movilehackafro.domain.models.Discipline
import kotlinx.android.synthetic.main.fragment_discipline_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisciplineListFragment : Fragment(), DisciplineListInteractionListener {

    private val disciplineListViewModel by viewModel<DisciplineListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discipline_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disciplineListViewModel.list()

        observeDisciplines()
        observeIsListing()
        observeError()
    }

    override fun onSelectDiscipline(discipline: Discipline) {
        val bundle = Bundle()
        bundle.putLong(AreaListFragment.ARG_DISCIPLINE_ID, discipline.id)
        bundle.putString(AreaListFragment.ARG_DISCIPLINE_NAME, discipline.name)
        findNavController().navigate(R.id.action_nav_home_to_areaListFragment, bundle)
    }

    private fun observeDisciplines() {
        disciplineListViewModel.disciplines.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = DisciplineListAdapter(it, this)
        })
    }

    private fun observeIsListing() {
        disciplineListViewModel.isListing.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeError() {
        disciplineListViewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }
}