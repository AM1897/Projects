# Project Submission

## Innehåll
1. [Inledning](#inledning)
    1. [Bakgrund](#bakgrund)
    2. [Frågeställningen](#frågeställningen)
    3. [Mål](#mål)
    4. [Avgränsning](#avgränsning)
    5. [Syfte](#syfte)
    6. [Vad ska ni leverera?](#vad-ska-ni-leverera)
2. [Projekt Uppgift](#projekt-uppgift)
    1. [Uppgift](#uppgift)
    2. [Funktioner som ska finnas för Godkänt samt Väl Godkänt](#funktioner-som-ska-finnas-för-godkänt-samt-väl-godkänt)
3. [Betygskrav](#betygskrav)
4. [Sista inlämningstid](#sista-inlämningstid)

## Inledning

### Bakgrund
Detta projekt har utvecklats för att demonstrera kunskaper i att skapa och konfigurera ett Java RESTful API som interagerar med en databas och erbjuder CRUD-funktionalitet.

### Frågeställningen
Centrala frågor i detta projekt inkluderar:
- Hur kan man effektivt skapa och hantera en bokdatabas via ett RESTful API?
- Vilka säkerhetsmekanismer bör implementeras för att skydda känsliga operationer?

### Mål
Målet är att leverera ett fullständigt fungerande RESTful API med CRUD-operationer som är säkrade och optimerade för användning.

### Avgränsning
Projektet avgränsar sig till backend-utveckling utan att inkludera en frontend-klient.

### Syfte
Syftet är att tillämpa teoretiska kunskaper i en praktisk situation och att lära sig att bygga en professionell serverapplikation.

### Vad ska ni leverera?
Ett GitHub-repository med källkoden för ett RESTful API samt dokumentation över hur API:t sätts upp och används.

## Projekt Uppgift

### Uppgift
Att utveckla ett RESTful API för en boksamling med stöd för CRUD-operationer, säkerhet och autentisering.

### Funktioner som ska finnas för Godkänt samt Väl Godkänt
För godkänt (G) på projektet krävs:
- Korrekt konfiguration av RESTful API med minst 5 olika endpoints.
- Fullständig CRUD-funktionalitet mot databas.
- Möjlighet att specificera ID för dataposter via URL och inkludera ny data i förfrågningskroppen.

För väl godkänt (VG) krävs dessutom:
- En fungerande inloggningsendpoint som returnerar en nyckel eller JWT till klienten.
- Användning av token för behörighetskontroll till `Update` och `Delete` endpoints i API:t.

## Betygskrav
För att erhålla betyget Godkänt (G) måste ovanstående krav för G-nivå uppfyllas. För betyget Väl Godkänt (VG) måste samtliga krav för både G och VG uppfyllas.