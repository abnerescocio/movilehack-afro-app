package com.movilehackafro.app.ui.discipline.set

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.movilehackafro.app.R
import com.movilehackafro.domain.models.Discipline
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisciplineSetFragment : Fragment() {

    private val disciplineSetViewModel by viewModel<DisciplineSetViewModel>()
    private val disciplines = mutableListOf<Discipline>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeIsSetting()
        observeError()
    }

    private fun observeIsSetting() {
        disciplineSetViewModel.isSetting.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun observeError() {
        disciplineSetViewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }

}
