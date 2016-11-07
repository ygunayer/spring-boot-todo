# spring-boot-todo
An extremely simplistic boilerplate for a REST API on Spring Boot, disguised as a server-side implementation of the [TodoMVC](http://todomvc.com/) project.

## Prerequisites
- [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle](https://github.com/gradle/gradle)
- [MySQL](https://www.mysql.com/) *(optional)*

## What's Inside
- [Spring Boot](https://github.com/spring-projects/spring-boot) - framework (duh)
- Starter projects or archetypes for REST-based web APIs and [Spring Data](http://projects.spring.io/spring-data-jpa/) (which eliminates the need to write DB queries in most cases)
- [HikariCP](https://github.com/brettwooldridge/HikariCP) - database connection pool ([why?](http://brettwooldridge.github.io/HikariCP/ludicrous.html))
- JDBC connectors for both H2 and MySQL. Useful to demonstrate different DB configurations for different runtime environments
  - [H2](https://github.com/h2database/h2database)
  - [MySQL Connector/J](https://github.com/mysql/mysql-connector-j)

## Configuration
The project comes bundled with two runtime modes, `dev` and `prod`, but you can always add your own environments. One great example for such a case might be the `test` environment, in which you might want to disable queues, change DB configuration to in-memory, etc. These environments are configured through the aptly-named files YAML files at the [config](src/main/resources/config) directory, and they all inherit from the base configuration file [application.yml](src/main/resources/config/application.yml).

## Run, Debug and Test
You can use your favorite IDE's default Java runners to run or debug the app (e.g. `Run as Java Application` on Eclipse), or run the tests. If you're more comfortable with the terminal, you can also use the appropriate Gradle commands.

## Gradle Commands
- Initialize an Eclipse project by downloading dependencies and creating necessary files (e.g. `.project`)
```bash
gradle eclipse
```
- Initialize an IntelliJ IDEA project
```bash
gradle idea
```
- Run the application in `dev` mode
```bash
gradle bootRun
```
- Package the application into a JAR file located at `build/lib/spring-boot-todo-{version}.jar`
```bash
gradle build
```
- Create a deployable WAR file located at `build/lib/spring-boot-todo.war`
```bash
gradle war
```

## Externalized Runtime Configuration
It's a big hassle to pass command-line arguments to the application when running through Gradle, so my advice is to first [build the application into a JAR file](#gradle-commands) when you need to change the runtime environment or to pass an argument. The following examples will adhere that method (don't forget to replace `{version}` with your own version number)

- Run the application in `prod` mode (feel free to replace `prod` with another value to run in a different environment, note that you can also specify multiple environments by concatenating them with commas, e.g. `dev,foo-bar,baz-bar`)
```bash
java -jar build/lib/spring-boot-todo-{version}.jar --spring.profiles.active=prod
```
- Override a certain configuration parameter even when an environment is set (e.g. run on a different port than what is preconfigured)
```bash
java -jar build/lib/spring-boot-todo-{version}.jar --spring.profiles.active=prod --server.port=9000
```

For much more detailed information on the subject, see the [Externalized Configuration section](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html) in the Spring Boot documentation.

## TODO
- Add missing TodoMVC functionality
- Add auto-generated API documentation

## License
MIT
