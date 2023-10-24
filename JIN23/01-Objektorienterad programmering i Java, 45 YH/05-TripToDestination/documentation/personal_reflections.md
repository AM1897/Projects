# Projektrapport: [Ditt Namn]

## Projektet

### Beskrivning av projektet

Projektet handlar om att jämföra bränsleförbrukning och kostnader mellan olika typer av fordon - bil, motorcykel och lastbil - på en bestämd rutt, i det här fallet till Malmö.

### Vad du har gjort

Jag har skapat en Java-applikation som kalkylerar bränsleförbrukning och kostnader baserat på fasta värden för avstånd och bränslepris, samt variabla värden som definieras för varje fordonstyp.

## Planering

### Lösningsförslag innan uppgiften påbörjas

Jag planerade att skapa en huvudklass `Vehicle` och sedan ärva den för att skapa specifika klasser för varje fordonstyp. Jag valde också att använda Maven som ett byggverktyg för att hantera beroenden och byggprocessen.

### Jira/Trello och projekthantering enligt Scrum/Kanban

Eftersom detta är en förenklad version av projektet har jag inte använt Jira eller Trello. Men om jag skulle skala upp detta, skulle jag ha använt Trello för att spåra uppgifter, och jag skulle ha använt Scrum-metoden för att fördela arbetsbördan över tid.

## Arbetet och dess genomförande

### Vad som varit svårt

Ett av de mest utmanande delarna var att bestämma en realistisk bränsleförbrukning för varje fordonstyp baserat på deras hastighet.

### Beskriv lite olika lösningar du gjort

Jag skapade en `getFuelEfficiency` metod i varje subklass som beräknar bränsleförbrukningen baserat på fordonets maxhastighet.

### Beskriv något som var besvärligt att få till

Att bestämma hur man bäst skulle modellera varje fordon var lite knepigt, särskilt när man tänker på skalbarhet för framtida tillägg av fler fordonstyper.

### Beskriv om du fått byta lösning och varför i sådana fall

Initialt hade jag tänkt att hårdkoda varje fordons bränsleförbrukning, men jag insåg att det skulle vara mer dynamiskt och skalbart att beräkna det baserat på andra faktorer, som maxhastighet.

## Reflektion & Slutsatser

### Vad gick bra

Arvet och polymorfismen fungerade bra och gav en ren och skalbar lösning. dlfkaertopkfåpgkparekgakrgraogaåogrojgoaergofadkogmaodfkg.

### Vad gick dåligt

Mina initiala antaganden om bränsleförbrukning var inte realistiska, så jag behövde göra några ändringar under projektets gång.

### Vad har du lärt dig

Jag har lärt mig vikten av att noggrant planera och tänka igenom designbeslut från början för att undvika större förändringar längs vägen.

### Vad hade du gjort annorlunda om du gjort om projektet

Jag skulle kanske ha lagt till fler fordonsattribut, som vikt eller motortyp, för att göra bränsleförbrukningsberäkningarna ännu mer realistiska.

### Vilka möjligheter ser du med de kunskaper du fått under kursen

Jag ser många möjligheter att skapa mer komplexa och realistiska applikationer med de kunskaper jag har fått. Speciellt inom området för transport och logistik där sådana beräkningar kan vara mycket värdefulla.

## VG

### Motivera varför du valt en specifik lösning

Jag skulle kanske ha lagt till fler fordonsattribut, som vikt eller motortyp, för att göra bränsleförbrukningsberäkningarna ännu mer realistiska.


### Lämna förslag på förbättringar av din kod

Jag skulle kanske ha lagt till fler fordonsattribut, som vikt eller motortyp, för att göra bränsleförbrukningsberäkningarna ännu mer realistiska.


### Lämna exempel på lösningar du valde att **inte** implementera

Jag skulle kanske ha lagt till fler fordonsattribut, som vikt eller motortyp, för att göra bränsleförbrukningsberäkningarna ännu mer realistiska.


### Lämna förslag på förbättringar av din UI/UX design eller reflektera över den

Jag skulle kanske ha lagt till fler fordonsattribut, som vikt eller motortyp, för att göra bränsleförbrukningsberäkningarna ännu mer realistiska.


