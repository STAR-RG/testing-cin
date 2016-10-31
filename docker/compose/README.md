# Exemplo de Docker Compose

Utilizando Docker para rodar [WebGoat](https://www.owasp.org/index.php/Category:OWASP_WebGoat_Project) no [ngrok](https://ngrok.io) + integração com [Selenium](http://selenium-python.readthedocs.io/), acessível pelo terminal do [IPython](https://ipython.org/).

### Rodando o projeto:

```
# O build pode demorar entre 5 e 20 minutos (depende da conexão).
$ docker-compose build

# O up executará e criará os links entre os containers
$ docker-compose up
```

### Usando o Selenium

Para entrar no terminal do IPython:
```
$ docker-compose run selenium
```

Uma vez dentro do IPython, basta executar:
```python
In[1]: from firefox import driver

In[2]: driver.get('http://webgoat:8080/WebGoat/')
```
