package unlam.edu.le;

import java.util.ArrayList;

public class Estanque {
	private int superficie;
	private int profundidad;
	private int profundidadCaño;
	private int profundidadMedida;
	private boolean esUltimoEstanque;
	private int volumenTotal;// solo valido para el primer estanque en ser llenado
	private int estanquesTotales;// solo valido para el primer estanque

	public Estanque(int superficie, int profundidad, int distanciaCaño) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		/*
		 * ya que se mide la profundidad del caño desde la superficie se la resto a la
		 * profundidad para obtener la medicion desde el fondo del estanque y facilitar
		 * los calculos
		 */
		this.profundidadCaño = this.profundidad - distanciaCaño;
		this.esUltimoEstanque = false;
		estanquesTotales = 0;
	}

	public static ArrayList<Estanque> calcularVolumen(ArrayList<Estanque> listaEstanques) {
		ArrayList<Estanque> estanques = new ArrayList<Estanque>();

		estanques.addAll(listaEstanques);

		int volumenTotal = estanques.get(0).getVolumenTotal();

		for (Estanque e : estanques) {
			if (!e.esUltimoEstanque) {
				if (volumenTotal == (e.superficie * e.profundidadCaño)) {
					e.profundidadMedida = e.profundidadCaño;
					volumenTotal = 0;
				} else if (volumenTotal < (e.superficie * e.profundidadCaño)) {
					e.profundidadMedida = volumenTotal / e.superficie;
					volumenTotal = 0;
				} else {
					e.profundidadMedida = e.profundidadCaño;
					volumenTotal -= (e.superficie * e.profundidadCaño);
				}
			} else {
				e.profundidadMedida = (volumenTotal / e.superficie) <= e.profundidad ? volumenTotal / e.superficie
						: e.profundidad;
				volumenTotal -= e.superficie * e.profundidadMedida;
			}

			estanques.get(0).estanquesTotales++;

			if (volumenTotal <= 0) {
				break;
			}
		}

		if (volumenTotal > 0) {
			int i = estanques.size() - 1;

			for (; i >= 0; i--) {
				if (volumenTotal / estanques.get(i).superficie <= (estanques.get(i).profundidad
						- estanques.get(i).profundidadMedida)) {
					estanques.get(i).profundidadMedida += volumenTotal / estanques.get(i).superficie;
					estanques.get(i).setVolumenTotal(0);
					return estanques;
				} else {
					volumenTotal -= (estanques.get(i).superficie
							* (estanques.get(i).profundidad - estanques.get(i).profundidadMedida));
					estanques.get(i).profundidadMedida = estanques.get(i).profundidad;
				}
			}
		}

		estanques.get(0).setVolumenTotal(volumenTotal);
		return estanques;
	}

	public int getEstanquesTotales() {
		return estanquesTotales;
	}

	public boolean isEsUltimoEstanque() {
		return esUltimoEstanque;
	}

	@Override
	public String toString() {
		return superficie + " " + profundidad + " " + profundidadCaño + " " + profundidadMedida + " " + esUltimoEstanque
				+ "; " + volumenTotal;
	}

	public int getProfundidadMedida() {
		return profundidadMedida;
	}

	public void setEsUltimoEstanque(boolean esUltimoEstanque) {
		this.esUltimoEstanque = esUltimoEstanque;
	}

	public int getVolumenTotal() {
		return volumenTotal;
	}

	public void setVolumenTotal(int volumenTotal) {
		this.volumenTotal = volumenTotal;
	}
}
