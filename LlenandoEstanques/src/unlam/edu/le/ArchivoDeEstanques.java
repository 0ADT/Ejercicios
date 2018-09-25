package unlam.edu.le;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoDeEstanques {
	public static List<Estanque> leerArchivo(String ruta) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		List<Estanque> estanques = new ArrayList<Estanque>();
		int cantidadDeEstanques = sc.nextInt();
		
		for(int i = 0; i < cantidadDeEstanques - 1; i ++)
			estanques.add(new Estanque(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		//es el ultimo estanque
		estanques.add(new Estanque(sc.nextInt(), sc.nextInt(), 0));
		estanques.get(estanques.size() - 1).setEsUltimoEstanque(true);

		//seteo al primer estanque el volumen total
		estanques.get(0).setVolumenTotal(sc.nextInt());
		
		sc.close();
		return estanques;
	}
	
	public static void escribirArchivo(String ruta, ArrayList<Estanque> estanques) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(ruta));
		
		if(estanques.get(0).getVolumenTotal() > 0) 
			pw.print("Hay desborde: " + estanques.get(0).getVolumenTotal());
		else {
			int estanquesTotales = estanques.get(0).getEstanquesTotales(); 
			
			pw.println(estanquesTotales);
			
			for(int i = 0; i < estanquesTotales;) {
				pw.print(++ i + " ");
				pw.println(estanques.get(i - 1).getProfundidadMedida());
			}
		}
		
		pw.close();
	}
}
