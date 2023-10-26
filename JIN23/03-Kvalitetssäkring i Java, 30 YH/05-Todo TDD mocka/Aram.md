# Aram

## Egna reflektioner
Projektet var egentligen ganska enkelt, men jag tror att jag överanalyserade det och gjorde det svårare för mig själv.
Jag började med en grundläggande CRUD-funktionalitet och bestämde mig sedan för att lägga till en registrering och inloggning, 
vilket gjorde att det blev en individuell Todo-lista för varje användare. 
Dock valde jag att inte inkludera lösenord i inloggningsfunktionen, vilket fungerade bra, 
men jag ville testa något annorlunda genom att dela upp min MongoDBFacade i olika filer.

Detta orsakade problem för mig eftersom jag inte kunde testa min databas på något sätt, 
vilket jag insåg att många andra också hade problem med. Jag kunde inte heller använda en falsk databas, 
vilket var rekommendationen.

## Projektet
### Todo list with users

## Beskrivning av projektet
Projektet fokuserade på att skapa en individuell todo-lista för varje användare, med användning av MongoDB som databaslösning. 
En annan viktig del av projektet var att implementera olika tester, inklusive JUnit-tester, 
och att använda GitHub Actions för att automatisera och underlätta testprocessen.

### Vad du har gjort
Jag har genomfört hela projektet på egen hand och använt en MongoDB-databas för att lagra användare och deras todo-listor. 
Under processen fick jag feedback och råd från Emil som gick igenom min kod och gav mig värdefulla tips. 
Dessutom har Samer försökt att hjälpa mig med testerna och har även assisterat mig med att konfigurera GitHub Actions, 
vilket var en ny erfarenhet för mig.

## Planering
Jag har använt Trello som verktyg för att organisera mitt arbete, 
och jag bjöd in Lars och Marcus för att de skulle kunna se min planering och mitt arbetsflöde.

### Lösningsförslag innan uppgiften påbörjas
En lösningsstrategi för att hålla mitt arbete framåtriktat är att dagligen notera mina uppgifter och var jag har avslutat. 
Genom att dokumentera vad jag ska göra och att tydligt markera var jag stannade kan jag enkelt återuppta arbetet och hålla mig organiserad.

#### Skisser (exempelvis)
Tyvärr hade jag inte möjlighet att göra några skisser eftersom jag stötte på en hel del problem och var tvungen att göra om programmet cirka sex gånger. Detta tog upp mycket tid och resurser, 
vilket gjorde att jag inte hade möjlighet att skapa några skisser.
#### Hur du tänker försöka lösa uppgiften.(exempelvis) 
Jag kommer att försöka lösa uppgiften genom att först skapa en grundläggande CRUD-funktionalitet, användare och sedan lägga till en registrering och inloggning.

#### Pseudokod.(exempelvis)
Projektet var fantastiskt. Det var det första projektet hittills som gav mig lite huvudvärk, 
men jag kommer att göra om det vid sidan av. Jag ger det en stark 6 på den här uppgiften.
#### Diagram.(exempelvis)
Jag valde att inte skapa något UML-diagram för detta projekt eftersom jag ansåg att antalet klasser var få och att det inte var nödvändigt att visualisera dem i ett UML-diagram.

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban
Jag använde mig av Trello enligt Scrum-metoden för att organisera mitt arbete och hålla mig uppdaterad.
### Vad som varit svårt
Det var utmanande för mig att använda Github Actions, och jag var tacksam för Samers hjälp eftersom jag inte var helt bekant med det. Github Actions innebär en känslig testprocess där små misstag kan påverka resultatet. Det var också svårt att testa databasen eftersom jag hade databasrelaterad kod i nästan alla mina klasser. Detta gjorde testningen mer komplex och krävde noggrann hantering för att säkerställa korrekthet och funktionalitet.
### Beskriv lite olika lösningar du gjort
Jag stötte på svårigheter med JUnit-testerna den här gången eftersom jag inte följde (TDD)-strukturen och valde att utmana mig själv. Genom att inte skriva testerna först och sedan implementera funktionaliteten, hamnade jag i en situation där jag behövde anpassa och justera befintlig kod för att passa testerna. Detta ledde till mer komplexitet och svårigheter i testprocessen. Trots dessa utmaningar, fick jag värdefulla lärdomar om vikten av TDD och att följa en strukturerad testdriven utvecklingsmetodik för att undvika liknande problem i framtiden.
### Beskriv något som var besvärligt att få till
Jag upplevde att Github Actions var besvärligt och det tog upp en hel arbetsdag då jag hade svårigheter och behövde be om hjälp. Jag spenderade mycket tid och energi på att lösa problem och kämpade för att få allting att fungera korrekt. Trots ansträngningen och den tid det tog, lyckades jag till slut övervinna utmaningarna och få Github Actions att fungera som det skulle.

