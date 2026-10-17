# CLAUDE.md

Информационная система агентства знакомств «Випадкова зустріч». Это программная часть магистерской квалификационной работы (НУК им. адм. Макарова, кафедра ИУСТ, 2025). Требования лежат вне репозитория: техническое задание, инструкция пользователя, разделы 1–2 диплома. Анализ расхождений с ними: `analysis/diploma-gap-analysis.md` в папке проекта.

## Общение
- Отвечать пользователю по-русски. Тексты интерфейса и документация к диплому на украинском.
- Перед изменением кода или конфигурации, коммитом, push, merge или созданием PR спрашивать пользователя.

## Стек
Java 17, Spring Boot 3.2.5 (Web, Data JPA, Thymeleaf, DevTools), Hibernate 6, Lombok, MariaDB, Maven (`mvnw`). Графики на страницах через Chart.js из CDN. По ТЗ ещё нужны Spring Security, Bootstrap/Tailwind, Google Maps API, JavaMail; в коде их пока нет.

## Запуск
- БД: MariaDB на `localhost:3306`, база `dating_agency_3`. Импортировать `dating_agency_3.sql` (актуальный дамп; `meeting_agency.sql` устаревший).
- Доступ к БД задан в `src/main/resources/application.yml` (пользователь `student`). Не коммитить новые пароли, выносить их в переменные окружения.
- Сборка: `./mvnw -DskipTests compile`. Запуск: `./mvnw spring-boot:run`, затем http://localhost:8080/.
- Тесты: `./mvnw test`. Сейчас есть только `contextLoads`, которому нужна живая БД.

## Структура (`src/main/java/com/example/obd_kursova`)
- `controllers/` — MVC-контроллеры Thymeleaf: `ClientsController` (список, профиль, редактирование, хобби/черты/требования), `DatesController` (встречи, архив), `ChatController`, `StatisticsController`.
- `services/` — `MainService` (большая часть логики), `ClientOperationsService`, `ChatService`.
- `repositories/` — Spring Data интерфейсы, сгруппированные по папкам (`onClientOperations`, `clientAttributes`, `dates`, `archive`, `chatRepositories`, `statistics`). Почти каждый содержит один native SQL-запрос через `@Query(nativeQuery = true)`.
- `data/` — JPA-сущности, соответствующие таблицам.
- `model/` — интерфейсные проекции (геттеры) для результатов native-запросов; имена геттеров должны совпадать с алиасами столбцов в SQL.
- `resources/templates/` — страницы Thymeleaf; `resources/static/` — CSS по одному на страницу и картинки.

## Схема БД
`client`, справочники `hobbies` / `characters` / `requirements` / `country`, связующие `hobbylist` / `characters_list` / `requirements_list` (столбцы `User_ID`, `*_ID`), `dating_table` (встречи: `User_1_ID`, `User_2_ID`, `Date`, `Registration_country`), `chat` (одна строка на сообщение), `archive` (строка `date_info` + страна; из архива не удалять, это требование ТЗ).

## Соглашения
- Новые SQL-запросы писать в стиле существующих (native `@Query` + проекция в `model/`), пока не принято решение переходить на JPQL.
- Запросы `INSERT`/`UPDATE`/`DELETE` помечать `@Modifying`, а вызывающий метод сервиса `@Transactional`.
- В шаблонах выводить данные через `th:text`, не `th:utext` (защита от XSS).
- Текущий пользователь сейчас передаётся параметром `id` в URL; при добавлении Spring Security брать его из сессии.

## Известные проблемы
- Удаление клиента с встречами падает на внешнем ключе `dating_table → client` (`ON DELETE NO ACTION`); отложено.
- `spring.jpa.generate-ddl: true` меняет схему при старте, если сущность в `data/` не совпадает с таблицей. После правки сущностей сверять схему с дампом.

## Не коммитить
`target/`, `.idea/`, `*.iml` (исключены в `.gitignore`).
