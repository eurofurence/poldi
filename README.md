# Poldi
Staff Management software specifically for EF

# Dev Docu
Spring Boot App

Getting started doc: https://spring.io/guides/gs/spring-boot/
Reference: https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/

## Hibernate
- ID Generation, depending on database - https://www.thoughts-on-java.org/jpa-generate-primary-keys/
- Logging: https://www.thoughts-on-java.org/hibernate-logging-guide/
- AttributeConverter for enums: https://www.thoughts-on-java.org/jpa-21-type-converter-better-way-to/
- Changelog
-- https://struberg.wordpress.com/2010/07/31/howto-changelog-with-jpa/
-- https://www.baeldung.com/database-auditing-jpa
- https://www.thoughts-on-java.org/result-set-mapping-basics/

JPA Pitfalls: https://dev.to/alagrede/why-i-dont-want-use-jpa-anymore-fl

- verify https://stackoverflow.com/a/43094468/131146 - did this solve it?

## Frontend
- either server-side with http://www.thymeleaf.org
- or [Vue.js](https://vuejs.org) ([https://vuejs.org/v2/guide/](guide), [Rest with Axios](https://vuejs.org/v2/cookbook/using-axios-to-consume-apis.html))

## Tomcat
- using Tomcat8
- [Deploy on Tomcat](https://www.baeldung.com/tomcat-deploy-war) / [Stackoverflow](https://stackoverflow.com/a/17266749/131146)
- Short: add user with role manager-script in remote tomcat-users.xml and local ~/.m2/settings.xml 
- deploy using
  mvn tomcat7:redeploy -DskipTests
- remember to use 'redeploy', as 'deploy' fails with confusing error message
- Remote Debugging: use 'Debug: remote Java app', with remote hostname and port 8080



# TODO
- security manager is disabled, as it doesn't work without configuring it
  (it didn't seem to work on remote Tomcat either)
  - then secure spring actuators
- create test/prod environments, and only use Tomcat-datasource-bean in prod, but H2 in test
-- http://shengwangi.blogspot.com/2015/07/how-to-set-dev-test-prod-in-spring-javaconfig.html
-- https://www.baeldung.com/spring-testing-separate-data-source
- remote logging goes nowhere