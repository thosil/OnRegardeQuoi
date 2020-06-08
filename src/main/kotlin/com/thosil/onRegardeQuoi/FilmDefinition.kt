package com.thosil.onRegardeQuoi

import java.net.URL
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class FilmDefinition(
        @Id
        val imdbID: String, // tt201607
        @Column(nullable = false)
        val Title: String, // ex: Harry Potter et les reliques de la mort Partie 2
        @Column(nullable = false)
        val Year: Int, // ex: 2011
        @Column(nullable = false)
        val Rated: String, // ex: PG-13
        @Column(nullable = false)
        val Runtime: Int, // ex: 130
        val Genre: String = "", // ex: Aventure, Drame, Fantaisie, Mystères
        val Plot: String = "", // ex: Harry Ron et Hermione continuent leur quête...
        @Column(nullable = false)
        val Language: String, // ex: Français
        val Poster: URL? = null // ex: "https://.....
)