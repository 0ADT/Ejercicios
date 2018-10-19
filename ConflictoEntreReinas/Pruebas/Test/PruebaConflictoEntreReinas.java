package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.unlam.tpa.ArchivoDeReinas;
import edu.unlam.tpa.Reina;

class PruebaConflictoEntreReinas {
	private static String in = "Pruebas/LotesDePrueba/Entrada/";
	private static String out = "Pruebas/LotesDePrueba/Ejecucion/";
	
	@Test
	void CasoEjemplo1() throws IOException {
		ArrayList<Reina> reinas = new ArrayList<>();
		
		reinas = ArchivoDeReinas.leer(in + "01_CasoEjemplo1.in");
		
		for(Reina i : reinas) {
			i.conflicto(reinas);
		}
		
		ArchivoDeReinas.escribir(reinas, out + "01_CasoEjemplo1.out");
	}
	
	@Test
	void CasoEjemplo2() throws IOException {
		ArrayList<Reina> reinas = new ArrayList<>();
		
		reinas = ArchivoDeReinas.leer(in + "02_CasoEjemplo2.in");
		
		for(Reina i : reinas) {
			i.conflicto(reinas);
		}
		
		ArchivoDeReinas.escribir(reinas, out + "02_CasoEjemplo2.out");
	}
	
	@Test
	void ConflictoConUnaReinaEnMismaDiagonal() throws IOException {
		ArrayList<Reina> reinas = new ArrayList<>();
		
		reinas = ArchivoDeReinas.leer(in + "03_ConflictoConUnaReinaEnMismaDiagonal.in");
		
		for(Reina i : reinas) {
			i.conflicto(reinas);
		}
		
		ArchivoDeReinas.escribir(reinas, out + "03_ConflictoConUnaReinaEnMismaDiagonal.out");
	}
	
	@Test
	void CasoFatiga() throws IOException {
		ArrayList<Reina> reinas = new ArrayList<>();
		
		reinas = ArchivoDeReinas.leer(in + "04_casoFatiga.in");
		
		for(Reina i : reinas) {
			i.conflicto(reinas);
		}
		
		ArchivoDeReinas.escribir(reinas, out + "04_casoFatiga.out");
	}
}
