package com.dishant.springbootjobrunr.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.jobs.context.JobDashboardProgressBar;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobService {

    public static final long EXECUTION_TIME = 5000L;

    private AtomicInteger count = new AtomicInteger();

    @Job(name = "Job Name %0")
    public void process(String name, JobContext jobContext) {
        log.info("The sample job has begun. The variable you passed is {}", name);
        JobDashboardProgressBar progressBar = jobContext.progressBar(100);
        try {
            progressBar.setValue(25);
            Thread.sleep(EXECUTION_TIME);
            progressBar.setValue(75);
        } catch (InterruptedException ex) {
            log.error("Error while executing sample job", ex);
        } finally {
            progressBar.setValue(100);
            count.incrementAndGet();
            log.info("Sample job has finished...");
        }
    }
}
