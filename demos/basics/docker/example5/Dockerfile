FROM node:6.9.5

RUN mkdir /app && cd /app
WORKDIR /app

RUN npm install express --save

COPY . /app

CMD node app.js
