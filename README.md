# spring-boot-jobrunr
Sample project to depict implementation of jobrunr in Sprintboot dockerized application with PostGRE DB using docker-compose

# How to Run
To run this sample application please follow the below steps.

## Prerequisite:
1. Docker is running
2. Docker Compose is installed in the system where Docker is running [Reference](https://docs.docker.com/compose/install/)

**Note:** Docker compose should already be available if you are having Docker Desktop either for Windows or MacOS

## Steps:
1. Build the Docker image using docker-compose from the root directory of the project.

`docker-compose build`

2. Run the application

`docker-compose up`

3. View JobRunr [Dashboard](http://localhost:8000/dashboard/overview)

4. Trigger a new Job by using the enqueue `http://localhost:8080/jobs/enqueue/{JOB_NAME}` endpoint where `JOB_NAME` is the name of the Job you would like to give for displaying on the JobRunr dashboard
