# Antipatterns calculator
- **Interface Soup**  
Интерфейс с кучей несвязанных методов, нарушающий ISP.

- **God Object**  
Класс Calculator делает всё: вычисления, ввод-вывод, работу с файлами.

- **Magic Number**  
Константа E без пояснений.

- **Boat Anchor**  
Неиспользуемый метод readFromFile, оставленный "на будущее".

- **Cryptic Code**
Непонятные имена вроде o, l, u, fn.

- **Spaghetti Code**
Огромный switch для всех операций.

- **Reinventing the Wheel**
Свой метод корня вместо Math.sqrt().

- **Blind Faith**
Нет проверки на отрицательные числа в calculateSqrt.

- **Reinventing the Square Wheel**
Неэффективный метод возведения в степень с вложенными циклами.

- **Copy and Paste**
Повторяющийся код для операций 1–4.

- **Stub (Заглушка)**
saveToDatabase сохраняет в файл вместо БД.

- **Hard Code**
Жестко прописан путь к файлу.

- **Empty Catch Block**
Пустые catch, игнорирующие ошибки.

- **Висящие концы**
Пустые методы интерфейса, которые не нужны.
