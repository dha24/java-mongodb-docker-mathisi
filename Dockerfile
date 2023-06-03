# Base image
FROM ubuntu:20.04

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:${PATH}"

# Install Java
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Install MongoDB
RUN apt-get install -y gnupg2 wget
RUN wget -qO - https://www.mongodb.org/static/pgp/server-6.0.asc | apt-key add -
RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/6.0 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-6.0.list
RUN apt-get update && apt-get install -y mongodb-org

# Copy the microservice JAR file to the container
COPY target/mathisi-0.0.1-SNAPSHOT.jar /app/mathisi-0.0.1-SNAPSHOT.jar
COPY mongod.conf /etc/mongod.conf
# Expose ports (if needed)
EXPOSE 8080 27018

# Set the working directory
WORKDIR /app

# Allow running mongod as root
USER root
# Set the ownership and permissions of the mongod.conf file
RUN chown root:root /etc/mongod.conf && chmod 644 /etc/mongod.conf

# Run the microserviceex
# multiple CMD instructions in your Dockerfile. Only the last CMD instruction is executed, so in your case, only the java -jar command is being executed and the mongod command is ignored.
CMD mongod --config /etc/mongod.conf && java -jar mathisi-0.0.1-SNAPSHOT.jar

