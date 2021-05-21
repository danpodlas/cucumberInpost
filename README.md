# Instrukcja

Aby testy działały prawidłowo nalezy:

1. Zainstalować Javę w wersji 8 i skonfiguroać jako zmienną
   środowiskową https://javastart.pl/baza-wiedzy/wprowadzenie/instalacja-jdk
2. Mavena i skonfigurować jako zmienną środowiskową https://www.javappa.com/szybki-dostep/maven-instalacja
3. Zainstalować intellijIDE https://javastart.pl/baza-wiedzy/wprowadzenie/intellij-idea-instalacja-i-pierwszy-projekt
4. Uruchomić intellijIDE i pobrać pluginy: cucumber for java,
       gherkin. https://codegym.cc/pl/quests/lectures/pl.questsyntax.level03.lecture02
5. Uruchomienie testów odbywa się poprzez plik RunCucumberTest,
   klikamy na plik prawym przyciskiem myszy -> Run'RunCucumberTest'
   Scieżka do pliku w drzewku projektowym cucumber/src/test/java/pl/dpodlaski/RunCucumberTest.java
6. Wyniki testów widać w dolnym okienku intellijIDE (tylko te zaznaczone ptaszkiem są prawidłowe).
   Jeżeli, któryś z testów zostanie zfailowany mozna uruchomić pojedyńczy test wyszykująć go w scenariuszach. 
   Scenariusze znajdują się w plikach .feature, dostępnych pod ścieżką cucumber/src/test/resources.
   Plik z testem należy otworzyć i kliknąć prawym przyciskiem myszy na słowo Scenario, dla odpowiedniego scenariusza -> nastepnie klikamy RUn. 
   Wyniki w dolym okienku intellijIDE. 