### Beskriv om du fått byta lösning och varför i sådana fall
Jag tog beslutet att byta ut mitt befintliga CRUD-system för användare och istället implementera en mer komplett inloggnings- och registreringsfunktionalitet. Jag ansåg att detta skulle ge en mer omfattande och användarvänlig upplevelse för användarna av applikationen. Genom att implementera inloggnings- och registreringsfunktioner kan användare skapa sina egna konton och få tillgång till personliga funktioner och data i applikationen. Även om detta beslut innebar extra arbete och möjligen några utmaningar längs vägen, var jag övertygad om att det skulle förbättra användarupplevelsen och ge en mer komplett lösning för projektet.## Reflektion & Slutsatser

### Vad gick bra
Själva programmet gick väldigt bra att skriva och att det inte uppstod några konstigheter längs vägen
### Vad gick dåligt
Väldigt mycket gick dåligt. Testerna, att dela på MongoDBFacade på alla filer och att använda mig av server då jag inte behövde det. Tiden tikade och jag var tvungen att göra om allt flera gånger.
jag läste inte uppgiften ordentligt och missade små detaljer. Detta ledde till att jag fick göra om projektet flera gånger och att jag inte kunde slutföra projektet så som jag ville.
### Vad har du lärt dig
Under detta projekt har jag förvärvat en enorm mängd kunskap och erfarenhet. Jag har lärt mig vikten av att ha en tydlig struktur i mitt arbete, inklusive att starta med TDD när jag skapar tester. Att skriva läsbar kod har också varit en viktig lärdom för mig. Jag har insett betydelsen av att noggrant läsa och notera alla uppgiftsdetaljer för att undvika onödiga eller överflödiga delar i mitt arbete.

En annan spännande upptäckt för mig har varit användningen av Github Actions. Jag har haft möjlighet att utforska och använda verktyget, och det har gett mig insikter i hur man automatiserar och hanterar testprocesser i ett utvecklingsprojekt.

Sammanfattningsvis har jag lärt mig otroligt mycket genom detta projekt. Det har stärkt min förmåga att organisera mitt arbete, betonat vikten av att skapa välstrukturerad kod och ökat mitt fokus på att noggrant följa uppgiftens krav. Dessutom har jag fått en spännande introduktion till Github Actions och dess potential inom utvecklingsprocessen.
### Vad hade ni gjort annorlunda om ni gjort om projektet
Jag hade gjort om allt mycket bättre och mer noggrant men först och främst är att läsa uppgiften ordentligt. Att skapa TDD innan projekt starten. Och att inte dela MongoDBFacade på alla filer, för då får man problem med att testa.
### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Kursen har varit värdefullt för mig och att det kommer hjälpa mig mycket. Många av dessa var repetition för mig men i ett annat språk. 
I denna uppgift kände jag verkligen allt vi hade gått igenom och var viktig för min del att koppla ihop allt vi har lärt och att vi kommer kunna använda oss av det i framtiden.

## Övrigt
Jag är väldigt ledsen och arg på mig själv att jag lämnar min uppgift med stress så här sent och att jag ät inte helt nöjd med den. 
jag kommer att göra om allt även om jag nu får VG i detta.