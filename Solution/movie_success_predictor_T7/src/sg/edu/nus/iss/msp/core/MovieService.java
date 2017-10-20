package sg.edu.nus.iss.msp.core;

import java.io.*;
import java.util.Iterator;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

import sg.edu.nus.iss.msp.constant.Constants;
import sg.edu.nus.iss.msp.model.Movie;

public class MovieService {

	private Instances instances = null;
	private Movie[] movies = null;

	public void loadData() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(getInputDataFilePath()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			instances = new Instances(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setting class attribute
		instances.setClassIndex(instances.numAttributes() - 1);

	}

	public boolean predictMovieSuccess(Movie movie)	{
		// TODO: add ML code here
		
		
		
		
		return true;
	}

	public void saveData(Movie[] movies) {
		// TODO

	}

	public String getInputDataFilePath() throws IOException {
		String currentDirectory = null;
		currentDirectory = System.getProperty("user.dir");
		if (currentDirectory == null || currentDirectory.equals("")) {
			File currentDir = new File(".");
			currentDirectory = currentDir.getAbsolutePath();
		}
		if (!currentDirectory.contains(Constants.PROJECT_NAME)) {
			currentDirectory += "/" + Constants.PROJECT_NAME;
		}
		return currentDirectory + "/data/" + Constants.DATA_FILE_NAME;
	}

	public Movie[] getMovies() {
		if (movies == null) {
			loadData();
			convertData();
		}
		return movies;
	}

	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}

	private Instances getInstances() {
		if (instances == null) {
			loadData();
			convertData();
		}
		return instances;
	}

	private void setInstances(Instances instances) {
		this.instances = instances;
	}

	private void convertData() {

		movies = new Movie[instances.size()];
		for (int i = 0; i < movies.length; i++) {
			Movie movie = new Movie();
			Instance instance = instances.get(i);
			movie.setMainActorName(instance.stringValue(0));
			movie.setMainActorPopularity(instance.value(1));
			movie.setSecondActorName(instance.stringValue(2));
			movie.setSecondActorPopularity(instance.value(3));
			movie.setDirectorName(instance.stringValue(4));
			movie.setDirectorPopularity(instance.value(5));
			movie.setGenre(instance.stringValue(6));
			movie.setCountryOfOrigin(instance.stringValue(7));
			movie.setGrossProfit(instance.value(8));
			movie.setBudget(instance.value(9));
			movie.setResult(instance.stringValue(10));

			movies[i] = movie;
		}
	}
}
