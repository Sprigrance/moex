# Moex

Spring Boot приложение с полным стеком технологий для работы с MOEX (или других задач). Включает:

- REST API (Spring Web)
- Аутентификацию через JWT (Spring Security + JJWT)
- PostgreSQL (Spring Data JPA + Liquibase)
- Кеширование через Redis
- Хранение файлов в MinIO
- Документацию API через Swagger

## 🚀 Технические требования

- Java 17
- Maven 3.8+
- Docker 20.10+
- Docker Compose 2.0+

## ⚙️ Настройка окружения

1. Клонируйте репозиторий:
   ```bash
   git clone <your-repo-url>
   cd moex
   ```

2. Создайте `.env` файл:
   ```bash
   cp .env.example .env  # или создайте вручную
   ```

   Пример содержимого:
   ```ini
   # PostgreSQL
   POSTGRES_USERNAME=moex_user
   POSTGRES_PASSWORD=secure_password
   POSTGRES_DATABASE=moex_db

   # Redis
   REDIS_PASSWORD=redis_pass

   # MinIO
   MINIO_ACCESS_KEY=minioadmin
   MINIO_SECRET_KEY=minioadmin

   # JWT
   JWT_SECRET=your_jwt_super_secret
   JWT_EXPIRATION_MS=86400000
   ```

## 🐳 Запуск инфраструктуры

```bash
docker-compose up -d
```

Сервисы:

- PostgreSQL: `localhost:5432`
- Redis: `localhost:6379`
- MinIO:
    - API: `localhost:9000`
    - Консоль: `localhost:9090` (логин/пароль из `.env`)

## 🏗 Сборка и запуск

### Вариант 1: Через Maven
```bash
mvn clean package
java -jar target/moex-0.0.1-SNAPSHOT.jar
```

### Вариант 2: Прямой запуск
```bash
mvn spring-boot:run
```

Приложение будет доступно на: [http://localhost:8080](http://localhost:8080)

## 📚 Документация API

После запуска откройте:

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🔧 Настройка IDE

Для корректной работы:

**IntelliJ IDEA**:
1. Установите плагины:
    - Lombok
    - MapStruct
2. Включите аннотационные процессоры:
   `Settings → Build → Compiler → Annotation Processors → Enable`

**Общие настройки**:
```bash
mvn clean
# Перезапустите IDE
```

## 🛠 Устранение проблем

| Проблема                     | Решение                                                                 |
|------------------------------|-------------------------------------------------------------------------|
| Ошибки подключения к БД      | Проверьте `.env` и логи `docker logs postgres`                         |
| Lombok не работает           | Убедитесь в наличии плагина и обработке аннотаций                      |
| MapStruct не генерирует код  | Добавьте в аргументы компилятора: `-Amapstruct.defaultComponentModel=spring` |
| Версия Java                  | Убедитесь что `java -version` показывает 17+                          |

## 📈 Дальнейшие шаги

1. Добавьте описание бизнес-логики
2. Настройте CI/CD пайплайн
3. Добавьте интеграционные тесты
4. Настройте мониторинг (Prometheus + Grafana)

---

Для вопросов: [ваши контакты]
```

Основные улучшения:
1. Исправлено форматирование кодовых блоков и отступов
2. Добавлены отсутствующие закрывающие кавычки и скобки
3. Улучшена читаемость списков и подпунктов
4. Исправлена таблица устранения проблем (добавлены вертикальные разделители)
5. Добавлены гиперссылки для URL
6. Улучшена структура заголовков и подзаголовков
7. Удалены лишние пробелы и несоответствия в форматировании