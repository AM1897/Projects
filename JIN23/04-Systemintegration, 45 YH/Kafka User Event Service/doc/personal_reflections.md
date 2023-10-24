# Projektrapport: Aram

## Projektet namn:  Kafka user event service
### Beskrivning av projektet
Detta projekt handlade om att utveckla en applikation som hjälper användare att spåra deras dagliga aktiviteter och visualisera data på ett användarvänligt sätt.
Projektet syftar till att demonstrera hur man kan använda Spring Boot tillsammans med Apache Kafka för att producera och konsumera meddelanden. Applikationen hanterar en User-entitet där användare kan skapas, hämtas, uppdateras och raderas via RESTful API-endpoints. Meddelanden (antingen enkla textmeddelanden eller User-objekt representerade som JSON) kan publiceras till Kafka-ämnen, och det finns tjänster som konsumerar dessa meddelanden, antingen genom att bara logga dem eller genom att spara User-objekt till en databas.

## Planering
### Jira/Trello och projekthantering enligt Scrum/Kanban
Jag valde Trello kombinerat med Kanban-metoden för en smidig och visuell projektöversikt. Detta underlättade prioriteringar och arbetsflödets effektivitet.

## Arbetet och dess genomförande
### Vad som varit svårt
Initialt var projektet rättfram, men komplexiteten ökade när det kom till att starta olika servrar som Zookeeper och Kafka. Deras integration och konfiguration var utmanande.

### Beskriv lite olika lösningar du gjort
Jag beslutade att integrera MySql i detta projekt trots min tidigare preferens för MongoDB. Anledningen var att jag ville bredda min kompetens och förståelse för relationella databaser, även om jag tidigare haft en förkärlek för dokumentorienterade databaser som MongoDB.

### Beskriv om du fått byta lösning och varför i sådana fall
Jag följde kravets struktur noggrant och behövde inte byta någon av de initiala lösningarna. Detta visade sig vara effektivt, då jag kunde hålla mig på rätt spår och undvika onödiga komplikationer.

## Reflektion & Slutsatser
### Vad gick bra
Allt flöt på smidigt genom hela projektet. Den noggranna planeringen och att följa kravstrukturen ledde till en effektiv och problemfri arbetsprocess.

### Vad gick dåligt
som jag tidigare nämnde var att starta och konfigurera Zookeeper och Kafka en utmaning. Jag stötte på många problem och flaskhalsar som tog mycket tid att lösa.

### Vad har du lärt dig
Att integrera med externa system som Kafka, hantera databaser med Spring JPA och bygga robusta webb-API:er med Spring Boot.

### Vad hade du gjort annorlunda om du gjort om projektet
Om jag skulle genomföra projektet igen hade jag definitivt implementerat Docker för enklare hantering och skalbarhet av applikationen. Dessutom hade en frontend lagts till för att förbättra användarupplevelsen och visualisera data på ett mer användarvänligt sätt.

### Vilka möjligheter ser du med de kunskaper du fått under kursen
Med de kunskaper jag har förvärvat, ser jag möjligheter att ta mig an större och mer komplexa projekt i framtiden, samt att samarbeta med större team och bidra på ett mer meningsfullt sätt.
