package codigo;

public class Nombre implements Comparable<Nombre>{
	private String nombre;
	private int cantidadDeRepeticiones;
	
	public Nombre(String nom, int cantRepe) {
		nombre = nom;
		cantidadDeRepeticiones = cantRepe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nombre other = (Nombre) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre + " " + cantidadDeRepeticiones;
	}

	@Override
	public int compareTo(Nombre o) {
		return o.cantidadDeRepeticiones - this.cantidadDeRepeticiones;
	}
}
