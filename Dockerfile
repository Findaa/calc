FROM openjdk:11
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY . /app/
RUN cd app/src/main/java/com/upcprovision/calc && ls
ENTRYPOINT ["java", "/app/src/main/java/com/upcprovision/calc/CalcApplication"]