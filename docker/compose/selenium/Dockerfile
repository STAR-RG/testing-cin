FROM ubuntu:trusty

ENV FIREFOX_VERSION 45.0.1
ENV DISPLAY 'display:99'

RUN apt-get update -y
RUN apt-get install -y python python-pip python-dev wget

RUN apt-get -qqy --no-install-recommends install firefox \
  && rm -rf /var/lib/apt/lists/* \
  && wget --no-verbose -O /tmp/firefox.tar.bz2 https://download-installer.cdn.mozilla.net/pub/firefox/releases/$FIREFOX_VERSION/linux-x86_64/en-US/firefox-$FIREFOX_VERSION.tar.bz2 \
  && apt-get -y purge firefox \
  && rm -rf /opt/firefox \
  && tar -C /opt -xjf /tmp/firefox.tar.bz2 \
  && rm /tmp/firefox.tar.bz2 \
  && mv /opt/firefox /opt/firefox-$FIREFOX_VERSION \
  && ln -fs /opt/firefox-$FIREFOX_VERSION/firefox /usr/bin/firefox

RUN apt-get upgrade -y

RUN pip install ipython ipdb selenium==2.53.6

RUN useradd -ms /bin/bash dev
ADD firefox.py /home/dev
WORKDIR /home/dev
USER dev
