import re
import sys

def check_markdown_file(filename):
    with open(filename, 'r', encoding='utf8') as file:
        content = file.read()

    headers = [
        '### Beskrivning av projektet',
        '### Vad du har gjort',
        '### Lösningsförslag innan uppgiften påbörjas',
        '### Jira/Trello och projekthantering enligt Scrum/Kanban',
        '### Vad som varit svårt',
        '### Beskriv lite olika lösningar du gjort',
        '### Beskriv något som var besvärligt att få till',
        '### Beskriv om du fått byta lösning och varför i sådana fall',
        '### Vad gick bra',
        '### Vad gick dåligt',
        '### Vad har du lärt dig',
        '### Vad hade du gjort annorlunda om du gjort om projektet',
        '### Vilka möjligheter ser du med de kunskaper du fått under kursen',
    ]

    # A flag to record if there are any problems
    problems = False

    for header in headers:
        # Check if the header exists
        if header not in content:
            print(f'Varning: Rubriken "{header}" saknas.')
            problems = True

        # Check if the header is followed by some text
        else:
            pattern = re.escape(header) + r'\n\n(.*?)(?=\n\n|\Z)'
            match = re.search(pattern, content, re.DOTALL)
            if match:
                answer = match.group(1).strip()
                if not answer:
                    print(f'Varning: Rubriken "{header}" är inte följt av någon text.')
                    problems = True
            else:
                print(f'Varning: Rubriken "{header}" är inte följt av någon text.')
                problems = True

    # If there were any problems, exit with a non-zero code
    if problems:
        sys.exit(1)


check_markdown_file('documentation/personal_reflections.md')
