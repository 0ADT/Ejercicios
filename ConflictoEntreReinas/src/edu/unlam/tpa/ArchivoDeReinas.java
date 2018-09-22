package edu.unlam.tpa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoDeReinas {
	public static ArrayList<Reina> leer(String ruta) throws FileNotFoundException{
		ArrayList reinas = new ArrayList<Reina>();
		Scanner sc = new Scanner(new FileReader(ruta));
		int dimensionesTablero = sc.nextInt();
		int cantidadDeReinas = sc.nextInt();
		
		for(int i = 0; i < cantidadDeReinas; i ++)
			reinas.add(new Reina(sc.nextInt(), sc.nextInt(), i + 1));
			
		sc.close();
		return reinas;
	}
	
	public static void escribir(ArrayList<Reina> reinas, String ruta) throws IOException {
		PrintWriter pr = new PrintWriter(new FileWriter(ruta));
		
		for(Reina i : reinas)
			pr.print(i);
		
		pr.close();
	}
}
