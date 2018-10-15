package unlam.edu.le;

public class Estanque {
	private int profundidad;
	private int superficie;
	private int profundidadTuberiaDesdeSuperficie;
	private int volumen;
	private int profundidadTuberiaDerecho = -1;
	private int profundidadTuberiaIzquierdo = -1;
	private int profundidadMedida;
	private int volumenHastaTuberiaDerecha = -1;
	private int volumenHastaTuberiaIzquierda = -1;

	public Estanque(int superficie, int profundidad, int profundidadTuberia) {
		this.profundidad = profundidad;
		this.superficie = superficie;
		this.volumen = superficie * profundidad;
		this.profundidadTuberiaDesdeSuperficie = profundidadTuberia;

		if (profundidadTuberia >= 0) {
			this.profundidadTuberiaDerecho = profundidad - profundidadTuberia;
			volumenHastaTuberiaDerecha = superficie * profundidadTuberiaDerecho;
		}
	}
	
	public void setVolumenTuberiaIzquierda(int profundidadTuberiaIzquierda) {
		this.profundidadTuberiaIzquierdo = this.profundidad - profundidadTuberiaIzquierda;
		this.volumenHastaTuberiaIzquierda = this.profundidadTuberiaIzquierdo * this.superficie;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public int getProfundidadMedida() {
		return profundidadMedida;
	}
	
	public int getProfundidadMedidaDesdeFondo(){
		return profundidad - profundidadMedida;
	}
	
	public int getProfundidadTuberia() {
		return profundidadTuberiaDesdeSuperficie;
	}
	
	public int getVolumen() {
		return volumen;
	}
	
	public int getVolumenTuberiaDerecha() {
		return volumenHastaTuberiaDerecha;
	}
	
	public int getVolumenTuberiaIzquierda() {
		return volumenHastaTuberiaIzquierda;
	}
	
	public int llenarHastaTuberiaDerecha(int volumen) {
		if(volumenHastaTuberiaDerecha >= volumen) {
			this.volumen -= volumen;
			volumen = 0;
		}else {
			this.volumen -= volumenHastaTuberiaDerecha;
			volumen -= volumenHastaTuberiaDerecha;
			volumenHastaTuberiaDerecha = 0;
		}
		
		this.profundidadMedida = this.volumen / this.superficie;
		
		return volumen;
	}
	
	public int llenarHastaTuberiaIzquierda(int volumen) {
		if(volumenHastaTuberiaIzquierda >= volumen) {
			this.volumen -= volumen;
			volumen = 0;
		}else{
			this.volumen -= volumenHastaTuberiaIzquierda;
			volumen -= volumenHastaTuberiaIzquierda;
			volumenHastaTuberiaIzquierda = 0;
		}
		
		this.profundidadMedida = this.volumen / this.superficie;
		
		return volumen;
	}
	
	public int llenarHastaNivel(int nivel) {
		if(nivel == 0)
			nivel = profundidadMedida;
		
		int vol = superficie * nivel;
		
		if(nivel == profundidadTuberiaIzquierdo)
			volumenHastaTuberiaIzquierda = 0;
		
		volumen -= vol;
		profundidadMedida = volumen / superficie;
		
		return vol;
	}
	
	public int llenar(int volumenRestante) {
		if((this.profundidadTuberiaDerecho != -1 && this.profundidadTuberiaIzquierdo == -1) || (this.profundidadTuberiaDerecho < this.profundidadTuberiaIzquierdo && this.profundidadTuberiaDerecho != -1)) {
			volumenRestante = llenarHastaTuberiaDerecha(volumenRestante);
		}else if((this.profundidadTuberiaIzquierdo != -1 && this.profundidadTuberiaDerecho == -1) || (this.profundidadTuberiaDerecho > this.profundidadTuberiaIzquierdo && this.profundidadTuberiaIzquierdo != -1)) {
			volumenRestante = llenarHastaTuberiaIzquierda(volumenRestante);
		}
			
		return volumenRestante;
	}
	
	@Override
	public String toString() {
		return "" + volumen;
	}
}
