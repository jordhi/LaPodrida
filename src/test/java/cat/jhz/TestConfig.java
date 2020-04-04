package cat.jhz;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {cat.jhz.Main.MainApp.class})
@TestPropertySource("classpath:test.properties")
@ActiveProfiles("dev")
@ComponentScan(basePackages = {"cat.jhz"})
public @interface TestConfig {
}
