package com.yalingunayer.todo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

/**
 * The main application class that serves as the entry point of the application.
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * Predefined run modes. Useful for static checks inside the codebase.
     */
    public static interface Modes {
        String DEVELOPMENT = "dev";
        String PRODUCTION = "prod";
        String FAST = "fast";
    }

    @Autowired
    private Environment env;

    @PostConstruct
    private void init() {
        if (env.getActiveProfiles().length == 0) {
            logger.warn("No Spring profile configured, running with default configuration");
        } else {
            logger.info("Running with Spring profile(s): {}", Arrays.toString(env.getActiveProfiles()));
        }
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        if (!source.containsProperty("spring.profiles.active")) {
            logger.info("No application mode is set, will use {} as default", Modes.DEVELOPMENT);
            app.setAdditionalProfiles(Modes.DEVELOPMENT);
        }
        app.run(args);
    }
}
