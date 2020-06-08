package com.thosil.onRegardeQuoi

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.Description
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(
        path = "films",
        collectionResourceRel = "films",
        collectionResourceDescription = Description("Liste des films détectés"),
        itemResourceDescription = Description("Un film avec le plus d'informations possibles")
)
interface FilmRepository : PagingAndSortingRepository<FilmFile, Long> {
    fun findByImdbID(imdbID: String): List<FilmFile>
    fun findByFilenameIgnoreCaseContaining(filename: String): List<FilmFile>
    fun findByPresent(present: Boolean): List<FilmFile>
    fun findBySeen(seen: Boolean): List<FilmFile>
    fun existsByFilename(filename: String): Boolean
}