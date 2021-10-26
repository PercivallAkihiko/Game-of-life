# Progetto

Wator è un automa cellulare che descrive il comportamento di un ecosistema vero e proprio.
All'interno dell'automa coesistono 2 specie animali: squali e pesci.
La prima è predatrice e mangia la seconda.
Sia gli squali che i pesci vivono, si spostano, si riproducono e muoiono in Wa-Tor ognuni specie con le sue regole.
I pesci solo se vengono mangiati (sono quindi virtualmente eterni) mentre gli squali se non mangiano per un certo periodo di tempo (detti crononi) muore per inedia.

L'equilibrio dell'ecosistema è molto delicato: le popolazioni delle due specie seguono andamenti ciclici molto violenti in cui si passa dal rischio estinzione per una delle due all'abbondanza di entrambe. Wa-Tor simula infatti, nel suo piccolo, ciò che accade realmente in natura mostrando l'evoluzione delle popolazioni di una specie animale e del suo predatore naturale ed il legame che le vincola.
Quando le prede sono numerose, anche i predatori proliferano ed aumentano di numero. Ma all'aumento di questi ultimi, aumenta il numero di prede cacciate per cui la popolazione di queste diminuisce. Facendosi più rare le prede, i predatori cominciano a soffrire la fame e morire di inedia diminuendo di numero ed alleggerendo la pressione venatoria sulla prede. Queste possono così tornare a proliferare e ad aumentare nuovamente di numero ed i predatori, trovando rinnovata abbondanza di cibo, ricominciano ad aumentare anch'essi.

Wa-Tor è rappresentato da una matrice rettangolare. Ogni cella può essere vuota oppure contenere un pesce/squalo.
Tutte le attività si svolgono secondo quanti di tempo, per ogni tempo la griglia si aggiorna e sia squali che pesci compiono le lorot attività

#REGOLE PESCI
1) Ad ogni quanto di tempo, i pesci si muovono casualmente in una delle caselle adiacenti, ammesso che ve ne sia una libera, cioè priva di squali e pesci al suo interno. Se non vi sono caselle libere non avviene alcun movimento.

2) I pesci hanno associato un tempo di riproduzione, passato il quale il pesce si può riprodurre, Questo accade se il pesce può muoversi in una nuova posizione (e lascia il nuovo nato nella posizione occupata precedentemente). Se ciò accade il suo tempo di riproduzione ritorna a zero. 

#REGOLE SQUALI
1) Ad ogni cronone, gli squali si muovono casualmente in una delle caselle adiacenti occupate dai pesci. Se non ve ne sono si muovono in una casella casuale fra quelle adiacenti purché non vi siano squali al suo interno. Se nessuna casella soddisfa i requisiti non avviene alcun movimento.

2) Ad ogni turno gli squali sono privati di una unità di energia.

3) Se si muove in una casella occupata da un pesce, lo squalo lo mangia e guadagna una certa quantità di energia.

4) Se l'energia supera una certa soglia riproduttiva, lo squalo dà vita ad un altro squalo in una cella libera adiacente, purché ve ne sia una. In tal caso, la sua energia è divisa a metà con la prole.

5) Se il livello energetico di uno squalo è inferiore a zero, lo squalo muore.
