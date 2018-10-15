package test;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import unlam.edu.le.LlenarEstanque;

class TestLlenandoEstanque {
	private String in = "src/test/LotesDePrueba/Entrada/";
	private String out = "src/test/LotesDePrueba/Ejecucion/";
	
	@Test
	public void llenarHastaTuberia() {
		LlenarEstanque control = new LlenarEstanque();
		
		control.addEstanque(120, 7, 4);
		control.addEstanque(80, 10, -1);
		control.setVolumen(360);
		Assert.assertEquals(0, control.llenar());
	}
	
	@Test
	public void llenarHastaTuberiaIzquierda() {
		LlenarEstanque control = new LlenarEstanque();
		
		control.addEstanque(120, 7, 4);
		control.addEstanque(80, 10, -1);
		control.setVolumen(600);
		Assert.assertEquals(0, control.llenar());
	}
	
	@Test
	public void llenarDosEstanquesCompletos() {
		LlenarEstanque control = new LlenarEstanque();
		
		control.addEstanque(120, 7, 4);
		control.addEstanque(80, 10, -1);
		control.setVolumen(1640);
		Assert.assertEquals(0, control.llenar());
	}
	
	@Test
	public void llenarTresEstanques() {
		LlenarEstanque control = new LlenarEstanque();
		
		control.addEstanque(120, 7, 4);
		control.addEstanque(80, 10, 2);
		control.addEstanque(60, 5, -1);
		control.setVolumen(1640);
		Assert.assertEquals(0, control.llenar());
	}

	@Test
	void prueba01CasoEjemplo01() throws FileNotFoundException {
		LlenarEstanque control = new LlenarEstanque(in + "01_CasoEjemplo1.in");
		control.llenar();
		control.escribirArchivo(out + "01_CasoEjemplo1.out");
	}
	
	@Test
	void prueba02CasoEjemplo02() throws FileNotFoundException {
		LlenarEstanque control = new LlenarEstanque(in + "02_CasoEjemplo2.in");
		control.llenar();
		control.escribirArchivo(out + "02_CasoEjemplo2.out");
	}
	
	@Test
	void prueba03UnEstanque() throws FileNotFoundException {
		LlenarEstanque control = new LlenarEstanque(in + "03_UnEstanque.in");
		control.llenar();
		control.escribirArchivo(out + "03_UnEstanque.out");
	}
	
	/*@Test
	void prueba04EstanquesDeIgualesDimensiones() throws FileNotFoundException {
		LlenarEstanque control = new LlenarEstanque(in + "04_EstanquesDeIgualesDimensiones.in");
		control.llenar();
		control.escribirArchivo(out + "04_EstanquesDeIgualesDimensiones.out");
	}*/
}
