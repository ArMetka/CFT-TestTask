# ЦФТ ШИФТ - Тестовое задание. Курс JAVA

## Утилита фильтрации содержимого файлов

### Использованные инструменты

- Java - [Amazon Corretto 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)

- Система сборки - [Apache Maven 3.9.9](https://maven.apache.org/download.cgi)

- Библиотека для обработки аргументов командной строки - [Apache Commons CLI 1.9.0](https://commons.apache.org/cli/download_cli.cgi)
```xml
<dependency>
    <groupId>commons-cli</groupId>
    <artifactId>commons-cli</artifactId>
    <version>1.9.0</version>
</dependency>
```

### Инструкция по сборке

#### Готовый jar

Требования:
- JDK/JRE Версии 21+

Порядок действий:
1. Скачать готовый .jar файл из вкладки [Releases](https://github.com/ArMetka/CFT-TestTask/releases)
2. Запустить (см. [Инструкция по запуску](#инструкция-по-запуску))

#### Сборка jar

Требования:
- JDK Версии 21+

Порядок действий:
1. Склонировать репозиторий при помощи `git clone`
```shell
git clone https://github.com/ArMetka/CFT-TestTask
```

2. Собрать проект при помощи `mnv` или `mvnw`
```shell
cd CFT-TestTask
mvn clean package
cd target
```

3. Запустить (см. [Инструкция по запуску](#инструкция-по-запуску))

### Инструкция по запуску

> `CFT-test.jar` в директории `target` не содержит зависимостей и не может работать за пределами директории `target`
 
> `CFT-test-jar-with-dependencies.jar` содержит все зависимости и может работать независимо

> `CFT-test.jar` из вкладки `Releases` на github также содержит все зависимости и может работать независимо

#### Синопсис

```shell
java -jar CFT-test.jar [-afs]... [FILE]...
java -jar CFT-test.jar [-afs]... -o OUTPUT_PATH [FILE]...
java -jar CFT-test.jar [-afs]... -p OUTPUT_PREFIX [FILE]...
```

#### Опции

| Опция |      Аргумент       | Описание                                       | 
|:-----:|:-------------------:|:-----------------------------------------------|
|  -a   |          -          | Режим дополнения в существующие файлы (append) |
|  -s   |          -          | Вывод краткой статистики                       |
|  -f   |          -          | Вывод полной статистики                        |
|  -o   |  Путь (директория)  | Путь для записи выходных файлов                |
|  -p   | Префикс имени файла | Префикс для имени выходных файлов              |


#### Пример запуска

```shell
java -jar CFT-test.jar -f -o . -p sample- test.txt test1.txt
```
