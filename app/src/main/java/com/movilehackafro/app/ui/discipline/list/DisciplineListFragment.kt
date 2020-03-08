package com.movilehackafro.app.ui.discipline.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.movilehackafro.app.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisciplineListFragment : Fragment() {

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

    private fun observeDisciplines() {
        disciplineListViewModel.disciplines.observe(viewLifecycleOwner, Observer {

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