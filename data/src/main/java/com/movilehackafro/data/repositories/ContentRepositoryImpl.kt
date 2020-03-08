package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.SchoolService
import com.movilehackafro.domain.models.Content
import com.movilehackafro.domain.repositories.ContentRepository

class ContentRepositoryImpl(
    private val schoolService: SchoolService
): ContentRepository {

    override suspend fun list(schoolId: Long, disciplineId: Long): List<Content> {
        //return schoolService.getContents(schoolId, disciplineId).map { it.toDomain() }
        return if (disciplineId == 1L) {
            listOf(
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #1: Matemática Básica", ""),
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #2: Matemática Básica", ""),
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #3: Matemática Básica", ""),
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #4: Matemática Básica", ""),
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #5: Matemática Básica", ""),
                Content(1, 1, "https://www.professorferretto.com.br/", "Ferretto Prepara #6: Matemática Básica", "")
            )
        } else {
            listOf(
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 1", ""),
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 2", ""),
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 3", ""),
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 4", ""),
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 5", ""),
                Content(1, 2, "https://wiseup.com/", "Wise up - How to 6", "")
            )
        }
    }

}