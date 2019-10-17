
package SortOS;
public class Alumno implements Comparable<Alumno> {
	
	private String nombre;
	private String matricula;
public Alumno(String nombre, String matricula) {
		super();
		this.nombre = nombre;
		this.matricula = matricula;
		
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

}
