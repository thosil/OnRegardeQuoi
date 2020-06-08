package com.thosil.onRegardeQuoi

import javax.persistence.*

@Entity
@Table(name = "filmfiles")
data class FilmFile(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @Column(unique = true)
        val imdbID: String? = null,
        @Column(nullable = false, unique = true)
        val filename: String,
        val present: Boolean = false,
        val seen: Boolean = false
)