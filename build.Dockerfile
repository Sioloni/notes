FROM gradle:7.6.1-jdk17
COPY . /opt/app/
ARG WORK_DIR
WORKDIR /opt/app/${WORK_DIR}


