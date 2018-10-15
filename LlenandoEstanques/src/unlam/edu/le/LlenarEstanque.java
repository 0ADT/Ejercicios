package unlam.edu.le;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LlenarEstanque {
	private List<Estanque> estanques;
	private int volumenTotal;
	private int estanquesCargados = 0;
	
	public LlenarEstanque() {
		estanques = new ArrayList<>();
	}
	
	public LlenarEstanque(String dir) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(dir));
		estanques = new ArrayList<Estanque>();
		int cantidadDeEstanques = sc.nextInt();
		
		for(int i = 0; i < cantidadDeEstanques - 1; i ++) {
			this.addEstanque(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		//es el ultimo estanque
		this.addEstanque(sc.nextInt(), sc.nextInt(), -1);
		setVolumen(sc.nextInt());
		
		sc.close();
	}
	
	public void addEstanque(int superficie, int profundidad, int profundidadTuberia) {
		estanques.add(new Estanque(superficie, profundidad, profundidadTuberia));
		
		if(estanques.size() > 1) {
			estanques.get(estanques.size() - 1).setVolumenTuberiaIzquierda(estanques.get(estanques.size() - 2).getProfundidadTuberia());
		}
	}
		
	public void llenarAtras(int indice) {
		Estanque estanqueActual = estanques.get(indice);
		int profundidadPorDerecha = estanqueActual.getProfundidadTuberia() == -1 ? 
				estanqueActual.getProfundidadMedida() : estanqueActual.getProfundidadTuberia();
		int superficieTotal = estanqueActual.getSuperficie();
		int volumenActual;
		boolean llenar = false;
		
		for(int i = indice - 1; i >= 0; i --) {
			superficieTotal += estanques.get(i).getSuperficie();
			volumenActual = estanques.get(i).getVolumenTuberiaIzquierda();
			
			if(volumenActual > 0 || volumenActual == -1) 
				llenar = true;
			
			if(llenar) {
				int profundidadDistribuida = (int) Math.round((double)volumenTotal / (double)superficieTotal);
				
				if(profundidadDistribuida <= profundidadPorDerecha)
					for(; i <= indice; i ++)
						volumenTotal -= estanques.get(i).llenarHastaNivel(profundidadDistribuida);
				else
					for(; i <= indice; i ++)
						volumenTotal -= estanques.get(i).llenarHastaNivel(profundidadPorDerecha);
				
				llenar = false;
				
				if(volumenActual == -1 || volumenTotal <= 0)
					break;
			}
		}
	}
	
	public int llenar() {
		Estanque estanque;
		
		for(int i = 0; i < estanques.size() && volumenTotal > 0; i ++) {
			estanque = estanques.get(i);
			volumenTotal = estanque.llenar(volumenTotal);
			estanquesCargados ++;
			
			if(estanque.getVolumenTuberiaIzquierda() == 0)
				llenarAtras(i);
		}
		
		if(volumenTotal <0)
			volumenTotal = 0;
		
		return this.volumenTotal;
	}
	
	public void setVolumen(int vol) {
		this.volumenTotal = vol;
	}
	
	public void escribirArchivo(String dir) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(dir));
		
		if(volumenTotal > 0) 
			pw.print("Hay desborde: " + volumenTotal);
		else {			
			pw.println(estanquesCargados);
			
			for(int i = 0; i < estanquesCargados;) {
				pw.print(++ i + " ");
				pw.println(estanques.get(i - 1).getProfundidadMedidaDesdeFondo());
			}
		}
		
		pw.close();
	}
}
