package pl.training.ddd.film.domain

import org.junit.After
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pl.training.ddd.film.dto.FilmDto
import spock.lang.Specification

/**
 * @author Arkadiusz Parzych
 * @since 05.01.18
 */
class FilmTest extends Specification implements SampleFilms {
    FilmFacade facade = new FilmConfiguration().filmFacade()

    @After
    def "remove films"() {
        facade.delete(trumper.title, clingon.title);
    }

    def "should add film"() {
        when: "we add a film"
          facade.add(trumper)

        then: "system has this film"
          facade.show(trumper.title) == trumper
    }

    def "shoud list films"() {
        given: "we have two films in system"
          facade.add(trumper)
          facade.add(clingon)

        when: "we ask for all films"
          Page<FilmDto> foundFilms = facade.findAll(new PageRequest(0, 10))

        then: "system returns the films we have added"
          foundFilms.contains(trumper)
          foundFilms.contains(clingon)
    }
}
