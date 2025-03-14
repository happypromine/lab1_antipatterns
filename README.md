# Antipatterns calculator
- **Interface Soup**  
Интерфейс с кучей несвязанных методов, нарушающий ISP.

1. **God Object**  
Класс Calculator делает всё: вычисления, ввод-вывод, работу с файлами.

2. **Magic Number**  
Константа E без пояснений.

3. **Boat Anchor**  
Неиспользуемый метод readFromFile, оставленный "на будущее".

4. **Cryptic Code**  
Непонятные имена вроде o, l, u, fn.

5. **Spaghetti Code**  
Огромный switch для всех операций.

6. **Reinventing the Wheel**  
Свой метод корня вместо Math.sqrt().

7. **Blind Faith**  
Нет проверки на отрицательные числа в calculateSqrt.

8. **Reinventing the Square Wheel**  
Неэффективный метод возведения в степень с вложенными циклами.

9. **Copy and Paste**  
Повторяющийся код для операций 1–4.

10. **Stub (Заглушка)**  
saveToDatabase сохраняет в файл вместо БД.

11. **Hard Code**  
Жестко прописан путь к файлу.

12. **Empty Catch Block**  
Пустые catch, игнорирующие ошибки.

13. **Висящие концы**  
Пустые методы интерфейса, которые не нужны.
