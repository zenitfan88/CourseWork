**Процедура запуска автотестов**
1. Запустить ПО "Docker Desktop"
2. Запустить ПО "IntelliJ IDEA"
3. В терминале "IntelliJ IDEA" запустить БД командой docker-compose up
4. В терминале "IntelliJ IDEA" запустить приложение командой java -jar artifacts/aqa-shop.jar
5. В терминале "IntelliJ IDEA" запускаем тесты командой: ./gradlew clean test
6. В терминале "IntelliJ IDEA" запускаем формирование отчета о тестирование Allure командой: ./gradlew allureserve
