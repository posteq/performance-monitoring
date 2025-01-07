# Spring Boot Performance Monitor Starter

## Описание

Автоматически добавляет функциональность мониторинга времени выполнения методов.
• Позволяет настроить параметры через application.yml.
• Работает на основе аннотации `@MonitorPerformance`
## Установка

### 1. Клонируйте проект на ваш компьютер

### 2. Task- publishToMavenLocal

### 3. В основном Spring проекте подтянуть зависимость:
```
implementation 'by.clevertec:performance-monitoring:1.0.0'
```

### 4. Добавить mavenLocal()

### 5. Добавить в application.properties:
```
monitor:
  performance:
    enabled: true
    timeThreshold: 100
```
### 6. Над нужными методами поставить @MonitorPerformance
