## Il segreto del piano -2

## Gruppo: Flavio Valerio, Andrea Romano, Antonio Pallara

# Indice:
    Capitolo 1 - Descrizione tecnica:
        - Architettura del software
        - Diagramma delle classi
        - Specifica algebrica
        - Strutture implementate
    
    Capitolo 2 - Il segreto del piano -2:
        - Descrizione del gioco 
        - La storia
        - La mappa
        - Obiettivo del gioco
        - Imprevisti
        - Comandi disponibili
        - Soluzioni agli imprevisti
#

# Capitolo 1 - Descrizione Tecnica
## Architettura del Software
> ### Il programma è completamente scritto in Java. Il software è gestito tramite pacchetti allo scopo di aumentarne la modularità, ne consegue maggiore riusabilità, inoltre assolve allo scopo di rendere il codice più comprensibile. In ogni pacchetto ci possono essere più pacchetti con i relativi metodi. I dati relativi alle partite e ai giocatori sono conservati all’interno di un database mySQL. È stato implementato un sistema client-server per la gestione dei file relativi ai sinonimi dei verbi, questo ha lo scopo di poter implementare futuri aggiornamenti a questi file e se necessario il client provvederà a scaricarne una nuova versione anche nel caso in cui i file che non possiede possano essere integrati in maniera trasparente all’utente.
# 

## Diagramma delle classi
> ### Mostra il Server e il FileManager, dove quest'ultimo attraverso la rete è in grado di contattare il server e di ricevere, ovvero farsi inviare dal server, i file che sono rilevati come assenti nella cartella *resourceFiles*
![Diagramma della classe fileManager](/documentazione/fileManager_diagramma.jpg)

![Diagramma del package server](/documentazione/package_server_diagramma.jpg)
#

## Specifica algebrica
> ### Di seguito riportiamo le specifiche sintattiche e semantiche del dato astratto Lista.

    > Specifica Sintattica: 
    Tipi: Lista, Boolean, Posizione, Tipoelem, Int

    Operazioni:

        CreaLista () -> Lista
        InsLista (Lista, Posizione, Tipoelem) -> Lista
        CancLista (Lista, Posizione) -> Lista
        ListaVuota (Lista) -> Boolean
        ListaContElem (Lista, Tipoelem) -> Boolean
        DimLista (Lista) -> Int

    > Specifica Semantica:
    Data la lista List, la posizione p e l'elemento elem

        ListaVuota (CreaLista()) = true
        ListaVuota (InsLista (List, p, elem)) = false
        CancLista (InsLista (List, p, elem), p) = List
        ListaContElem (CreaLista(), elem) = false
        ListaContElem (InsLista (List, p, elem), elem) = true
        DimLista (InsLista (List, p, elem)) = DimLista (List) + 1
        DimLista (CreaLista()) = 0;

    Restrizioni:
        CancLista (CreaLista(), p) = error
#
#
## Strutture implementate
> ### Il progetto poggia le sue basi sui principi della programmazione ad oggetti, di seguito una breve analitica:
    - NPC
    - Oggetti
    - Stanze
    - Verbi
    - Pareser
    - Mappa
#

## Uso dei file
> #### I file sono stati utilizzati per la gestione di tutti i sinonimi dei verbi, mentre per gli NPC, stanze e oggetti sono stati usati i file JSON
#

## GUI
> ### L’interfaccia grafica è stata gestita mediante JavaSWING. Seppur l'avventura sia vissuta attraverso console, è stata data la possibilità all'utente di utilizzare il telefono del protagonista. Dal telefono sarà possibile:
* visualizzare la mappa di gioco
* aprire la fotocamera per vedere la stanza attuale
* riprodurre la canzone preferita dal protagonista
* leggere una guida ai commandi di gioco
#

## Espressioni Lambda
> All'interno della classe JsonReader ho utilizzato una lambda expression, quale:
"inputList=IntStream.range(0, inputArray.length).mapToObj(k -> inputArray[k]).collect(Collectors.toList());"
Attraverso essa è possibile estrarre dal campo Execute di ciascun npc una lista di input per ogni corrispettivo output, per l'interazione  coi diversi personaggi del gioco applicando una funzione di mapping a ogni elemento dello stream.
#

