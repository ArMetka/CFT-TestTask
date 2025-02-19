# ЦФТ ШИФТ - Тестовое задание. Курс JAVA

## Утилита фильтрации содержимого файлов

### Использованные инструменты

- JDK - [Amazon Corretto 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)

- Система сборки - [Apache Maven 3.9.9](https://maven.apache.org/download.cgi)

- Библиотека для обработки аргументов командной строки - [Apache Commons CLI 1.9.0](https://commons.apache.org/cli/download_cli.cgi)
```xml
<dependency>
    <groupId>commons-cli</groupId>
    <artifactId>commons-cli</artifactId>
    <version>1.9.0</version>
</dependency>
```

- Фреймворк для тестирования - [jUnit 5.11.4](https://junit.org/junit5/)
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.11.4</version>
    <scope>test</scope>
</dependency>
```

- Фреймворк для Mock-тестирования - [Mockito 5.15.2](https://site.mockito.org)
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.15.2</version>
    <scope>test</scope>
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
git clone git@github.com:ArMetka/CFT-TestTask.git
```

2. Собрать проект при помощи `mvn` или `mvnw`
> При использовании `mvnw` иногда необходимо явно указывать расположение скрипта: `./mvnw` или `.\mvnw`

> При использовании `mvnw` на linux необходимо также разрешить исполнение командой `chmod`

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
java -jar CFT-test.jar [-afs]... [FILE.txt]...
java -jar CFT-test.jar [-afs]... -o OUTPUT_PATH [FILE.txt]...
java -jar CFT-test.jar [-afs]... -p OUTPUT_PREFIX [FILE.txt]...
```

#### Опции

| Опция |      Аргумент       | По умолчанию |                    Описание                    |
|:-----:|:-------------------:|:------------:|:----------------------------------------------:|
|  -a   |          -          |    false     | Режим дополнения в существующие файлы (append) |
|  -s   |          -          |     true     |            Вывод краткой статистики            |
|  -f   |          -          |    false     |            Вывод полной статистики             |
|  -o   |  Путь (директория)  |     "."      |        Путь для записи выходных файлов         |
|  -p   | Префикс имени файла |      ""      |       Префикс для имени выходных файлов        |

#### Пример запуска

```shell
java -jar CFT-test.jar -f -o . -p sample- test.txt test1.txt
```

### Особенности реализации

#### Представление чисел - `BigInteger`, `BigDecimal`

В связи с отсутствием ограничений на размер входных данных, было решено использовать класс 
`BigInteger` для представления целых чисел и `BigDecimal` для вещественных. Данные классы позволяют хранить числа 
практически неограниченного размера. `BigDecimal` также используется для расчета среднего для целых чисел.

#### Входные аргументы и опции утилиты - `Apache Commons CLI`

Для парсинга аргументов программы используется библиотека `Apache Commons CLI`, позволяющая удобно считывать опции.

#### Считывание входных данных

В задании не было информации насчет обработки пустых строк, поэтому было принято решение их игнорировать 
(минимальная длина строки = 1)

#### Формат входных файлов

Утилита обрабатывает входные файлы только с расширением `.txt`