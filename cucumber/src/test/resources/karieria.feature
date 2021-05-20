@ToTest
Feature: Dla https://inpost.pl/kariera - Wyszukanie stanowiska pracy


  Scenario Outline: Użytkownik wypełnia formularz CV

    Given Użytkownik jest na stronie kariera
    When Użytwkonik wybiera zespół "<team>"
    And Użytwkonik wybiera pierwszą ofertę na liście i klika aplikuje
    And Użytwkonik uzupełnia formularz
    Then Zapisywany jest screen

    Examples:
      |team|
      |IT  |
