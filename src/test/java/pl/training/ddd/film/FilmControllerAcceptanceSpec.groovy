package pl.training.ddd.film

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import pl.training.ddd.film.domain.FilmFacade
import pl.training.ddd.film.domain.SampleFilms

class FilmControllerAcceptanceSpec extends IntegrationSpec implements SampleFilms {

    @Autowired
    FilmFacade filmFacade

    @WithMockUser
    def "should get films"() {
        given: 'inventory has "American Clingon Bondage"'
            filmFacade.add(trumper)
            filmFacade.add(clingon)

        when: 'I go to /films'
            ResultActions getFilms = mockMvc.perform(MockMvcRequestBuilders.get("/films"))

        then: 'I see all films'
            getFilms.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                {
                    "content": [
                        {"title":"$clingon.title","type":"$clingon.type"},
                        {"title":"$trumper.title","type":"$trumper.type"}
                    ]
                }"""))

        when: 'I go to /film/'
            ResultActions getFilm = mockMvc.perform(MockMvcRequestBuilders.get("/film/$clingon.title"))

        then: 'I see details of that film'
            getFilm.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {"title":"$clingon.title","type":"$clingon.type"},
                """))
    }
}
