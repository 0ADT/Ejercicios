package codigo;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListaDeChicos {
	private List<String> nombres;
	private int cantidadDeRepetidos;
	
	public int getCantidadDeRepetidos() {
		return cantidadDeRepetidos;
	}

	public ListaDeChicos(List<String> lista, int cantidadDeRepetidos) {
		nombres = lista;
		this.cantidadDeRepetidos = cantidadDeRepetidos;
	}
	
	public Set<Nombre> devolverMasRepetidos(){
		Set<Nombre> nombresRepetidos = new TreeSet<>();
		int contador = 1;
		
		Collections.sort(nombres);
		
		String nomActual = nombres.get(0);
		
		for(int i = 1; i <= nombres.size(); i ++) {
			if(i < nombres.size() && nomActual.equals(nombres.get(i))) 
				contador ++;
			else
			{
				nombresRepetidos.add(new Nombre(nomActual, contador));
				
				if(i < nombres.size())
					nomActual = nombres.get(i);
				
				contador = 1;
			}
		}
		
		Set<Nombre> nomDevueltos = new TreeSet<>();
		int i = 0;
		
		for(Nombre nom : nombresRepetidos) {
			nomDevueltos.add(nom);
			
			if(i >= cantidadDeRepetidos - 1)
				break;
			
			i ++;
		}
		
		return nomDevueltos;
	}
}
