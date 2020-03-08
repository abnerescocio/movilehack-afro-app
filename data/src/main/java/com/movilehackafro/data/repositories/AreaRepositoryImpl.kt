package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.CommonService
import com.movilehackafro.domain.models.Area
import com.movilehackafro.domain.models.SubArea
import com.movilehackafro.domain.repositories.AreaRepository

class AreaRepositoryImpl(
    private val commonService: CommonService
): AreaRepository {

    override suspend fun listByDisciplineId(disciplineId: Long): List<Area> {
        //return commonService.getAreas(disciplineIds).map { it.toDomain() }
        return if (disciplineId == 1L) {
            listOf(
                Area(1, "T.I.", listOf(
                    SubArea(11, 1, "Tecnologia da Informação", "Tecnologia da Informação é um conjunto de todas as atividades e soluções providas por recursos de computação que visam a produção, o armazenamento, a transmissão, o acesso, a segurança e o uso das informações."),
                    SubArea(11, 1, "Sistemas de Informação", "Sistemas de Informação é a expressão utilizada para descrever um Sistema seja ele automatizado, seja manual, que abrange pessoas, máquinas e/ou métodos organizados para coletar, armazenar, processar, transmitir e disseminar dados que representam informação para o usuário e/ou cliente."),
                    SubArea(11, 1, "Análise e Desenvolvimento de Sistemas", "Análise de sistemas é a atividade que tem como finalidade a realização de estudos de processos a fim de encontrar o melhor caminho racional para que a informação possa ser processada. Os analistas de sistemas estudam os diversos sistemas existentes entre hardwares, softwares e o usuário final.")
                ))
            )
        } else {
            listOf(
                Area(2, "Inglês", listOf(
                    SubArea(11, 1, "Relações Exteriores", "As Relações Internacionais visam ao estudo sistemático das relações políticas, econômicas e sociais entre diferentes países cujos reflexos transcendam as fronteiras de um Estado, as empresas, tenham como locus o Sistema Internacional."),
                    SubArea(11, 1, "Letras em Inglês", "Letras é uma designação genérica que abrange as áreas científicas da Linguística, dos Estudos literários, dos Estudos culturais, da História e da Filosofia. Estas áreas são normalmente investigadas e ensinadas nas faculdades de Letras e nos cursos superiores de Letras."),
                    SubArea(11, 1, "Turismo", "Hotelaria é uma faculdade das ciências humanas que abrange o âmbito das práticas e teorias acerca dos conhecimentos que tangem a administração de hotéis e eventos além de novos gêneros de hospedarias e turismo.")
                ))
            )
        }
    }

}