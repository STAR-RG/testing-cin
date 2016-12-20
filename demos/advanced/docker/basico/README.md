This tutorial shows basic functionality of Docker.

HEADS UP:

- Image and containers are different abstractions.  An image abstracts
the initial requirements from your virtual environment whereas
containers are living things that instantiate those abstractions in a
real setting.  Containers can run; images can't.

PRE-REQUISITES:

- You need "docker" on your system.  If you don't have it, follow
instructions from https://docs.docker.com/engine/installation/.

STEPS:

1. Create file named "Dockerfile" with the following contents.  

===
FROM python:3.5.2 # include from hub.docker.com
RUN pip install django
RUN mkdir current/
RUN cd current/ && django-admin startproject demo_app
WORKDIR current/demo_app
## this is executed to startup a container 
CMD python manage.py migrate && python manage.py runserver 0.0.0.0:8080
===

This particular definition specifies an image of a "Hello World"
Django project.  The bulk of the work is done in the "FROM" line,
which includes a third-party spec from a Docker repository
(hub.docker.com).  More precisely, this line specifies the
requirements to build an operational environment to run python 3.5.2.
Another line to highlight is the one that starts with "CMD".  The
command in this line is used to spawn the container.  For a more
detailed explanation on what goes on these docker files, check link
https://docs.docker.com/engine/reference/builder/.

2. Build image: 

$ docker build -t demo_app .

This command assumes you have a file "Dockerfile" in your current
directory.  It builds an image named "demo_app" from this file.  The
argument "-t" (for "tag") names the image.

IMPORTANT: In case you see the message "Cannot connect to the Docker
daemon. Is the docker daemon running on this host?", read instructions
on the following link.

  http://stackoverflow.com/questions/33562109/docker-command-cant-connect-to-docker-daemon

3. Spawn container (from image in database):

$ docker run -it -p 8080:8080 demo_app

Arguments used: 
  - `-i` means `--interactive` keep stdin open even if not attached.
  - `-t` allocate a pseudo-tty (terminal), 
  - `-p` publish a port from the container to a port on the host machine.

Please note that if you run this command multiple times it will create
multiple containers.  

4. Open webpage http://localhost:8080/.  It should show a "Hello
World"-kind for Django app.

5. Stop execution of container (on foreground, non-interactive mode)
with "CTRL+C".

At this point, you still have a container and a Docker image installed
on your system.  

OTHER USEFUL COMMANDS:

To list all containers on your machine:
  $> docker ps -a

To list only *running* containers:
  $> docker ps

To restart a container (not running):
  $> docker restart [CONTAINER_ID]

To reattach to a (running) container:
  $> docker attach [CONTAINER_ID]

To remove a container:
  $> docker rm [CONTAINER_ID]

To list all images:
  $> docker images
  
To remove an image:
  $> docker rmi [IMAGE_ID]
