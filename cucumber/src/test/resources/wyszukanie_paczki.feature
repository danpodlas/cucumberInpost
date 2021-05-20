@ToTest
Feature: Automatyzacja wyszukiwania stanu paczki w Cucumber poprzez GUI

  Background:
    Given Użytkownik jest na stronie głównej

  Scenario Outline: Użytkownik sprawdza status paczki po numerze.

    When Użytwkonik wpowadza numer paczki "<number>"
    Then Paczka została znaleziona
    And Status paczki zawiera słowo "<status>"

    Examples:
      |number|status|
      |680175798174312027659619|Dostarczona|
      |605080798151518110154556|Dostarczona|

  Scenario Outline: Użytkownik sprawdza status paczki po numerze, paczka nie istnieje w systemie.

    When Użytwkonik wpowadza numer paczki "<number>"
    Then Paczka nie została znaleziona

    Examples:
      |number|
      |505080798151518110154556|