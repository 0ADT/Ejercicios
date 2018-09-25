package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unlam.edu.le.ArchivoDeEstanques;
import unlam.edu.le.Estanque;

class TestLlenandoEstanque {
	private String in = "src/test/LotesDePrueba/Entrada/";
	private String out = "src/test/LotesDePrueba/Ejecucion/";

	@Test
	void prueba01CasoEjemplo01() throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList(ArchivoDeEstanques.leerArchivo(in + "01_CasoEjemplo1.in"));

		ArchivoDeEstanques.escribirArchivo(out + "01_CasoEjemplo1.out", Estanque.calcularVolumen(estanques));
	}
	
	@Test
	void prueba02CasoEjemplo02() throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList(ArchivoDeEstanques.leerArchivo(in + "02_CasoEjemplo2.in"));
	
		ArchivoDeEstanques.escribirArchivo(out + "02_CasoEjemplo2.out", Estanque.calcularVolumen(estanques));
	}
	
	@Test
	void prueba03UnEstanque() throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList(ArchivoDeEstanques.leerArchivo(in + "03_UnEstanque.in"));

		ArchivoDeEstanques.escribirArchivo(out + "03_UnEstanque.out", Estanque.calcularVolumen(estanques));
	}
	
	@Test
	void prueba04EstanquesDeIgualesDimensiones() throws FileNotFoundException {
		ArrayList<Estanque> estanques = new ArrayList(ArchivoDeEstanques.leerArchivo(in + "04_EstanquesDeIgualesDimensiones.in"));

		ArchivoDeEstanques.escribirArchivo(out + "04_EstanquesDeIgualesDimensiones.out", Estanque.calcularVolumen(estanques));
	}
}
