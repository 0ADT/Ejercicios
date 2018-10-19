package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArchivoNombres {
	public static ListaDeChicos cargarArchivo(String dir) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(dir));
		List<String> nombres = new ArrayList<>();
		int cantNombres = sc.nextInt();
		int cantidadDeRepetidos = sc.nextInt();
		
		sc.nextLine();
		
		for(int i = 0; i < cantNombres; i ++)
			nombres.add(sc.nextLine());
		
		sc.close();
		return new ListaDeChicos(nombres, cantidadDeRepetidos);
	}
	
	public static void imprimir(String dir, Set<Nombre> nom) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(dir));
		
		for(Nombre nombre : nom)
			pw.println(nombre);
		
		pw.close();
	}
}
