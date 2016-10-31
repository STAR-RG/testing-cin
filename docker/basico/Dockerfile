FROM python:3.5.2

RUN pip install django

RUN mkdir current/

RUN cd current/ && django-admin startproject demo_app

WORKDIR current/demo_app

CMD python manage.py migrate && python manage.py runserver 0.0.0.0:8080