# Kafka user event service

## Beskrivning
Detta projekt är ett mjukvaruverktyg som syftar till att hjälpa användare med att optimera och analysera data. Med en intuitiv användargränssnitt, kan användare lätt importera, bearbeta och visualisera data i realtid.

## Förutsättningar
För att framgångsrikt köra detta projekt krävs följande förutsättningar och krav:
- Java Development Kit (OpenJDK) 17 LTS
- Maven (för att bygga och köra projektet)
- Minst 4GB RAM
- En aktiv internetanslutning
- **VIKTIGT:** Kontrollera `pom.xml` filen för att se alla beroenden och plugins som används i projektet. Speciellt för testning använder vi `junit-jupiter-api` version 5.10.0.
- Projektet använder [Spring Boot](https://start.spring.io/).

## Installation
1. Klona projektet till ditt lokala system:
2. https://github.com/AM1897/JINV23-Systemintegration
3. Bygg projektet med Maven:
4. `mvn clean install`

## Användning

**Starta programmet genom att köra:**

1. Se till att du har laddat ner Zookeeper. Starta cmd om du använder Windows, kopiera adressen till Zookeeper och starta den:
2. cd C:\Users\aram\Documents\kafka 
3. .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
4. Starta en ny cmd och starta sedan Kafka:
5. cd C:\Users\aram\Documents\kafka
6. .\bin\windows\kafka-server-start.bat .\config\server.properties



Följ instruktionerna på skärmen.

## Testning

Kör testerna med Maven:

För testning, använder projektet JUnit 5 (`junit-jupiter-api` version 5.10.0).

## Bidrag

Alla bidrag uppskattas. Skicka en pull request på GitHub. Se `CONTRIBUTING.md` för mer information.

## Licens

Licensierat under MIT-licensen. Se `LICENSE` för mer detaljer.


