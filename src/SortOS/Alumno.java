package SortOS;
public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private String matricula;

	private int calif;
	public int getCalif() {
		return calif;
	}
	public void setCalif(int calif) {
		this.calif = calif;
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
	public String toString(){
		return nombre+", " +matricula +", " + calif;
	}

}
