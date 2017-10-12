package sg.edu.nus.iss.msp.model;

public class Movie {

	private float mainActorPopularity;

	private float secondActorPopularity;

	private float directorPopularity;

	private String genre;

	private float IMDBScore;

	private String contryOfOrigin;

	private Double grossProfit;

	private Double budget;
	

	public float getMainActorPopularity() {
		return mainActorPopularity;
	}

	public void setMainActorPopularity(float mainActorPopularity) {
		this.mainActorPopularity = mainActorPopularity;
	}

	public float getSecondActorPopularity() {
		return secondActorPopularity;
	}

	public void setSecondActorPopularity(float secondActorPopularity) {
		this.secondActorPopularity = secondActorPopularity;
	}

	public float getDirectorPopularity() {
		return directorPopularity;
	}

	public void setDirectorPopularity(float directorPopularity) {
		this.directorPopularity = directorPopularity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getIMDBScore() {
		return IMDBScore;
	}

	public void setIMDBScore(float iMDBScore) {
		IMDBScore = iMDBScore;
	}

	public String getContryOfOrigin() {
		return contryOfOrigin;
	}

	public void setContryOfOrigin(String contryOfOrigin) {
		this.contryOfOrigin = contryOfOrigin;
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

}
