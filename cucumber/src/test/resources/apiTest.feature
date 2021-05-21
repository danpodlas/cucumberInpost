Feature: Wyszukiwanie paczkomatów za pomocą API w Cucumber

  Scenario: Użytkownik pobiera listę paczkomatów z Krakowa
    Given Użytkownik skonfigurował połączenie
    When Użytwkonik wysyła żądanie o listę paczkomatów w Krakowie
    Then Użytkownik pobiera listę paczkomatów
    And Sprawdza czy wszystkie paczkomaty są z Krakowa