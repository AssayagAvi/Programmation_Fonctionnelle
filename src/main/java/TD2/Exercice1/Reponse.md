##TD 2 Exercice 1 : Interfaces Fonctionnelles
####Question 1 :
Dans le TD1 nous avions implémenter une interface "Sommable"
qui était générique c'est-à-dire que l'on modifié de telle sorte
que qu'importe le type des variables (Integer ,String etc ..) le code soit
executable et fonctionnel.

Ici, à la différence nous utilisons une interface fonctionnelle
instancié par des "lambda" qui sont de mêmes types pour les deux valeur d'entrés :
par exemple (String a , String b) ou (Float a , Float b).

####Question 3 :
Function : Le principe est de prendre un argument de type T en entre et de 
retourne un argument de type U en sortie.
Donc il prend un argument en entrée et retourne un argument d'un autre type en sortie

Predicate : Le principe est de tester un argument en entre selon un critere.
Donc il prend en entree un argument de type T et retourne un boolean (true ou false)

Consumer : Le principe est de prendre un argument de type T et de ne rien retourne il "conosmme" 
seulement la valeur un peu comme une méthode void
Donc il prend un argument de type T en entre et ne retourne rien

Supleir : Le principe est de generer une reposne telle un return.
Donc il ne prend rien en entree et retourne un type T en sortie .