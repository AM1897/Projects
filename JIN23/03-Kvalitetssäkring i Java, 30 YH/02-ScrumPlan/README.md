# Aram

Trello Planering https://trello.com/b/939TzcQ6/scrum-plan 

## Projektrapport: Scram Plan 

## Projektbeskrivning:

Mitt projekt inriktade sig på att utveckla en full stack lösning för ett fastighetsföretag, där behovet fanns att förbättra deras applikation för att hantera inkommande anmälningar från hyresgäster. 

Hyresgästerna kunde genom den uppgraderade applikationen skicka in anmälningar rörande eventuella problem eller defekter i sina boenden. När en anmälan mottogs, lagrades informationen direkt i företagets databas, vilket förenklade dokumenthanteringen och spårbarheten.

Samtidigt aktiverades automatiska notifikationer, vilket innebar att företaget och dess fastighetsskötare omedelbart blev informerade om anmälan. Detta ledde till snabbare respons- och åtgärdstider, vilket i sin tur ökade hyresgästernas nöjdhet.

Fastighetsskötaren kunde sedan adressera och lösa problemet baserat på informationen från anmälan. Efter avslutat arbete uppdaterades anmälan i systemet, vilket skapade en transparent och effektiv kommunikationskedja mellan hyresgäst, fastighetsskötare och fastighetsföretag.

Denna lösning bidrog till att skapa en mer strömlinjeformad och effektiv process för hantering av hyresgästanmälningar, och den säkerställde även att all relevant information sparades på ett strukturerat och lättillgängligt sätt i företagets databas.


## Beskrivning av Planering

För att effektivt inleda vårt projekt inrättade jag först ett digitalt arbetsflöde genom Trello. Jag bjöd in hela teamet till denna plattform, vilket skapade en central plats för oss att spåra och hantera projektets framsteg. I syfte att främja samarbete och realtidskommunikation bland teammedlemmarna, startade jag också ett delat dokument på Google Docs.

Vårt arbete inleddes genom att noggrant ta till oss instruktionerna från företaget för att fullständigt förstå vad de önskade. De upplevde problem med felrapportering från deras hyresgäster. När en felanmälan skickades in, sparades den inte alltid korrekt i databasen. Alternativt, hamnade den inte i deras backlog, vilket förhindrade dem från att utföra nödvändigt arbete. Det framkom att det befintliga systemet var byggt med WordPress.

Vårt team består av fem individer, alla med en unik kombination av kunskaper och erfarenheter. Denna diversitet underlättade uppdelningen av arbetsuppgifter, särskilt eftersom företaget sökte en full-stack lösning. Vi är välpositionerade för att möta dessa krav och ser fram emot att leverera ett framgångsrikt projektresultat.

## Team
- Marcus:    Testing
- Bob:       Frontend
- Dylan:     Backend
- Céline:    UX/UI
- Lars:      Database/API

## backlog

### Backend

### 1. Controller-klasser
Dessa klasser tar emot och hanterar förfrågningar från frontend. I ditt fall kan du ha en "RapportController" som tar emot rapporter från hyresgästerna.

### 2. Service-klasser
Dessa klasser utför faktiskt affärslogiken i din applikation. Du kan ha en "RapportService" som hanterar skapande och uppdatering av rapporter.

### 3. Repository-klasser
Dessa klasser hanterar interaktionen med din databas. Du kan ha en "RapportRepository" som utför faktiska CRUD-operationer (Create, Read, Update, Delete) på dina Rapport-entiteter i databasen.

### 4. Entitet-klasser
Dessa är modeller av dina dataobjekt. I ditt fall kan du ha en "Rapport" entitet, och kanske andra entiteter för "Hyresgäst", "Företag" och "Vaktmästare".

**Backlog för backend:**
- Skapa "Rapport" entitetsklass.
- Skapa "RapportRepository" klass.
- Implementera CRUD-operationer i "RapportRepository".
- Skapa "RapportService" klass.
- Implementera affärslogik i "RapportService".
- Skapa "RapportController" klass.
- Implementera endpoint för att ta emot rapporter i "RapportController".

## Databas

**Backlog för databas:**
- Skapa databas-schema.
- Skapa tabeller/entiteter i databasen (t.ex. "Rapporter", "Hyresgäster", "Företag", "Vaktmästare").
- Implementera relationer mellan tabellerna/entiteterna (om det behövs).
- Implementera indexering (om det behövs).
- Implementera säkerhets- och integritetsregler (om det behövs).


