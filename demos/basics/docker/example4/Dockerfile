FROM ubuntu:latest
MAINTAINER Luís Melo "lhsm@cin.ufpe.br"

RUN apt-get update -y
RUN apt-get install -y python-pip python-dev build-essential
RUN pip install flask

RUN mkdir /app && cd /app
WORKDIR /app

COPY . /app

CMD ["python", "app.py"]
