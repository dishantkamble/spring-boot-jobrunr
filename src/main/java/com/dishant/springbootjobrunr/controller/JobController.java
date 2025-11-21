package com.dishant.springbootjobrunr.controller;

import java.util.Collections;

import com.dishant.springbootjobrunr.service.JobService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobScheduler jobScheduler;

    private final JobService jobService;

    @GetMapping("/enqueue/{name}")
    public ResponseEntity<String> enqueue(@PathVariable String name) throws JacksonException {
        this.jobScheduler.enqueue(() -> this.jobService.process(name, JobContext.Null));
        return this.okResponse();
    }

    private ResponseEntity<String> okResponse() throws JacksonException {
        String response = String.format("Job has been created. Please visit [%s] to view its status.", "http://localhost:8000/dashboard/jobs");
        return new ResponseEntity<>(new ObjectMapper()
                .writeValueAsString(Collections.singletonMap("message", response)), HttpStatus.OK);
    }
}
