# Используем базовый образ с Java
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar-файл с вашим приложением в контейнер
COPY target/PracticeApp-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Указываем порт, на котором работает приложение (например, 8080)
EXPOSE 9009
