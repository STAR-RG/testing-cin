1. Install "docker" on your system.  Follow instruction on the link
below.

  https://docs.docker.com/engine/installation/

2. Build image: 

$ docker build -t demo_app .

This command builds an image for a container named demo_app from the
Dockerfile in this directory.  The argument "-t" (for "tag") names the
image.

IMPORTANT: In case you see, "Cannot connect to the Docker daemon. Is
the docker daemon running on this host?", please check the following
link:

  http://stackoverflow.com/questions/33562109/docker-command-cant-connect-to-docker-daemon

3. Run the image

$ docker run -it -p 8080:8080  demo_app

Those arguments will allow you to interact with the container on your
machine.  This container contains a django app. 

About arguments: 
  - `-i` means `--interactive` keep stdin open even if not attached.
  - `-t` allocate a pseudo-tty, 
  - `-p` publish a port from the container to a port on the host machine.

This command is confusing!  It creates the container and runs it.  If
you run it multiple times it will create multiple containers.  Please
take a quick look at the following link:

http://stackoverflow.com/questions/37513511/whats-the-difference-between-the-docker-commands-run-build-and-create

4. Open webpage http://localhost:8080/

5. Quit with "CTRL+C" and then list all containers in your machine.

$ docker ps -a

To list only *running* container use "docker ps".

Be aware that the "container" and the "container image" are different
concepts.

6. Restart a container

$ docker restart [CONTAINER ID]

Find container id with "docker ps -a"

7. Attach to a running container

$ docker attach [CONTAINER ID]

8. CTRL+C