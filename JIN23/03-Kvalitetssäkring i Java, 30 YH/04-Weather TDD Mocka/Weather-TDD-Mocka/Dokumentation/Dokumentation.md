# Projekt: TDD Weather API

### Namn: Aram

### Beskrivning av projektet
Projektet handlar om att skapa en väderprognosapplikation som interagerar med en extern API-tjänst (WeatherAPI) för att hämta väderinformation för en specifik stad.

### Vem har gjort vad
Jag har gjort hela projektet själv.

### Vad du har gjort
Vi har skapat en väderprognosapplikation som använder WeatherAPI för att hämta aktuell väderinformation för en given stad.

## Arbetet och dess genomförande

1. **City4casting**: Representerar en stad med variabler som namn, temperatur och väderbeskrivning. Klassen har även en metod för att skapa en instans från en JSON-sträng.
   
2. **WeatherAPI**: Ansvarar för att skicka GET-förfrågan till väder-API:t och tar emot svaret som en JSON-sträng.

3. **WeatherService**: Fungerar som mellanhand mellan `WeatherAPI` och `City4casting`. Den använder `WeatherAPI` för att hämta vädret för en stad och skapar sedan en `City4casting`-instans.

Jag har även inkluderat en **WeatherServiceTest**-klass där jag använder JUnit och Mockito för att testa funktionaliteten i `WeatherService`. Jag skapade en mock av `WeatherAPI` och skapade sedan ett `WeatherService`-objekt med denna mock. Jag har tre tester för att kontrollera att stadsnamnet, temperaturen och väderbeskrivningen alla är korrekta.

Mitt fokus har legat på Test-Driven Development (TDD) där jag börjar med att skriva tester för funktionen jag planerar att implementera och sedan skriver jag koden för att passera dessa tester. Detta försäkrar att all kod är testad från start och att tester alltid är uppdaterade när ny funktionalitet läggs till.

### Vad som varit svårt
Ingenting visade sig vara särskilt svårt eftersom vi hade genomgått allt mycket grundligt under lektionerna.

### Beskriv lite olika lösningar du gjort.
Visst, jag kunde ha gjort det enklare än vad det är nu, men jag valde att utmana mig själv lite mer och ta det till en högre nivå.

### Beskriv något som var besvärligt att få till
Allting var enkelt och jag stötte inte på några hinder, förutom när det kom till README.md och dokumentationen. Jag hade ursprungligen lagt all information i README.md, men valde sedan att göra om den.

### Beskriv om du fått byta lösning och varför i sådana fall
Jag observerade att nästan alla i klassen hade valt den enkla vägen, precis som jag hade gjort tidigare, och det fick mig att vilja göra saker lite annorlunda. Jag diskuterade med några av mina klasskamrater, Samer och Emil, och det var Emil's tillvägagångssätt som särskilt tilltalade mig. Han förklarade hur han hade tänkt under processen, vilket jag fann mycket intressant. Jag har alltid varit fascinerad av att förstå hur andra tänker, snarare än att bara följa en standard kodningsmetod.

## Slutsatser
Under projektet har jag framgångsrikt tillämpat testdriven utveckling (TDD). Genom att skriva tester först, har jag säkerställt att min kod uppfyller alla krav. Mocking har möjliggjort isolerade tester, vilket underlättat fokus på specifika funktioner. Sammanfattningsvis har TDD bidragit till hög kodkvalitet och lärorika insikter.

### Vad gick bra
Marcus hade skapat en fantastiskt bra repository för alla studenter.

### Vad gick dåligt
Det tog lite längre tid än förväntat att starta testerna. Även dokumentationsprocessen tog längre tid än förväntat, trots att projektet var relativt enkelt och litet.

### Vad har du lärt dig
Genom att genomföra detta projekt, lärde jag mig hur man implementerar TDD i Java, 
hur man använder Mockito för att skapa och använda mock-objekt för att testa interaktioner med en extern tjänst, och hur man använder ett externt API för att hämta data.

### Vad hade ni gjort annorlunda om ni gjort om projektet
Jag hade valt antingen att använda en API från SMHI eller skapa min egen API.

### Vilka möjligheter ser du med de kunskaper du fått under kursen
Jag ser positiva möjligheter även när testerna inte går igenom. För mig är det roligt eftersom jag kan visualisera det som ett frontend-projekt och uppleva snabba resultat.

### Material och hjälpmedel som användes i projektet:
Jag har använt ChatGPT för att förbättra min grammatik och uttryckssätt i dokumentationen och README-filen. Dessutom har jag haft Copilot som hjälpmedel under kodningen.
Jag och Emil har tagit och kollat på varandras kod och delat åsikter. jag tyckte att det var nyttigt att låta mina klasskamrater titta på min kod och ge feedback.
