package sg.edu.nus.iss.msp.model;

public class Movie {

	private String mainActorName;
	
	private double mainActorPopularity;
	
	private String secondActorName;

	private double secondActorPopularity;
	
	private String directorName;

	private double directorPopularity;

	private String genre;

	private String countryOfOrigin;

	private Double grossProfit;

	private Double budget;
	
	private String result;
	

	public double getMainActorPopularity() {
		return mainActorPopularity;
	}

	public void setMainActorPopularity(double mainActorPopularity) {
		this.mainActorPopularity = mainActorPopularity;
	}

	public double getSecondActorPopularity() {
		return secondActorPopularity;
	}

	public void setSecondActorPopularity(double secondActorPopularity) {
		this.secondActorPopularity = secondActorPopularity;
	}

	public double getDirectorPopularity() {
		return directorPopularity;
	}

	public void setDirectorPopularity(double directorPopularity) {
		this.directorPopularity = directorPopularity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Double getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(Double grossProfit) {
		this.grossProfit = grossProfit;
	}
	
	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Boolean getIsSuccess() {
		return (getGrossProfit() / getBudget() > 1.65);
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

}
