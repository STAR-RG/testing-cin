FROM ubuntu

RUN apt-get update
RUN apt-get -y install build-essential

COPY hello.c /
RUN make hello
CMD /hello
