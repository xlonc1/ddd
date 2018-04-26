package pl.training.ddd.film


import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import pl.training.ddd.DddApplication
import pl.training.ddd.infrastructure.config.Profiles
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity

@ActiveProfiles([Profiles.TEST])
@ContextConfiguration
@SpringBootTest(
        classes = [DddApplication],
        webEnvironment = WebEnvironment.MOCK
)
@Transactional
@Rollback
abstract class IntegrationSpec extends Specification {
    @Autowired
    protected WebApplicationContext webApplicationContext

    MockMvc mockMvc

    @Before
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build()
    }
}
