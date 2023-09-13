Feature: Регистрация пользователя

  Background: Нахожусь на главной странице сайта
    Given Открываем сайт "http://users.bugred.ru/"

  Scenario Outline: Пользователь регистрируется (<testName>)
    When Нажать на кнопку Войти
    And Ввести имя пользователя <userName>
    And Ввести Email пользователя <userEmail>
    And Ввести Пароль пользователя <userPassword>
    And Нажать кнопку Зарегистрироваться
    Then Проверяем что пользователь <userName> зарегистрирован успешно <extendedResult>
    Examples:
      | testName                      | userName | userEmail                | userPassword | extendedResult                                    |
      | "Корректные данные"           | "tur123" | "verygoodnice@gmail.com" | "123"        | "http://users.bugred.ru/"                         |
      | "Пропуск @ в email"           | "tur123" | "verygoodmail.ru"        | "123"        | "http://users.bugred.ru/user/register/index.html" |
      | "Пропуск . в email"           | "tur123" | "verygood@mailru"        | "123"        | "http://users.bugred.ru/user/register/index.html" |
      | "Пропуск имени пользователя"  | ""       | "verygood@mailru"        | "123"        | "http://users.bugred.ru/user/login/index.html"    |
      | "Пропуск email пользователя"  | "tur123" | ""                       | "123"        | "http://users.bugred.ru/user/login/index.html"    |
      | "Пропуск пароля пользователя" | "tur123" | "verygood@mail.ru"       | ""           | "http://users.bugred.ru/user/login/index.html"    |