## Socket 
> ### Sono stati usati per la creazione del servizio di invio e ricezione dei file. In Particolare esistono due classi che si occupano di verificare se i file che si possiede sono esistenti, in caso di assenza contatta il server richiedendoli, quest'ultimo invia solo quelli chiesti.
Si specifica che in un piano reale, il server sarebbe stato esterno al progetto, ma lo abbiamo inserito all'interno per effettuare questa "simulazione".
#

## Thread
> ### Abbiamo deciso di implementare i thread per avviare la riproduzione della musica di sottofondo che è possibile richiamare attraverso lo strumento telefono. 
I thread, sono inoltre utlizzati per elegare il servizo di invio dei files del server, il quale cosi può rimanere in ascolto sulla sua porta.
#
#

# Capitolo 2 - Il segreto del piano -2
## Descrizione del gioco
> ### Il gioco è basato sulla filosofia dell'avventura testuale, prevede un personaggio che interpreta se stessi. Per arrivare alla fine del gioco il giocatore deve muoversi all’interno delle strutture del palazzo del Dipartimento di Informatica dell’Università di Bari. Il personaggio si troverà ad affrontare piccoli e semplici indovinelli che lo faranno proseguire nella storia. Inoltre per varcare alcuni ambienti saranno necessari alcuni oggetti e comunque la storia non potrà proseguire finché il giocatore non si trova ad affrontare la storyline nella maniera corretta.
#

## La storia
> ### Il gioco si apre nell’atrio che congiunge il Palazzo delle Aule al Dipartimento, il giocatore potrà spostarsi all’interno del Dipartimento, dove troverà dei personaggi con cui interloquire. Spostandosi all’interno degli ambienti si verrà a conoscenza di inquietanti storie e verità che accadono all’interno di quelle mura. 
> ### Il protagonista si troverà a dover scoprire cosa si cela dietro i comportamenti inusuali degli studenti per poi venire a conoscenza di nemici che lo intralceranno durante il percorso. 
> ### Alla fine del gioco il personaggio si troverà a dover affrontare scelte che lo metteranno in condizioni di scegliere tra la vita e la morte. 
> ### Fai la giusta scelta.
#

## La mappa
> ### Gli ambienti del gioco sono di seguito riportati:
    - Spiazzale (atrio esterno tra il Dipartimento e il Palazzo della Aule)
    - Atrio (area di ingresso del Dipartimento)
    - Portineria (si spiega da sola)
    - Museo (area coincidente con l'entrata posteriore del Dipartimento)
    - Corridoio (si psiega da solo)
    - Aula A (si spiega da sola)
    - Aula B (si spiega da sola)
    - Ascensore 
    - Piano 7
    - Ufficio Pippo (l'ufficio del protagonista)
    - Ufficio Lanubile (ufficio del Prof Lanubile)
    - Piano meno uno (piano interrato del Dipartimento)
    - Bagni (si spiegano da soli)
    - Piano meno due (il mistero del gioco88)

#

## Obiettivo del gioco
> ### Il personaggio ha il compito di svelare il segreto di cui gli studenti parlano e di affrontare il più grande nemico del Dipartimento di Informatica.
#

## Imprevisti
> ### Il gioco è mosso da alcuni imprevisti, i quali prevedono dei semplici indovinelli, di cui uno è la citazione di una magistrale opera cinematografica italiana. 
> ### Tutti i quesiti sono abbastanza blasonati e sono accumunati da risposte che devono sfruttare il “pensiero laterale”.
#

## Comandi disponibili
> ### I comandi riconosciuti dal gioco prevendono l'uso dei sinonimi dei seguenti verbi:
    - Osserva
    - Parla
        -> Parla con [nomePersonaggio]
    - Prendi
    - Usa
        -> Usa [nomeOggetto]
    - Vai 
        -> Vai a [direzioneCardinale]
> ### Sotto ogni verbo è espressa una possibile sintassi del comando.
#


