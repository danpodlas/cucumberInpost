Feature: Testy jednostkowe przeliczania ceny produktów

  Scenario Outline: Użytwkonik sprawdza poprawność przeliczania cen produktu powiększonych o podatek
    Given Użytkownik posiada produkt "<product>" "<type>" "<price>" "<name>"
    When System przelicza cenę i podaje ją użytkownikowi "<product>"
    Then Cena poprawna "<newPrice>"

    Examples:
    |product|type|price|name|newPrice|
    |Laptops|premium|5000|Asus|6000|
    |Laptops|standard|3000|Lenovo|3300|
    |Phone|premium|2000|Apple|2520   |
    |Phone|standard|800|Samsung|924  |
