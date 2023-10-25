# Aram

[Trello planering](https://trello.com/b/YT0pN80V/crud-mongodb)

## Projektrapport: MongoDB Facade & Crud
I detta projekt har jag utvecklat en Java-applikation för att hantera 
information om personer, kunder och anställda. 
Jag har implementerat följande funktioner och klasser:

1. En Person-klass som representerar en grundläggande person med egenskaper såsom namn, ålder och adress.
2. Två underklasser av Person: Kund och Anställd. Kund-klassen lägger till en extra egenskap kundnummer och Anställd-klassen lägger till en extra egenskap anställningsnummer.
3. En MongoDBFacade-klass som fungerar som en fasad för att hantera CRUD-operationer (Create, Read, Update, Delete) för både Kund- och Anställd-objekt. Klassen använder MongoDB Java Driver för att interagera med MongoDB-databasen.
4. En main-metod där vi skapar flera objekt av typerna Person, Kund och Anställd. Dessa objekt sparas i databasen med hjälp av MongoDBFacade. Därefter kan vi uppdatera och ta bort dem från databasen.
5. Applikationen är konfigurerad för att ansluta till en lokal MongoDB-server med anslutningssträngen mongodb://localhost:27017/{dinDatabas} om ingen annan anslutningsinformation finns tillgänglig.

## Beskrivning av Planering
Detta projekt genomfördes som ett individuellt arbete, vilket gav mig frihet att arbeta i min egen takt och stil utan att behöva anpassa mig till andra teammedlemmar. Trots detta arbetade jag strukturerat och följde en planerad arbetsprocess för att säkerställa att projektet slutfördes framgångsrikt.

Jag använde Trello, en projektledningsplattform som jag känner mig bekväm med, för att organisera och hantera projektets arbetsuppgifter. Med hjälp av Trello kunde jag enkelt dela upp projektet i mindre uppgifter och övervaka deras framsteg genom hela projektet.


## Utveckling
Utveckling och inlärning under projektet:

Under projektets gång utvecklades jag betydligt mycket, och en stor del av detta kan tillskrivas min entusiasm för att koppla samman programmet med MongoDB. Eftersom jag redan hade erfarenhet av att använda MongoDB sedan tidigare, kunde jag effektivt dra nytta av mina tidigare kunskaper och bygga på dem.

För att få ytterligare insikt och inspiration kring projektet tog jag hjälp av mina kollegor Emil, Samer och Robin för att förstå hur de hade tänkt kring CRUD-projektet. Det var särskilt användbart att få höra Emils synpunkter om Read-funktionen, eftersom det hjälpte mig att se hur andra personer angriper problemet och tänker kring lösningar.

Att samarbeta med och lära av mina kollegor hjälpte mig inte bara att förbättra min tekniska kunskap och programmeringsförmåga, utan också att förstå hur man effektivt kan samarbeta och kommunicera med andra inom ett projekt. Detta kommer att vara mycket värdefullt i framtida projekt och arbetsuppgifter.

Sammantaget har detta projekt givit mig möjlighet att fördjupa min förståelse för Java-programmering och MongoDB-integration samt att förbättra min problemlösningsförmåga och samarbetsfärdigheter.

## Datatyper

1. String: Används för att lagra text, som namn, adress, anställningsnummer och kundnummer. I dina Person, Kund och Anställd klasser används String för dessa attribut.
2. int: Används för att lagra heltal, som ålder. I dina Person, Kund och Anställd klasser används int för ålder-attributet.
3. Scanner: Används för att läsa indata från användaren. I din Main-klass används en Scanner för att läsa indata som namn, ålder, adress, typ av person (kund eller anställd), anställningsnummer, kundnummer och andra val.
4. ObjectId: Används för att representera ObjectID i MongoDB. I din MongoDBFacade klass används ObjectId när du uppdaterar och raderar dokument.
5. Bson: Används för att konvertera dokument till filter. I din MongoDBFacade klass används Bson när du skapar filter för att använda vid sökning, uppdatering och radering av dokument i databasen.
6. Document: Används för att representera ett dokument i en MongoDB-samling. I din MongoDBFacade klass används Document för att skapa och hantera dokument i MongoDB-samlingen.
7. MongoClient, MongoDatabase, MongoCollection och andra MongoDB-specifika typer: Dessa typer används för att hantera anslutningen till MongoDB och utföra CRUD-operationer på databasen.



## Vad kunde ha gjorts bättre:
När man startar programmet får jag den röda texten ovanför där den skriver varning för SLF4J. Jag hade kunnat förbättra det och kunna få bort den röda irriterande texten.


## Slutsatser:
Under projektets gång har jag utvecklat en Java-applikation som interagerar med en MongoDB-databas för att hantera CRUD-operationer för Person-objekt och dess underklasser, Kund och Anställd. Jag har jobbat strukturerat och använt verktyg som Trello för planering och organisation. Genom att samarbeta med kollegor och utbyta idéer och hjälp har jag förbättrat mina färdigheter och utvecklats under projektet.
Sammanfattningsvis har projektet varit en framgångsrik inlärningsupplevelse där jag har fått fördjupad kunskap om Java-programmering och interaktion med MongoDB. Det har även gett mig möjlighet att utvecklas personligt, samarbeta med andra och identifiera områden för förbättringar.


## Backlog
Övergripande:

1. Skapa grundläggande klasser för projektet:
   a. Skapa Person, Anställda, Kund, MongoDBFacade och Main-klasser
   b. Definiera och enas om variabler och deras placering
   c. Förenkla och förtydliga klassernas struktur

2. Testa alla klasser tillsammans:
   a. Implementera en testapplikation som använder alla skapade klasser
   b. Åtgärda eventuella kopplingsproblem mellan klasser
   c. Kontrollera att alla skapade klasser fungerar som förväntat

3. Skapa en databas och anslut till den:
   a. Konfigurera och upprätta en anslutning till MongoDB-servern
   b. Skapa en ny databas och en tillhörande collection
   c. Implementera CRUD-operationer i MongoDBFacade-klassen för att interagera med databasen
   d. Testa databasanslutningen och CRUD-operationerna för att säkerställa korrekt funktionalitet

4. Förbättra användarinteraktionen:
   a. Skapa en meny med olika val för användaren att interagera med programmet
   b. Implementera felhantering för att hantera ogiltiga användarinmatningar
   c. Skapa användarvänliga meddelanden och instruktioner för att vägleda användaren genom programmet

5. Utför ytterligare optimering och förbättringar:
   a. Identifiera eventuella prestandaproblem och föreslå lösningar
   b. Undersök möjligheter att utöka projektet med ytterligare funktionalitet eller förbättringar
   c. Åtgärda och förbättra eventuella problem som identifierats under projektets gång, såsom SLF4J-varningar


---------------------------------------------------------------------------


## Beskriv lite olika lösningar du gjort.

I det här projektet har jag stött på några utmaningar som jag har arbetat för att lösa.
Ett sådant problem var med sökfunktionen i applikationen. Ursprungligen hade jag skapat en sökfunktion som direkt
sökte efter filmens titel via API:et till OMDB. Men vi insåg att det skulle vara bättre att först söka i databasen
innan vi använde API:et, eftersom filmen kanske redan finns i databasen.

För att lösa detta problem ändrade jag sökfunktionen så att den först söker i SQLite-databasen.
Om filmen hittas i databasen returneras filmdata direkt från databasen. Om filmen inte hittas i databasen fortsätter
sökfunktionen med att söka efter filmens titel via API:et till OMDB. På så sätt kunde vi optimera sökfunktionen och
minska antalet API-anrop, vilket gör applikationen snabbare och mer effektiv.

Denna lösning innebar att jag behövde ändra sökfunktionens kod och säkerställa att den korrekt interagerade
med både databasen och API:et. Genom att lösa detta problem har jag förbättrat applikationens funktionalitet
och fått ytterligare erfarenhet av att arbeta med databaser och API:er.


## Beskriv något som var besvärligt att få till.
I början av projektet hade jag glömt att starta det som ett Maven-projekt och istället körde jag det som ett vanligt Java-projekt, vilket ledde till problem eftersom jag saknade xml-filen. För att lösa detta problem kämpade jag mig fram och lade till Maven i efterhand, vilket gjorde att projektet kunde fungera som tänkt.

När det gäller strukturen för projektet beslutade jag att inte inkludera this.id eftersom jag ansåg att det var onödigt. Istället valde jag att fokusera på att använda databasens genererade ID för att hantera CRUD-operationer.

För att underlätta uppdatering och radering av dokument i databasen, använde jag mig av en tidigare lösning från ett JavaScript-projekt. Där implementerade jag metoder för att uppdatera och ta bort dokument enbart genom att använda det unika ID som skapas i databasen. Detta förenklade interaktionen med databasen och minskade risken för felaktiga operationer.

## Vad gick bra
Jag tycker att det mesta i projektet gick bra, men jag stötte på en utmaning när det kom till att implementera (READ)-funktionen. Jag var osäker på hur jag skulle gå tillväga för att söka i databasen, så jag vände mig till mina klasskamrater för att se vilka sökfunktioner de använde. Vissa använde namn för att söka, medan andra hade mer avancerade sökfunktioner som tillät att söka på flera parametrar.

Efter att ha övervägt olika alternativ bestämde jag mig för att hålla det enkelt och visa allt som finns i databasen utan några avancerade sökfunktioner. Detta beslut baserades på min tidigare erfarenhet från ett JavaScript-projekt, där jag också valde att använda en enkel metod för att hämta och visa all data från databasen. Detta gjorde att jag kunde fokusera på att förbättra andra delar av projektet och därmed uppnå en mer robust lösning.

## Vad gick dåligt
En av de saker som inte gick så bra var den röda varningstexten som dyker upp när man startar projektet, som är relaterad till SLF4J. Denna varning är inte kritisk för projektets funktion, men det kan vara irriterande och eventuellt påverka användarupplevelsen.


## Vad har du lärt dig
Jag har lärt mig att det är viktigt att inte överkomplicera ett projekt som i grund och botten är enkelt. När jag jämförde mitt arbete med mina klasskamrater insåg jag att de ofta lade till mer funktionalitet än vad som egentligen behövdes. Jag har förstått att min tid är värdefull för kunden och att jag inte bör göra mer än vad kunden betalar för. Därför strävar jag efter att hålla mig till den enklaste lösningen som möjligt, samtidigt som jag uppfyller projektets krav och levererar en lösning som fungerar bra och är effektiv.


## Material och hjälpmedel som användes i projektet.
Under projektets gång har jag använt mig av flera olika material och hjälpmedel för att kunna förstå och utveckla mitt projekt:

1. Samtal och diskussioner med klasskamrater för att få insikter, idéer och tankar om hur de har arbetat med sina projekt.
2. Användning av Chat-GPT för att hjälpa mig skapa Maven som jag hade glömt i början av projektet, samt för att skriva README.md filen.
3. Användning av coPilot under kodningsprocessen för att få hjälp och vägledning.
4. Återanvändning av tidigare projekt, inklusive JavaScript, MongoDB och CRUD-funktioner som grund för mitt arbete.
5. Användning av YouTube-videor och Google för att söka efter information och hjälp när det behövdes.
6. Slutligen har jag fokuserat på att skapa min egen kod som jag förstår och kan förklara för andra, samt att arbeta på ett sätt som gör att alla kan läsa min kod eftersom det inte bara är mitt projekt.

Genom att använda dessa hjälpmedel och material har jag lärt mig att arbeta på ett sätt som gör att min kod är lättillgänglig och förståelig för alla som kommer i kontakt med den, vilket är viktigt för att skapa en väl fungerande kodbas.


## Uppdateringar efter inlämning.

Jag hade 2 problem som jag rättade nu efter feedbacken från läraren.

#### Det första jag uppmärksammades på var användandet av svenska bokstäver, såsom Å, Ä, Ö, i mitt programmeringsprojekt, vilket kan skapa komplikationer.Dessa komplikationer kan uppstå av flera skäl:
1. Användare kan komma från olika länder och därför inte vara vana vid svenska bokstäver.
2. Utvecklare och andra medarbetare kanske inte har stöd för svenska tecken i sina operativsystem eller utvecklingsmiljöer.
3. Databaser och andra system kan ha problem med att hantera eller sortera dessa tecken korrekt.
4. Sökmotorer och webbläsare kanske inte hanterar dessa tecken korrekt, vilket kan påverka SEO (sökmotoroptimering) eller användarupplevelsen.

För att lösa detta problem har jag ändrat alla svenska bokstäver till engelska bokstäver i hela projektet.

### Mitt andra problem var i kodningen.

Det andra problemet uppstod när jag skapade poster för anställda och kunder, då deras identifieringsnummer inte var unika, vilket ledde till dubletter. Jag löste detta genom att implementera en metod som kontrollerar om ett specifikt nummer redan finns i databasen. Om numret redan finns, skapas inte den nya posten för anställd eller kund.

Det var en utmaning, eftersom det kan bli komplicerat att hantera flera delar av koden samtidigt. Efter flera försök, valde jag att omarbeta hela 'create'-metoden för att effektivt lösa problemet. Detta gav mig en djupare förståelse för hur jag kan använda metoder för att tackla liknande utmaningar i framtiden.

## Förklaring av ChatGPT

I mina texter tar jag hjälp av ChatGPT, eftersom svenska inte är mitt modersmål. Jag kan ibland ha svårigheter med att skriva korrekt och att uttrycka mig med ett flytande språk. Användningen av ChatGPT hjälper mig att förbättra mina texter så att de blir mer förståeliga och korrekta språkligt sett. Denna assistans bidrar till att min lärare får en tydligare förståelse för det jag vill framföra i mina texter.

