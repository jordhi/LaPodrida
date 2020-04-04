package cat.jhz;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


//@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {cat.jhz.Main.MainApp.class})
@AutoConfigureWebTestClient
@TestPropertySource(locations = "classpath:test.properties")
//@ActiveProfiles("dev")
public @interface ApiTestConfig {
}
