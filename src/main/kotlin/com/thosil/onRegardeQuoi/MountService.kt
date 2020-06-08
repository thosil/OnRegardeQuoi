package com.thosil.onRegardeQuoi

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File

@Component
class MountService : CommandLineRunner {

    @Autowired
    private lateinit var repository: FilmRepository

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    private val filmDirectory = "/home/tsi/Videos"

    fun scanFilmFiles() {
        File(filmDirectory).list()?.forEach {
            if (!repository.existsByFilename(it)) {
                repository.save(FilmFile(filename = it, present = true, seen = false))
                logger.info("Adding file $it to repo: yes [not present]")
                return@forEach
            }
            logger.info("Add file $it to repo: no  [already present]")
        }
    }

    override fun run(vararg args: String?) {
        scanFilmFiles()
    }
}