package org.eurofurence.poldi.poldi;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PoldiApplication extends SpringBootServletInitializer {

    static private Log log = LogFactory.getLog(HelloController.class);

    public static void main(String[] args) {
        log.warn("Dragon: starting spring");
        SpringApplication.run(PoldiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PoldiApplication.class);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        log.warn("Dragon: cli callback requested");
        return args -> {
            log.warn("Dragon: cli callback called");

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
