# WebGoat + ngrok + Docker
Docker compose for building WebGoat with ngrok

Running:
```
docker-compose build
docker-compose up
```

## Selenium

Added Selenium support through IPython with a hidden browser display

Shell:
```
$ docker-compose run selenium
```

IPython:
```python
In[1]: from firefox import driver

In[2]: driver.get('http://webgoat:8080/WebGoat/')
```
