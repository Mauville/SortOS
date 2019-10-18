
package SortOS;
public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private String matricula;
	private String calificacion;

public Alumno(String nombre, String matricula, String calificacion) {
		super();
		this.nombre = nombre;
		this.matricula = matricula;
		this.calificacion = calificacion;

	}


public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}

	@Override
	public int compareTo(Alumno o) {
		return matricula.compareTo(o.matricula);
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
}
