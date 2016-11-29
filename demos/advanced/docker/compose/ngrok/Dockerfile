FROM ubuntu:14.04

RUN apt-get update && \
    apt-get install curl unzip -y && \
    curl -o ngrok.zip https://bin.equinox.io/c/4VmDzA7iaHb/ngrok-stable-linux-amd64.zip && \
    unzip ngrok.zip -d /usr/bin && \
    rm -f ngrok.zip

RUN useradd -ms /bin/bash dev
USER dev
WORKDIR /home/dev
