# Projektrapport: Interaktion med Kafka via Webb-API

## Projektet

### Beskrivning av projektet
Detta projekt är ett kompletterande skript till det tidigare nämnda webb-API-projektet. Huvudsyftet är att interagera med webb-API:et genom att skapa, uppdatera, radera och visa användarinformation. En menybaserad interaktion möjliggör för användaren att utföra dessa åtgärder.

## Planering

### Lösningsförslag innan uppgiften påbörjas
Jag valde Trello kombinerat med Kanban-metoden för en smidig och visuell projektöversikt. Detta underlättade prioriteringar och arbetsflödets effektivitet.

### Vad som varit svårt
Det var en utmaning att säkerställa korrekt kommunikation mellan mitt skript och webb-API:t, särskilt när det kom till att hantera fel och undantag.

### Beskriv lite olika lösningar jag gjort
1. Jag implementerade en menydriven lösning för att underlätta interaktion med webb-API:et.
2. Jag använde Apache HTTP-klienten för att utföra POST, PUT, GET och DELETE-anrop.
3. Jag konverterade `User`-objekt till JSON-format för kommunikation med API:et.

### Beskriv något som var besvärligt att få till
Det var utmanande att förstå kursens riktning och vad som förväntades av mig. På grund av denna osäkerhet kände jag mig ofta under press, vilket ledde till att jag arbetade under stress och panik. Dessutom stötte jag på problem med min server.

### Beskriv om jag fick byta lösning och varför i sådana fall
Jag valde att genomföra ett enklare projekt eftersom andra alternativ skulle ha krävt mer tid än jag hade tillgängligt. Den mest praktiska lösningen under de givna omständigheterna var att utveckla ett enkelt CRUD-projekt.

## Reflektion & Slutsatser

### Vad gick bra
Jag lyckades skapa en effektiv interaktion med mitt webb-API, vilket demonstrerade dess kapacitet.

### Vad gick dåligt
Även om inget specifikt kommer till sinnes som gick dåligt, tog allting sin tid. Trots detta löste sig allt till slut på ett bra sätt.

### Vad har jag lärt mig
Jag har förvärvat kunskap om hur man integrerar mellan två olika projekt. Detta var en ny och spännande erfarenhet för mig.

### Vad hade jag gjort annorlunda om jag gjort om projektet
Om jag skulle göra om projektet skulle jag vilja integrera servern med Docker och även skapa en frontend för det. Jag hade ämnat utveckla en fullfjädrad "to-do"-lista, vilket skulle ha resulterat i två separata projekt: en klient och en server.

### Vilka möjligheter ser jag med de kunskaper jag fått under kursen
Jag har nu förmågan att snabbt sätta upp testklienter för att validera och demonstrera webbtjänsters funktionalitet.

## Övrigt

### Lämna förslag på förbättringar av min kod
1. Jag skulle kunna förbättra felhanteringen, speciellt för nätverksrelaterade fel.
2. Jag överväger att implementera ett grafiskt användargränssnitt för en bättre användarupplevelse.
3. Jag borde lägga till validering av användarinmatning för att undvika felaktiga API-anrop.
