# Описание
Cервис, который обращается к сервису курсов валют, и отдает gif в ответ: если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke
Ссылки: REST API курсов валют - https://docs.openexchangerates.org/
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide

## Стек
- Java
- Spring Boot 2
- OpenFeign
- Gradle
- Docker

## Использование
```
http://localhost:8080/currency/richStatus
```

## Docker
```
docker build -t ratesgif-0.0.1 .
docker run -d -p 8080:8080 -t ratesgif-0.0.1
```
