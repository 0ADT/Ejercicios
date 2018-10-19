package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import codigo.ArchivoNombres;
import codigo.ListaDeChicos;

class PruebaNombres {

	@Test
	void test() throws FileNotFoundException {
		ListaDeChicos listado = ArchivoNombres.cargarArchivo("pruebas/Entrada/01_CasoEnunciado.in");
		ArchivoNombres.imprimir("pruebas/Ejecucion/01_CasoEnunciado.out", listado.devolverMasRepetidos());
	}

}
