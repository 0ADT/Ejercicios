El problema consiste en encontrar una distribucion de N reinas sobre un tablero de ajedrez de NxN casillas de manera tal que no se ataquen entre si. No pueden encontrarse mas de una reina en la misma fila, columna o diagonal.
La posicion de la reina esta dada por un par de numeros que indican la fila y la columna.
En este caso interesa saber, a partir de un conjunto de reinas, cuantos conflictos interviene cada reina y cuales son esos conflictos.

Datos de entrada:
Una linea con dos numeros N (1 <= N <= 10.000) que indica las dimensiones del tablero y M (1 <= 50.000) que indica la cantidad de reinas sobre el tablero.
M lineas con dos numeros F(fila) y C (columna) indicando donde se encuentra la reina (1 <= F, C <= N).

Datos de salida:
M lineas, una por cada reina respetando el orden, con un numero K (0 <= K <= M) que indica en cuantos conflictos participa esa reina seguidos de K numeros, ordenados de menor a mayor, que indicaran los numeros de reinas con los que existe conflicto.