# Studentenverwaltung

Dieses Projekt ist zur Bearbeitung der JavaFX-Aufgabe (HttpClient) erstellt worden.

## Starten der Anwendung

### Docker

- Das Backend kann über [DockerHub](https://hub.docker.com/r/moinmarcell/backend) bezogen werden

### Ansonsten

- Das Projekt forken und in IntelliJ öffnen
- `MONGODB_URI` in der `application.properties` anpassen oder als Umgebungsvariable setzen
- Die Anwendung kann dann gestartet werden

## Übersicht der Endpunkte

- `GET /api/students` - Gibt alle Studenten zurück
    - Query Parameter:
        - `courseOfStudies` - Filtert die Studenten nach Studiengang
        - `firstName` - Filtert die Studenten nach Vornamen
        - `lastName` - Filtert die Studenten nach Nachnamen
    - Query Parameter können nicht kombiniert werden und sind optional
        - `responseBody`:
            ```json
            [
                {
                    "matriculationNumber": "MN-123456",
                    "firstName": "Max",
                    "lastName": "Mustermann",
                    "email": "max@mustermann.de",
                    "courseOfStudies": "Medieninformatik"
                },
                {
                    "matriculationNumber": "MN-123457",
                    "firstName": "Max",
                    "lastName": "Mustermann",
                    "email": "max@mustermann.de",
                    "courseOfStudies": "Medieninformatik"
                }
            ]
            ```
- `POST /api/students` - Fügt einen neuen Studenten hinzu
    - Request
      Body: `{"firstName": "Max", "lastName": "Mustermann", "email": "max@mustermann.de", "courseOfStudies": "Medieninformatik"}`
    - Status Code: `201 Created`
        - `responseBody`:
            ```json
            {
                "matriculationNumber": "MN-123456",
                "firstName": "Max",
                "lastName": "Mustermann",
                "email": "max@mustermann.de",
                "courseOfStudies": "Medieninformatik"
            }
            ```
- `DELETE /api/students/{matriculationNumber}` - Löscht einen Studenten anhand der Matrikelnummer
    - Status Code: `204 No Content`
- `PUT /api/students/{matriculationNumber}` - Aktualisiert einen Studenten anhand der Matrikelnummer
    - Request
      Body: `{"firstName": "Max", "lastName": "Mustermann", "email": "max@mustermann.de", "courseOfStudies": "Medieninformatik"}`
    - Status Code: `200 OK`
        - `responseBody`:
            ```json
            {
                "matriculationNumber": "MN-123456",
                "firstName": "Max",
                "lastName": "Mustermann",
                "email": "max@mustermann.de",
                "courseOfStudies": "Medieninformatik"
            }
            ```
- `GET /api/students/{matriculationNumber}` - Gibt einen Studenten anhand der Matrikelnummer zurück
    - `responseBody`:
        ```json
        {
            "matriculationNumber": "MN-123456",
            "firstName": "Max",
            "lastName": "Mustermann",
            "email": "max@mustermann.de",
            "courseOfStudies": "Medieninformatik"
        }
        ```
- `GET /api/students/search` - Gibt den ersten Studenten zurück, der den Suchparametern entspricht
    - Query Parameter:
        - `firstName`
        - `lastName`
    - Query Parameter sind pflicht
    - Beispiel: `GET /students/search?firstName=Max&lastName=Mustermann`
        - `responseBody`:
            ```json
              {
                    "matriculationNumber": "MN-123456",
                    "firstName": "Max",
                    "lastName": "Mustermann",
                    "email": "max@mustermann.de",
                    "courseOfStudies": "Medieninformatik"
              }
            ```
- Wenn ein einzelner Student nicht gefunden wird, wird ein `404 Not Found` zurückgegeben
- `firstName` und `lastName` sind Pflichtfelder und müssen mindestens 2 Zeichen lang sein und dürfen nur aus Buchstaben
  bestehen
- `email` ist ein Pflichtfeld und muss eine Valide E-Mail-Adresse sein
- `courseOfStudies` ist ein Pflichtfeld und darf nur Buchstaben und Zahlen enthalten