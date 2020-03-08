package com.movilehackafro.app.ui.discipline.list

import com.movilehackafro.domain.models.Discipline

interface DisciplineListInteractionListener {

    fun onSelectDiscipline(discipline: Discipline)

}