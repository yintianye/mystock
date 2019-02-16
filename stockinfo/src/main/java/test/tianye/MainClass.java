package test.tianye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaRepositories("test.tianye.repository")
@EntityScan("test.tianye.model")
@SpringBootApplication
@EnableScheduling
public class MainClass {
  public static void main(String[] args) {
    SpringApplication.run(MainClass.class);
  }
}
