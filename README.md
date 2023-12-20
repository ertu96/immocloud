# Immocloud coding challange

## Prerequisites
- Docker with docker-compose

## How to run

- run
```shell
make
```

This make script will :
- Create a docker volume for the database
- Build the docker images
- Run the app in docker

## Ports
- The frontend runs on port 5173
- The backend runs on port 8080
- The database runs on port 27017


## Task description
Immocloud ist bei den Bewerbern sehr beliebt. Wir brauchen einen Überblick über die aktuellen Bewerber. Entwickle die passende Web-Anwendung dazu.

### Datenbank
Es läuft eine MongoDB 6 in einem Docker-Container.
Erwartete Dateien:
- Shell Script zum Start der Datenbank
- Optional: Dockerfile
- Authentifizierung ist nicht notwendig

### Backend
- Sprache: Java oder Kotlin
- Framework: Spring Boot (aktuelle Version)
- Erstelle eine REST API, die es ermöglicht Bewerber hinzuzufügen, eine Liste abzurufen (mit optionalen Filtern) und Bewerber anzunehmen/abzulehnen.
- Ein Bewerber besteht aus:
  - Name (Vor- und Nachname)
  - Status: OPEN (default), ACCEPTED, DECLINED
- Die Filter umfassen:
  - Textsuche im Namen
  - Nur bestimmten Status anzeigen
- Authentifizierung ist nicht notwendig

### Frontend
- Sprache: Javascript oder Typescript
- Framework: Vue (aktuelle Version)
- Optional: UI Framework Deiner Wahl
Erstelle folgende UI (Design ist nicht ausschlaggebend):
- Im ersten Textfeld gibt man zum Hinzufügen eines neuen Bewerbers den Namen des Bewerbers ein und klickt auf Hinzufügen. Der Bewerber erscheint ohne Reload in der Tabelle.
- Gibt man einen Text im Namensfilter an, werden nur die Bewerber angezeigt, deren Namen den eingegebenen Text enthalten. Auch hierfür ist kein Reload notwendig.
- Die Checkbox „Abgelehnte Bewerber ausblenden“ ist ebenfalls reaktiv und filtert die Bewerbung auf den Status „OPEN“ oder „ACCEPTED“ bzw. auf „!DECLINED“.
- In der Tabelle hat man für nicht abgelehnte Bewerber die Option diese Anzunehmen oder Abzulehnen. Auch dies geschieht reaktiv.

## Notes
Die Aufgabe wurde vollständig mit Docker Compose umgesetzt, sodass der einzige make command die Container startet.
Die Applikation kann natürlich auch ohne Docker zum Laufen gebracht werden.