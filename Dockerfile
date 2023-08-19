FROM openjdk:11

COPY target/demo-pipeline.jar demo-pipeline.jar

ENTRYPOINT ["java","-jar","/demo-pipeline"]