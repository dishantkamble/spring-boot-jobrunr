package com.dishant.springbootjobrunr.config;

import javax.sql.DataSource;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.postgres.PostgresStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobrunrConfig {

    @Bean
    public StorageProvider storageProvider(DataSource dataSource, JobMapper jobMapper) {
        PostgresStorageProvider storageProvider = new PostgresStorageProvider(dataSource);
        storageProvider.setJobMapper(jobMapper);
        return storageProvider;
    }
}
