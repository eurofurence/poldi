package org.eurofurence.poldi.poldi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

// @Autowired
// MBeanExporter mBeanExporter;

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
        log.warn("Dragon: cli callback requested (1)");
        return args -> {
            log.warn("Dragon: cli callback called");

// System.out.println("Let's inspect the beans provided by Spring Boot:");
//
// String[] beanNames = ctx.getBeanDefinitionNames();
// Arrays.sort(beanNames);
// for (String beanName : beanNames) {
// System.out.println(beanName);
// }
        };
    }

    @Bean
    public CommandLineRunner jpaInit(CustomerRepository repository) {
        log.warn("Dragon: cli callback requested (2)");
        return args -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
        };
    }


    @Autowired
    DataSource datasource;

    // from https://stackoverflow.com/a/20749594/131146
// @Bean
// DataSource dataSource() {
// // apparently needed, otherwise the application won't start up
// // see https://stackoverflow.com/questions/28295503/migration-to-tomcat-8-instancealreadyexistsexception-datasource
//// TODO only available for @AutoWired when running on Tomcat, fails for local tests :(
// mBeanExporter.addExcludedBean("dataSource");
//
// JndiDataSourceLookup dslookup = new JndiDataSourceLookup();
// dslookup.setResourceRef(true);
// DataSource dataSource = dslookup.getDataSource("jdbc/poldiDB");
// return dataSource;
// }

}
