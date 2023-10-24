<h1>Aram</h1>

[Asana planering](https://app.asana.com/0/1204214556421554/board)

<h2> Projektrapport: Enkelt RPG-spel i Java </h2>

<h3> Beskrivning av spelet </h3>
Projektrapport: Enkel RPG-spel i Java
Spelet är uppbyggt kring en huvudkaraktär (spelaren) som slåss mot olika monster i en serie av nivåer. 
När spelaren besegrar ett monster, belönas denne med guld. Guldet kan sedan användas i spelets butik, 
som är en separat klass, för att köpa och uppgradera vapen, förbättra hälsa, attack och kraft.


<h3> Planering </h3>
För att organisera och planera vårt arbete använde vi projektledningsverktyget Asana. Vi skapade en uppgiftslista 
(Todo-list) för att hålla koll på projektets olika delar och säkerställa att alla gruppmedlemmar var informerade om de 
olika uppgifterna. 

Efter att ha identifierat vilka klasser som behövdes för att bygga spelet, delade vi upp dem mellan
gruppmedlemmarna. Vi upplevde vissa svårigheter i början av projektet, eftersom vi inte var helt säkra på vad spelet
skulle kräva. Detta ledde till att vi behövde skriva en del kod för att få en grundläggande struktur och sedan
kontinuerligt justera och förbättra planeringen efterhand.

Vi höll dagliga planeringsmöten och uppdaterade Asana med
kommentarer och nya uppgifter när det behövdes. Vi bestämde oss för att arbeta tillsammans varje dag från
kl. 09:00 till 16:00, med målet att vara lediga på kvällar och helger. Dessutom hade vi en daglig avstämning
(daily) mellan kl. 11:45 och 12:00, där vi gick igenom våra framsteg och diskuterade eventuella problem eller frågor
som uppkommit.


<h3> Utveckling </h3>
Under utvecklingsfasen följde vi vår planering och arbetsfördelning. Vi började med att skapa de grundläggande klasserna
och fokuserade på att få igång spelets grundfunktionalitet. Efter att ha etablerat grunden för spelet, 
arbetade vi på att förbättra och lägga till mer avancerade funktioner och mekaniker. Vi använde oss av 
versionhanteringssystemet Git för att effektivt samarbeta och hålla koll på våra ändringar. Regelbundna möten och 
kommunikation mellan teammedlemmarna underlättade utvecklingen och hjälpte oss att lösa problem och förstå varandras arbete.



<h3> Datatyper </h3>
I vårt projekt använde vi flera datatyper för att hantera olika aspekter av spelet. Här är några exempel på datatyper vi använde:

int: Användes för att representera numeriska värden, såsom hälsa, attackstyrka och guld.
String: Användes för att lagra text, såsom namn på spelare, monster och föremål.
boolean: Användes för att hantera logiska uttryck, såsom att kontrollera om en spelare är vid liv eller om en nivå är
klar.
Arrays och ArrayLists: Användes för att samla och hantera objekt, såsom föremål i spelarens inventarie och tillgängliga
vapen i butiken.


<h3> Vem gjorde vad: </h3>
<p>Aram skapade Player-, Item-, Shop-klasserna och Projektrapport. 
<p>Samer utvecklade BattleSystem- och GameLoop-klasserna, som var huvudklasserna för spelet. 
<p>Robin skapade Monster-klassen och kopplade ihop alla komponenter samt optimerade koden.


<h3> Vad kunde ha gjorts bättre: </h3>
Några förbättringar som kunde ha gjorts i projektet är:
<p>1.Bättre planering och tidsuppskattningar: Vi hade kunnat lägga mer tid på att undersöka och planera projektets omfattning innan vi började koda för att minimera ändringar under utvecklingen. 
<p>2.Enhetliga kodstandarder: Genom att följa samma kodstandarder och konventioner skulle vi ha kunnat göra koden lättare att läsa och underhålla. 
<p>3.Implementering av fler funktioner och innehåll: För att förbättra spelupplevelsen hade vi kunnat lägga till fler nivåer, monster, föremål och uppgraderingar.


<h3> Slutsatser: </h3>
I detta projekt har vi framgångsrikt skapat ett enkelt RPG-spel i Java. Genom att samarbeta som ett team och dela
upp arbetsuppgifterna kunde vi effektivt bygga spelet och dess funktioner. Under projektets gång stötte vi på 
flera utmaningar, men vi lärde oss vikten av god kommunikation, planering och problemlösning. Vi har också fått 
erfarenhet av att arbeta med Java och objektorienterad programmering. Genom att reflektera över vad vi kunde ha 
gjort bättre kan vi använda dessa lärdomar i framtida projekt för att fortsätta ut


<h3> Klassdiagram: </h3>

![BattleSystem.png](Image%2FBattleSystem.png)

![GameLoop.png](Image%2FGameLoop.png)

![Item.png](Image%2FItem.png)

![Monster.png](Image%2FMonster.png)

![Player.png](Image%2FPlayer.png)

![Shop.png](Image%2FShop.png)

![Weapon.png](Image%2FWeapon.png)


![diagram.drawio.png](Image%2Fdiagram.drawio.png)

<h3> Backlog </h3>

<h4> Övergripande: </h4>


Koppla Monster och Player till Battle System:
a. Skapa Monster- och Player-klasser med koppling till Battle System-klassen
b. Definiera och enas om variabler och deras placering (i GameLoop eller inte)
c. Förenkla och förtydliga klassernas struktur

Testa alla klasser i GameLoop:
a. Implementera en teststrid mellan spelare och monster
b. Åtgärda eventuella kopplingsproblem mellan klasser
c. Kontrollera att alla skapade klasser fungerar som förväntat

Uppdatera GameLoop med GameBoard:
a. Implementera GameBoard för spelarkontroll med W, A, S, D
b. Lägg till kollisionshantering med monster
c. Skapa en meny som visas vid kollision med ett monster
d. Använd regex för att förbättra och förenkla koden

Skapa Shop och Item-klasser:
a. Designa och implementera Shop-klassen med nödvändig funktionalitet
b. Koppla Shop-klassen till GameLoop
c. Skapa och koppla Item-klassen till Shop-klassen
d. Diskutera och välja bästa metoden för att hantera Item-objekt (ArrayList, HashMap, etc.)
e. Implementera vald metod för att lagra Item-objekt i GameLoop

<h4> Utförligare backlog: </h4>

<h5>Aram</h5>
skapade Player-klassen, som hanterar spelarens attribut och funktioner såsom hälsa, attack och försvar.
Han utvecklade även Item-klassen, som beskriver de olika föremålen som spelaren kan samla och använda under spelets gång.
Dessutom skapade Aram Shop-klassen, som innehåller logiken för att hantera köp och försäljning av föremål i spelet.
Aram ansvarade också för att skapa en projektrapport som dokumenterade teamets framsteg och beslut under projektets
gång.

<h5>Samer</h5>
utvecklade BattleSystem-klassen, som är grundläggande för spelets stridsmekanik och hanterar stridssekvenser
mellan spelaren och monstren. Han skapade också GameLoop-klassen, som styr spelets huvudloop och hanterar användarinput,
uppdateringar av spelstaten och renderingen av spelets grafik.

<h5>Robin</h5>
skapade Monster-klassen, som beskriver de olika monstren som spelaren stöter på och kämpar mot under spelets gång.
Han kopplade ihop alla komponenter, inklusive de klasser som utvecklats av Aram och Samer, och såg till att de fungerade
tillsammans på ett korrekt och effektivt sätt. Robin optimerade även koden för att förbättra spelets prestanda och
minska
eventuella fel eller buggar.


---------------------------------------------------------------------------


<h3>Beskriv lite olika lösningar du gjort.</h3>
Jag skapat en Player-klass som hanterar spelarens information och funktioner,
såsom hälsa, inventarie och förmåga att köpa och sälja föremål.
Shop-klassen sköter själva butiken där spelaren kan köpa och sälja föremål,
medan Item-klassen definierar de olika föremålen som kan köpas och säljas, inklusive deras pris och egenskaper.

<h3>Beskriv något som var besvärligt att få till.</h3>
Ett problem jag stötte på var när jag använde GitHub Desktop för att hantera versionskontroll av mitt projekt.
Workspace-filen kronglade och ville inte inkluderas i mina git pull-operationer. Detta ledde till att jag
fick lära mig att använda git-kommandon direkt i terminalen (konsolen) istället för att lita på det grafiska
gränssnittet som GitHub Desktop erbjuder.
För att lösa problemet fick jag hjälp av Samer, som vägledde mig genom de nödvändiga stegen för att använda
git-kommandon i konsolen.

<h3>Beskriv om du fått byta lösning och varför i sådana fall.</h3>
Jag var tvungen att byta lösning när jag först försökte använda en enkel array för att hantera spelarens inventarie.
Jag insåg snart att en ArrayList skulle vara en bättre lösning eftersom den ger mer flexibilitet och dynamisk storlek,
vilket gör det enklare att lägga till och ta bort föremål från inventariet.

<h3>Vad gick bra</h3>
Implementeringen av Shop- och Item-klasserna gick smidigt,
och jag lyckades skapa en fungerande butik där spelaren kan interagera med föremålen på ett enkelt och intuitivt sätt.

<h3>Vad gick dåligt</h3>
Github Desktop kronglade och ville inte inkuldera min workspace-fil i mina git pull-operationer.

<h3>Vad har du lärt dig</h3>

Jag har lärt mig att använda konsolen för att pusha upp mina koder istället för att lita på GitHub Desktop.
Jag har även förbättrat min felsökningsförmåga och lärt mig att snabbt identifiera och lösa problem i koden.

<h3>Vilka möjligheter ser du med de kunskaper du fått under kursen.</h3>

Med de kunskaper jag fått under kursen ser jag möjligheter att bygga mer komplexa program.
Jag har lärt mig att arbeta och kompromissa i ett team, och jag har lärt mig att skriva kod som är lätt att
förstå och lätt att förbättra.
