package edu.unlam.tpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reina implements Comparable<Reina>{
	private int posicion;
	private int fila;
	private int columna;
	private int cantidadConflictos;
	private ArrayList<Integer> conflictos = new ArrayList<>();//los casilleros en conflicto
	//solo puede tener un conflicto por columna 
	private boolean conflictoPorColumnaPorArriba = false;
	private boolean conflictoPorColumnaPorAbajo = false;
	//solo puede tener un conflicto por fila
	private boolean conflictoPorFilaPorIzq = false;
	private boolean conflictoPorFilaPorDer = false;
	//solo puede tener un conflicto por diagonal
	private boolean conflictoPorDiagonalSup = false;
	private boolean conflictoPorDiagonalInf = false;
	private boolean conflictoPorAntiDiagonalSup = false;
	private boolean conflictoPorAntiDiagonalInf = false;
	//
	private static boolean esFila = true;
	
	public Reina(int fila, int columna, int posicion)  {
		this.fila = fila;
		this.columna = columna;
		this.posicion = posicion;
		cantidadConflictos = 0;
	}
	
	public ArrayList<Integer> getConflictos(){
		return conflictos;
	}
	
	public void conflicto(List<Reina> queens) {
		List<Reina> reinas = new ArrayList<Reina>();
		
		reinas.addAll(0, queens);
		
		Collections.sort(reinas);
		/*
		 * Ordeno por filas y de paso uso ese orden
		 * para buscar por las diagonales
		 * Para las diagonales debe cumplir con
		 * 1: x1 != x2 y y1 != y2
		 * 2: |x1 - x2| = |y1- y2| 
		 * */
		for(Reina i : reinas) {
			if(!this.equals(i) && this.fila == i.fila) {
				if(!conflictoPorFilaPorDer && this.columna - i.columna < 0) {
					i.conflictoPorFilaPorIzq = true;
					conflictoPorFilaPorDer = true;
					conflictoContra(i);
				}
				else if(!conflictoPorFilaPorIzq && this.columna - i.columna > 0) {
					conflictoPorFilaPorIzq = true;
					i.conflictoPorFilaPorDer = true;
					conflictoContra(i);
				}
			}
			
			if(this.fila != i.fila && this.columna != i.columna) {
				if(Math.abs(this.fila - i.fila) == Math.abs(this.columna - i.columna)) {
					if(this.fila < i.fila && this.columna < i.columna) {
						if(!conflictoPorDiagonalInf && !i.conflictoPorDiagonalSup) {
							conflictoPorDiagonalInf = true;
							i.conflictoPorDiagonalSup = true;
							conflictoContra(i);
						}
					}
					
					if(this.fila < i.fila && this.columna > i.columna) {
						if(!conflictoPorAntiDiagonalInf && !i.conflictoPorAntiDiagonalSup) {
							conflictoPorAntiDiagonalInf = true;
							i.conflictoPorAntiDiagonalSup = true;
							conflictoContra(i);
						}
					}
					
					if(this.fila > i.fila && this.columna < i.columna) {
						if(!i.conflictoPorAntiDiagonalInf && !conflictoPorAntiDiagonalSup) {
							conflictoPorAntiDiagonalSup = true;
							i.conflictoPorAntiDiagonalInf = true;
							conflictoContra(i);
						}
					}	
					
					if(this.fila > i.fila && this.columna > i.columna) {
						if(!i.conflictoPorDiagonalInf && !conflictoPorDiagonalSup) {
							conflictoPorDiagonalSup = true;
							i.conflictoPorDiagonalInf = true;
							conflictoContra(i);
						}
					}	
				}
			}//fin if diagonales
		}//fin for filas
		
		esFila = false;
		Collections.sort(reinas);
		
		for(Reina i : reinas) {
			if(!this.equals(i) && this.columna == i.columna) {
				if(!conflictoPorColumnaPorAbajo && this.fila - i.fila < 0) {
					i.conflictoPorColumnaPorArriba = true;
					conflictoPorColumnaPorAbajo = true;
					conflictoContra(i);
				}
				else if(!conflictoPorColumnaPorArriba && this.fila - i.fila > 0){
					conflictoPorColumnaPorArriba = true;
					i.conflictoPorColumnaPorAbajo = true;
					conflictoContra(i);
				}
			}		
		}//fin for columnas
		
	}
	
	@Override
	public String toString() {
		return cantidadConflictos + conflictos.toString().replaceAll(",", "").replace('[', ' ').replace(']', '\n');
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	private void conflictoContra(Reina otraReina) {
		conflictos.add(otraReina.posicion);
		otraReina.conflictos.add(this.posicion);
		this.cantidadConflictos ++;
		otraReina.cantidadConflictos ++;
	}

	@Override
	public int compareTo(Reina otra) {
		if(esFila) {
			if(this.fila == otra.fila)
				return this.columna - otra.columna;
			else
				return this.fila - otra.fila;
		}
		else {
			if(this.columna == otra.columna)
				return this.fila - otra.fila;
			else
				return this.columna - otra.columna;
		}
	}
}