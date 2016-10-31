FROM ubuntu:trusty
# selenium/standalone-firefox

ENV DISPLAY :99

RUN apt-get -y update
RUN apt-get install -y -q \
    firefox \
    xvfb \
    # libXfont \
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

# ADD xvfb_init /etc/init.d/xvfb
# RUN chmod a+x /etc/init.d/xvfb
# ADD xvfb-daemon-run /usr/bin/xvfb-daemon-run
# RUN chmod a+x /usr/bin/xvfb-daemon-run

RUN rm -f /tmp/.X99-lock

EXPOSE 99
