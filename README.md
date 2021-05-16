# NWT_AMTEAM
NWT Project 2020

# Upute za pokretanje aplikacije:

1. Instalirati PostgreSQL, verzija 12 (https://www.postgresql.org/download/)

2. Instalirati pgAdmin, verzija 4 (https://www.pgadmin.org/download/)

3. Kreirati sljedeće baze u pgAdmin sa šifrom "1234": NWT_Management_Microservice_DB, NWT_Messaging_Microservice_DB, NWT_Request_Microservice_DB, NWT_Rating_Microservice_DB

4. Otvoriti projekat "eurekaserver" i pokrenuti "EurekaserverApplication"

5. Otvoriti projekat "managementmicroservice" i pokrenuti "ManagementmicroserviceApplication"

6. Otvoriti projekat "messagingmicroservice" i pokrenuti "MessagingmicroserviceApplication"

7. Otvoriti projekat "ratingmicroservice" i pokrenuti "RatingmicroserviceApplication"

8. Otvoriti projekat "requestmicroservice" i pokrenuti "RequestmicroserviceApplication"

# Napomena

Kontroleri i servisi "Client", "Instructor" i "Subject" se nalaze u "managementmicroservice" projektu i tu su testirani. Za dodavanje (slanje zahtjeva) pobrojanih klasa koristiti port "managementmicroservice" projekta. Pobrojani kontoleri i servisi se nalaze i u ostalim projektima zbog lokalnog testiranja unutar zasebnih mikroservisa, te endpointi koje sadrže nisu namijenjeni da se koriste osim u "managementmicroservice" mikroservisu.
