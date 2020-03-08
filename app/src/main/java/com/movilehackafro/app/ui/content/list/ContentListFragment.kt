package com.movilehackafro.app.ui.content.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.movilehackafro.app.R
import com.movilehackafro.app.ui.content.get.ContentGetActivity
import com.movilehackafro.domain.models.Content
import com.movilehackafro.domain.models.Discipline
import kotlinx.android.synthetic.main.fragment_content_list.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.startActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContentListFragment : Fragment(), ContentListInteractionListener {

    private var disciplineId: Long = 0
    private lateinit var disciplineName: String
    private lateinit var subAreaName: String
    private lateinit var subAreaDescription: String

    private val contentListViewModel by viewModel<ContentListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disciplineId = arguments?.getLong(ARG_DISCIPLINE_ID)!!
        disciplineName = arguments?.getString(ARG_DISCIPLINE_NAME)!!
        subAreaName = arguments?.getString(ARG_SUB_AREA_NAME)!!
        subAreaDescription =  arguments?.getString(ARG_SUB_AREA_DESCRIPTION)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentListViewModel.list(1, disciplineId)

        observeContents()
        observeIsListing()
        observeError()

        configureViews()
    }

    private fun configureViews() {
        textView_content_list_name.text = subAreaName
        textView_content_list_question.text = getString(R.string.como_a_materia_vai_ajudar_na_area, disciplineName, subAreaName)

        materialButton_content_list_go_to_content.setOnClickListener {
            requireContext().startActivity<ContentGetActivity>(
                ContentGetActivity.ARG_SUB_AREA_NAME to subAreaName,
                ContentGetActivity.ARG_SUB_AREA_DESCRIPTION to subAreaDescription
            )
        }
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

    companion object {
        const val ARG_DISCIPLINE_ID = "argDisciplineId"
        const val ARG_DISCIPLINE_NAME = "argDisciplineName"
        const val ARG_SUB_AREA_NAME = "argSubAreaName"
        const val ARG_SUB_AREA_DESCRIPTION = "argSubAreaDescription"
    }
}