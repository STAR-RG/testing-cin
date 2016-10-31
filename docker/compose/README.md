# Exemplo de Docker Compose

Utilizando Docker para rodar [WebGoat](https://www.owasp.org/index.php/Category:OWASP_WebGoat_Project) no [ngrok](https://ngrok.io) + integração com [Selenium](http://selenium-python.readthedocs.io/), acessível pelo terminal do [IPython](https://ipython.org/).

### Rodando o projeto:

Criar um arquivo chamado `.env`.

Caso o **ngrok** seja utilizado, adicionar a seguinte linha no `.env` 
e substituir os `...` pelo token da sua conta:
```
NGROK_TOKEN=...
```
Caso contrário, deixe o `.env` vazio (o ngrok não executará).


Depois, basta rodar:
```
# O build pode demorar entre 10 e 30 minutos (depende da conexão).
$ docker-compose build
$ docker-compose up [-d]
```

### Usando o Selenium

Para entrar no IPython, execute o comando abaixo
(o `docker-compose up` ainda deve estar rodando em um terminal separado):
```
$ docker-compose run selenium
```

Uma vez dentro do IPython, basta executar:
```python
In[1]: from firefox import driver

In[2]: driver.get('http://webgoat:8080/WebGoat/')
```
