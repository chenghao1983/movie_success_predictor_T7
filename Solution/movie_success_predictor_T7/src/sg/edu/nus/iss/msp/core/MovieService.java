package sg.edu.nus.iss.msp.core;

import java.io.*;
import java.util.*;
import java.util.Enumeration;
import java.util.Iterator;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import sg.edu.nus.iss.msp.constant.Constants;
import sg.edu.nus.iss.msp.model.Movie;
import sg.edu.nus.iss.msp.core.*;
import sg.edu.nus.iss.msp.gui.MainWindow;

@SuppressWarnings("unused")
public class MovieService {

	private Instances instances = null;
	private Movie[] movies = null;
	private DecisionTreeService decisionTreeService = new DecisionTreeService();
	private String predictionResult = "";
	
	public void loadData() {
		BufferedReader reader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(getInputDataFilePath());
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			reader = new BufferedReader(fileReader);
		} catch (Exception e2) {
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
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setting class attribute
		instances.setClassIndex(instances.numAttributes() - 1);

	}

	public boolean trainModel() {
		// TODO Auto-generated method stub
		decisionTreeService.trainTree(Constants.DATA_FILE_PATH);
		return true;
	}

	public String predictMovieSuccess(Movie movie) {
		// TODO: add ML code here
		predictionResult = decisionTreeService.predict(movie, Constants.DATA_FILE_PATH);
		return predictionResult;
	}

	public boolean AddMovie(Movie newMovie) {

		boolean success = true;

		Instance newInstance = new DenseInstance(9);

		// .instances.insertAttributeAt(new Attribute("test"),0);

		if (instances.attribute(0).indexOfValue(newMovie.getMainActorPopularity()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(0), 0, newMovie.getMainActorPopularity());
		}
		if (instances.attribute(1).indexOfValue(newMovie.getSecondActorPopularity()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(1), 1, newMovie.getSecondActorPopularity());
		}
		if (instances.attribute(2).indexOfValue(newMovie.getDirectorPopularity()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(2), 2, newMovie.getDirectorPopularity());
		}
		if (instances.attribute(3).indexOfValue(newMovie.getGenre1()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(3), 3, newMovie.getGenre1());
		}
		if (instances.attribute(4).indexOfValue(newMovie.getGenre2()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(4), 4, newMovie.getGenre2());
		}
		if (instances.attribute(5).indexOfValue(newMovie.getGenre3()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(5), 5, newMovie.getGenre3());
		}
		if (instances.attribute(6).indexOfValue(newMovie.getCountryOfOrigin()) == -1) {
			AddNewStringValueToAttribute(instances.attribute(6), 6, newMovie.getCountryOfOrigin());
		}

		newInstance.setDataset(instances);
		/*
		 * if(newInstance.attribute(0).indexOfValue(newMovie.
		 * getMainActorPopularity())==-1) {
		 * newInstance.attribute(0).addStringValue(newMovie.
		 * getMainActorPopularity()); }
		 * if(newInstance.attribute(1).indexOfValue(newMovie.
		 * getSecondActorPopularity())==-1) {
		 * newInstance.attribute(1).addStringValue(newMovie.
		 * getSecondActorPopularity()); }
		 * if(newInstance.attribute(2).indexOfValue(newMovie.
		 * getDirectorPopularity())==-1) {
		 * newInstance.attribute(2).addStringValue(newMovie.
		 * getDirectorPopularity()); }
		 * if(newInstance.attribute(3).indexOfValue(newMovie.getGenre1())==-1) {
		 * newInstance.attribute(3).addStringValue(newMovie.getGenre1()); }
		 * if(newInstance.attribute(4).indexOfValue(newMovie.getGenre2())==-1) {
		 * newInstance.attribute(4).addStringValue(newMovie.getGenre2()); }
		 * if(newInstance.attribute(5).indexOfValue(newMovie.getGenre3())==-1) {
		 * newInstance.attribute(5).addStringValue(newMovie.getGenre3()); }
		 * if(newInstance.attribute(6).indexOfValue(newMovie.getCountryOfOrigin(
		 * ))==-1) {
		 * newInstance.attribute(6).addStringValue(newMovie.getCountryOfOrigin()
		 * ); }
		 */

		newInstance.setValue(0, newMovie.getMainActorPopularity());
		newInstance.setValue(1, newMovie.getSecondActorPopularity());
		newInstance.setValue(2, newMovie.getDirectorPopularity());
		newInstance.setValue(3, newMovie.getGenre1());
		newInstance.setValue(4, newMovie.getGenre2());
		newInstance.setValue(5, newMovie.getGenre3());
		newInstance.setValue(6, newMovie.getCountryOfOrigin());
		newInstance.setValue(7, newMovie.getBudget());
		newInstance.setValue(8, newMovie.getResult());

		instances.add(newInstance);

		//System.out.println(instances);

		/*
		 * 
		 * BufferedWriter writer =null;
		 * 
		 * try { writer = new BufferedWriter(new
		 * FileWriter(getInputDataFilePath())); } catch (IOException e2) { //
		 * TODO Auto-generated catch block e2.printStackTrace(); }
		 * 
		 * 
		 * 
		 * try { writer.write(instances.toString()); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 */
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(getInputDataFilePath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			success = false;
		}

		try {
			fileWriter.write(instances.toString());
			fileWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			success = false;
		}
		
		/*
		ArffSaver saver = new ArffSaver();
		saver.setInstances(instances);
		try {
			saver.setFile(new File(getInputDataFilePath()));
			saver.setDestination(new File(getInputDataFilePath()));
			saver.writeBatch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		*/

		return success;
	}

