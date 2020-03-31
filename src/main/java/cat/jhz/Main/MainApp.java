package cat.jhz.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cat.jhz"})
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }

}
