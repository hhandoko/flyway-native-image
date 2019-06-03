package com.hhandoko.svm.flyway;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final String DB_URL = "jdbc:postgresql://0.0.0.0:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "S3cret!";

    public static void main(String[] args) {
        logger.info("Starting database migration");

        Flyway.configure()
                .dataSource(DB_URL, DB_USER, DB_PASSWORD)
                .load()
                .migrate();

        logger.info("Database migration completed");
    }
}
