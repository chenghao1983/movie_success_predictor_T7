package sg.edu.nus.iss.msp.model;

public class Movie {

	private String mainActorName;
	
	private String secondActorName;
	
	private String directorName;

	private String genre1;
	
	private String genre2;
	
	private String genre3;

	private String countryOfOrigin;

	private Double budget;
	
	private String result;
	

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getMainActorName() {
		return mainActorName;
	}

	public void setMainActorName(String mainActorName) {
		this.mainActorName = mainActorName;
	}

	public String getSecondActorName() {
		return secondActorName;
	}

	public void setSecondActorName(String secondActorName) {
		this.secondActorName = secondActorName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

}
