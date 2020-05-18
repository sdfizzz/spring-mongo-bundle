package org.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.apache.logging.log4j.*;

@SpringBootApplication
@ComponentScan("org.home")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
