FROM ubuntu:trusty

ENV DISPLAY :99

RUN apt-get -y update
RUN apt-get install -y -q \
    firefox \
    xvfb \
    Xorg \
    libasound2 \
    libgtk2.0-0 \
    libdbus-glib-1-2 \
    libxcomposite1

RUN apt-get install -y -q \
    dbus-x11 \
    x11-xkb-utils \
    xfonts-100dpi \
    xfonts-75dpi \
    xfonts-scalable \
    xfonts-cyrillic \
    xserver-xorg-core

RUN rm -f /tmp/.X99-lock

EXPOSE 99