	private void AddNewStringValueToAttribute(Attribute attribute, int attributeIndex, String newString) {
		ArrayList<String> attributeList = new ArrayList<>();
		for (Enumeration<Object> iterator = instances.attribute(attributeIndex).enumerateValues(); iterator
				.hasMoreElements();) {
			String string = (String) iterator.nextElement();
			attributeList.add(string);
		}
		attributeList.add(newString);

		ArrayList<String> valueList = new ArrayList<>();
		for (Enumeration<Instance> iterator = instances.enumerateInstances(); iterator.hasMoreElements();) {
			Instance instance = iterator.nextElement();

			valueList.add(instance.stringValue(attributeIndex));
		}

		instances.replaceAttributeAt(new Attribute(instances.attribute(attributeIndex).name(), attributeList),
				attributeIndex);

		int index = 0;
		for (Enumeration<Instance> iterator = instances.enumerateInstances(); iterator.hasMoreElements();) {
			Instance instance = iterator.nextElement();

			instance.setValue(attributeIndex, valueList.get(index));

			index++;
		}
	}
	
	public boolean DeleteMovie(int index) {
		boolean success =true;
		
		
		instances.remove(index);
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(getInputDataFilePath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			success = false;
		}

		try {
			fileWriter.write(instances.toString());
			fileWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			success = false;
		}
		
		return success;
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

	public static String getImageFileLocation() throws IOException {
		String currentDirectory = null;
		currentDirectory = System.getProperty("user.dir");
		if (currentDirectory == null || currentDirectory.equals("")) {
			File currentDir = new File(".");
			currentDirectory = currentDir.getAbsolutePath();
		}
		if (!currentDirectory.contains(Constants.PROJECT_NAME)) {
			currentDirectory += "/" + Constants.PROJECT_NAME;
		}
		return currentDirectory + "/src/img";
	}

	public Movie[] getMovies() {
		{
			loadData();
			convertData();
		}
		return movies;
	}

	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}
	
	public String getPredictionResult() {
		return predictionResult;
	}

	private Instances getInstances() {
		{
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
			movie.setMainActorPopularity(instance.stringValue(0));
			movie.setSecondActorPopularity(instance.stringValue(1));
			movie.setDirectorPopularity(instance.stringValue(2));
			movie.setGenre1(instance.stringValue(3));
			movie.setGenre2(instance.stringValue(4));
			movie.setGenre3(instance.stringValue(5));
			movie.setCountryOfOrigin(instance.stringValue(6));
			movie.setBudget(instance.value(7));
			movie.setResult(instance.stringValue(8));

			movies[i] = movie;
		}
	}

}
