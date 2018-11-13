package org.eurofurence.poldi.poldi;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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

    @Bean
    public CommandLineRunner jpaInit(CustomerRepository repository) {
        log.warn("Dragon: cli callback requested");
        return args -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
        };
    }

}
