Los estanques tienen una base S y una profundidad P. Cada estanque tiene una tuberia que conecta al otro estanque a una profundidad p'.
Se empieza llenando el primer estanque, si alcanza la tuberia, el liquido pasará al siguiente estanque.

Datos de entrada.
-Primer linea: tiene la cantidad N de estanques (1 <= N <= 100.000).
-Las siguientes N - 1 lineas contienen la superficie de la base S (1 <= S <= 400) en m2, la profundidad P (1 <= P <= 100) expresada en metros y la profundidad del unico caño que tiene (P(estanque + 1) > P(caño)) (1 <= P(caño) <= P(estanque)) medido desde la superficie, los tres valores estan separados por un blanco.
-Anteultima linea: tiene la superficie S y la profundidad P del ultimo estanque.
-Ultima linea: tiene el volumen a ingresar de liquido (1 <= V <= 1.000.000) expresada en m3.
*Todos los valores son enteros.

Datos de salida.
a) Si hay desborde: Imprimir "Hay desborde: " y la cantidad de m3 que rebasarian.
b) Si no hay desborde: -Primer linea: cantidad C de estanques con agua.
-C lineas indicando el numero de estanque y la profundidad medidad desde el fondo del estanque hasta el nivel de agua, expresada en metros con los decimales truncados.
