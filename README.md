# TeamPAPC-C3

Repository del progetto C3 sviluppato per l'esame di [Ingegneria del Software](http://didattica.cs.unicam.it/doku.php?id=didattica:triennale:ids:ay_2021:main) per il terzo anno di [informatica](http://didattica.cs.unicam.it/doku.php?id=didattica:triennale:main) dell'università [UNICAM](https://www.unicam.it).
Sviluppato da:
- Ludovico Latini ludovico.latini@studenti.unicam.it
- Yuri Monti yuri.monti@studenti.unicam.it
- Gianmarco Verrucci gianmarco.verrucci@studenti.unicam.it

# Specifiche progetto

Il progetto è formato da un backend e da un frontend entrambi presenti in repository github [backend](https://github.com/Lambru99/teamPAPC-C3) [frontend](https://github.com/yurimonti/C3RestIonic).
Il backend è stato sviluppato seguendo la progettazione precedentemente fatta tramite il software [Visual Paradigm](https://www.visual-paradigm.com/), attualmente implementa il framework [Springboot](https://spring.io/projects/spring-boot). Il backend si appoggia ad un database locale creato tramite [Xampp](https://www.apachefriends.org/it/index.html) chiamto "c3".
Per il frontend è stato utilizzato il framework [Ionic](https://ionicframework.com/). Il frontend è stato scritto in HTML SCSS TypeScript e JavaScript. Esso si interfaccia con il backend tramite chiamte rest.

# How To

Per poter provare l'intero programma bisogna:

- Scaricare Xampp ed avviarlo.
- Recarsi [qui](http://localhost/phpmyadmin/).
- Creare un database di nome "c3".
- Avviare il backend tramite "gradle bootrun".
- Scaricare nodejs ed avviarlo.
- Scaricare il framework ionic.
- Avviare il frontend tramite il comando "ionic serve".

Una volta avviato il frontend ionic aprirà da solo la pagina principale del progetto e da quel momento si potrà inizia ad utilizzare C3. Nel database sono precaricati dei dati di prova.
