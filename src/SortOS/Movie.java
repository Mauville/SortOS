public class Movie {
	private String title, director, duration, year, classification;
	
	public Movie() {
		title = "";
		director = "";
		duration = "";
		year = "";
		classification = "";
	}
	
	public String toString() {
		return title + "(" + year + ")"+director+ " " + duration+ " Clsf:" + classification;
	}
	
	public boolean equals(Object obj) {
		System.out.println("Comparing " + this + " with " + obj);
		if (!(obj instanceof Movie))
			return false;
		Movie m = (Movie)obj;
		return m != null && m.title.equals(this.title);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
}
