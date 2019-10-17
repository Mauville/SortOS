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
}


/*
	* private void addMovie() {
		try {
			Movie m = new Movie();
			getMovie(m);
			data.add(m);
			setMovie(new Movie());
			clearFields();
		} catch (EmptyFieldException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Add a movie");
			alert.setHeaderText("Error while adding a new movie");
			alert.setContentText(e.getMessage());

			alert.showAndWait();

		}
	}
	*
	*
	* private void getMovie(Movie m) throws EmptyFieldException {
		m.setTitle(txtTitle.getText());
		m.setDirector(txtDirector.getText());
		m.setDuration(txtDuration.getText());
		m.setClassification(txtClassification.getText());
		m.setYear(txtYear.getText());
	}
	* */