### Sprint

**1. Sprint Planning:** 
- Detta är ett möte i början av varje sprint där teamet och produktägaren går igenom backloggen och bestämmer vilka user stories som ska inkluderas i den kommande sprinten. Du bör diskutera och komma överens om vilka uppgifter som är prioriterade och vad som är realistiskt att genomföra inom den kommande sprintens tidsram.

**2. Daily:**
- Detta är ett kort dagligt möte där varje teammedlem uppdaterar resten av teamet om vad de har åstadkommit sedan sist, vad de planerar att göra nästa och om det finns några hinder i deras väg.

**3. Sprint Review:** 
- Detta är ett möte vid slutet av varje sprint där teamet visar upp vad de har åstadkommit under sprinten. Detta möte kan hjälpa till att ge feedback och justera planer baserat på vad som faktiskt har åstadkommits.

**4. Sprint Retrospective:**
- Detta är också ett möte vid slutet av varje sprint, men fokuserar på teamdynamiken snarare än själva produkten. Teamet diskuterar vad som fungerade bra, vad som kan förbättras och kommer överens om några konkreta steg för att förbättra under nästa sprint.


# Testning Backlog

## 1. Enhetstestning
Enhetstestning involverar att skapa tester för enskilda metoder och funktioner i din kod. Detta kan inkludera att skriva tester för dina tjänster, repositories och controllers.
- Skriv enhetstester för "RapportService" klassen.
- Skriv enhetstester för "RapportRepository" klassen.
- Skriv enhetstester för "RapportController" klassen.

## 2. Integrationstestning
Integrationstestning innebär att testa hur olika delar av din applikation arbetar tillsammans. Det kan inkludera att testa hur din frontend kommunicerar med dina API:er, eller hur dina tjänster interagerar med ditt databaslager.
- Skriv integrationstester för "RapportController" och "RapportService".
- Skriv integrationstester för "RapportService" och "RapportRepository".

## 3. Systemtestning
Systemtestning innebär att testa din applikation som en helhet för att säkerställa att den uppfyller de specificerade kraven.
- Skriv systemtest för hela rapporteringssystemet.

## 4. Acceptanstestning
Acceptanstestning, ibland kallad användartestning, innebär att testa applikationen i ett miljö som liknar den verkliga användningsmiljön.
- Skriv acceptanstester för rapporteringsfunktionaliteten.

## 5. Automatisering av tester
Du kanske också vill automatisera dina tester, så att de körs automatiskt när du gör ändringar i koden.
- Automatisera körning av enhets- och integrationstester.
- Sätt upp ett verktyg för CI/CD (Continuous Integration / Continuous Deployment).

Dessa är generella uppgifter och du kanske behöver justera dem lite beroende på ditt specifika projekt och vilken testram du använder.

### In Progress:
När du börjar arbeta på ett testfall, flyttar du det till "In Progress". Detta visar att arbetet har börjat.
 
### Done:
När testning är genomförd och du är nöjd med resultaten, flyttar du testfallet till "Done". Detta indikerar att testfallet har genomförts framgångsrikt.

### Blocked:
Om du stöter på problem som hindrar dig från att genomföra eller slutföra ett testfall, flyttar du det till "Blocked". Detta visar att arbetet inte kan fortsätta förrän problemet är löst.

## Utveckling:
Det är avgörande i projektets utvecklingsprocess att förstå projektets krav och behov korrekt från produktägaren. Ibland kan produktägaren vara osäker på exakt vad de vill ha, och i dessa fall spelar vår roll som utvecklare en nyckelfunktion. Vi behöver vara aktiva i att ge feedback och föreslå olika lösningar baserat på vår tekniska kompetens och erfarenhet.

Att etablera en dialog med produktägaren är en viktig del av utvecklingsprocessen. Det innebär att vi kontinuerligt diskuterar och analyserar behoven, för att tillsammans hitta den bästa lösningen. Genom att ständigt ha en öppen kommunikation och genom att lägga fram förslag och idéer, kan vi tillsammans formge och utveckla en applikation som tillgodoser fastighetsföretagets behov på bästa möjliga sätt.

