--------------------

Por favor, indique passo-a-passo o que deve ser feito.  Por exemplo,
em que diretorio o comando "Building image" deve ser executado.  Fora
isto, eu instalei o Docker, mas nao tenho o daemon (servidor?)
rodando.  Indique quais pre-requisitos.  -Marcelo

--------------------


# Getting started with docker and simple app Django

All documentation to install Docker: 

  - https://docs.docker.com/engine/installation/
  

> Generaly in projects that will be in production we build our own image, but
> here is a simple demo so, I'm abstracting this step.


Building image: 
```sh
$ docker build -t demo_app .
```
> The argument `-t` means `tag` the name of our image.

Running:

```sh
$ docker run -it -p 8080:8080  demo_app
``` 
 About arguments: 
  - `-i` means `--interactive` keep stdin open even if not attached.
  - `-t` allocate a pseudo-tty, 
  - `-p` public a port from container to one port on the machine running the container.

> Those arguments will allow you interact with the 
> container as a simple app on your machine, as a exemple without them you will couldn't pass values to create a superuser as requested at the last line of `dockerfile`.


Finally Acess your:

[localhost] - localhost:8080


[localhost]: <localhost:8080>