Denna proaktiva och kollaborativa metod att arbeta på bidrar till att vi kan skapa mer effektiva och användarvänliga system, samtidigt som vi stärker vårt arbetsförhållande med produktägaren.

## Datatyper:
I det här projektet lade jag primärt fokus på Scrum-metoden och processen kring projektutveckling, snarare än de tekniska detaljerna i koden. Scrum är en agil projektledningsmetodik som främjar samarbete, flexibilitet och kontinuerligt förbättringsarbete, vilket var centralt för detta projekt.

## Vad kunde ha gjorts bättre:
I efterhand finns det alltid områden som kan förbättras. I det här fallet känner jag att jag kunde ha gjort en bättre jobb med att demonstrera datatyper och mina tankar kring databasstrukturen under presentationen av projektet. Även om jag hade alla dessa detaljer och tekniska aspekter förberedda i projektet, missade jag möjligheten att inkludera dem i min presentation.

Specifika delar av projektet, såsom klasser och metoder, kunde också ha beskrivits mer detaljerat. Jag tror att detta skulle ha förbättrat min publikens förståelse för projektet och för den tekniska lösningen jag utvecklade. Dessa detaljer sparades i stället för rapporten, vilket i retrospekt kanske inte var det mest optimala beslutet.

## Slutsatser:
Projektet gick ut på att utveckla en effektiv applikation för ett fastighetsföretag för att hantera inkommande felanmälningar från hyresgäster, vilket ökade snabbhet i respons och förbättrade hyresgästernas nöjdhet. Genom att använda Trello och Google Docs, skapade teamet ett strukturerat arbetsflöde för att hantera projektet. Användning av Scrum-metoden möjliggjorde förbättringar genom samarbete och flexibilitet. Kritiskt för framgången var kontinuerlig kommunikation med produktägaren och att löpande justera målen efter feedback. I retrospekt, skulle mer detaljerad presentation av tekniska aspekter och tankar kring databasstrukturen ha förbättrat projektets framställning och förståelse.


## Beskriv något som var besvärligt att få till.
Det största problemet i projektet var skapandet av UML-diagrammen och formuleringen av backloggen. Båda dessa processer kräver mycket tid och detaljerad planering. Dessutom var det svårt att hitta ett lämpligt projekt att arbeta med, vilket bidrog till komplexiteten och utmaningen. Trots att projektets fokus var på backend, API, databas och testning, vilka är centrala delar i vår utbildning, så var arbetet med att strukturera och organisera dessa delar mycket krävande. Jag förutser att kommande projekt kommer att innefatta ännu mer arbete och komplexitet, givet deras omfattning och krav.

## Vad gick bra:
När projektets inriktning och presentationens ämnen blev klara, flöt allt mycket smidigt. Bestämningen av projektets fokus och det att välja vad som skulle presenteras var avgörande för framgången, vilket ledde till att alla delar av projektet gick bra. Det visar vikten av noggrann planering och tydlig målsättning inom projektledning.

## Vad gick dåligt:
Det fanns flera brister i mitt projekt. Presentationen var inte framgångsrik. När jag såg hur väl förberedda och planerade mina klasskamrater var, insåg jag att jag hade missförstått projektets riktning och krav.

## Vad har du lärt dig.
Jag har verkligen lärt mig en hel del, särskilt när det gäller Scrum-metoden. Jag förstod att det är viktigt att inte avvika och förlora sig i sidospår, utan att hålla fokus på själva projektet och vad det innebär. Trots att jag läste inlämningsuppgiften noggrant, missförstod jag den. Framöver ska jag vara mer fokuserad på själva Scrum-processen än på hur projektet ska utföras. Jag insåg att jag hade gått ifrån Scrum-temat under presentationen när jag jämförde mitt projekt med mina klasskamraters.

## Material och hjälpmedel som användes i projektet:
Eftersom svenska inte är mitt modersmål, har jag använt ChatGPT för att förbättra min grammatik och uttryckssätt, vilket gör att min lärare lättare kan förstå mig. När det gäller planering, har jag använt Trello som verktyg. För att skapa mina UML-diagram har jag utnyttjat Miro. Dessa hjälpmedel har varit betydande i genomförandet av mitt projekt.

![Presentation](./01-Scrum.png)
![Presentation](./02-Scrum.png)
