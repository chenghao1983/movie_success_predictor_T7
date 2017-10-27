package sg.edu.nus.iss.msp.core;

import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.supervised.instance.*;
import weka.core.*;
import weka.classifiers.trees.J48;
import java.io.*;
import java.util.logging.*;

import sg.edu.nus.iss.msp.model.Movie;
import sg.edu.nus.iss.msp.constant.Constants;

public class DecisionTreeService {
	J48 learntModel;
	Instances train;
	private static final Logger LOGGER = Logger.getLogger(DecisionTreeService.class.getName());
	

//	public static void main(String[] args) throws Exception {
//
//		DecisionTreeService decisionTree = new DecisionTreeService();
//		System.out.println(decisionTree.loadExistingModel("data/moviedata.arff").toString());
//	}


	/**
	 * This function is to filter Data Instances based on Supervised Learning Method - Resampling
	 * Currently Resample the whole data set
	 * 	 
	 * BiasToUniformClass = 0.0
	 * NoReplacement = False
	 * 
	 * @param dataInstances Instances 
	 * @return filteredInstances Result based on Resampling instances
	 * @exception Exception
	 * @see Exception
	 */
	public Instances resampleDataSet(Instances dataInstances)
	{
		final Resample filter = new Resample();
		Instances filteredInstances = null;
		filter.setBiasToUniformClass(0.0);
		try {
			filter.setInputFormat(dataInstances);
			filter.setNoReplacement(false);
			filter.setSampleSizePercent(100);
			filteredInstances = weka.filters.Filter.useFilter(dataInstances, filter);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,"" , "Error when resampling input data!");
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return filteredInstances;
	}

	/**
	 * This is to train the Decision Tree with the filename provided. Once the
	 * training is done, the model will be saved in "data/moviedata.model"
	 * 
	 * @param fileName
	 *            "data/moviedata.arff"
	 * @return J48 object
	 * @exception Exception
	 * @see Exception
	 */
	public J48 trainTree(String fileName) {
		learntModel = new J48();

		String[] options = new String[2];
		options[0] = "-C";
		options[1] = "0.25";
		try {
			// Load the data source and learn the model
			DataSource source = new DataSource(fileName);
			train = source.getDataSet();

			// Learn the Decision Tree
			train.setClassIndex(train.numAttributes() - 1);
			learntModel.setOptions(options);
			learntModel.buildClassifier(this.resampleDataSet(train));

			// Save the Model in moviedata.model file
			SerializationHelper.write(Constants.MODEL_FILE_PATH, learntModel);

			return learntModel;

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return learntModel;
	}

	/**
	 * This method to load the existing model, if existing model doesn't exist, it
	 * will call trainTree method to train the data file that have been provided in
	 * parameter
	 * 
	 * @param trainFileName "data/moviedata.arff"
	 * @return J48 object
	 * @exception Exception
	 * @see Exception
	 */

	public J48 loadExistingModel(String trainFileName) {
		learntModel = new J48();
		String fileName = Constants.MODEL_FILE_PATH;
		try {
			File f = new File(fileName);
			if (f.exists()) {
				learntModel = (J48) SerializationHelper.read(fileName);
				return learntModel;

			} else {
				return this.trainTree(trainFileName);
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return learntModel;
	}

	/**
	 * This method to predict the movie
	 * 
	 * @param m Movie object
	 * @param fileName "data/moviedata.arff"
	 * @return int Integer value ( 0, 1, -1 )
	 * @exception Exception
	 * @see Exception
	 */

	public int predict(Movie m, String fileName) {
		learntModel = this.loadExistingModel(fileName);
		DataSource source;
		try {
			source = new DataSource(fileName);
			Instances trainingData = source.getDataSet();

			Instance testInstance = new DenseInstance(8);
			testInstance.setDataset(trainingData);
			testInstance.setValue(trainingData.attribute(0), m.getMainActorPopularity());
			testInstance.setValue(trainingData.attribute(1), m.getSecondActorPopularity());
			testInstance.setValue(trainingData.attribute(2), m.getDirectorPopularity());
			testInstance.setValue(trainingData.attribute(3), m.getGenre1());
			testInstance.setValue(trainingData.attribute(4), m.getGenre2());
			testInstance.setValue(trainingData.attribute(5), m.getGenre3());
			testInstance.setValue(trainingData.attribute(6), m.getCountryOfOrigin());
			testInstance.setValue(trainingData.attribute(7), m.getBudget());
			//testInstance.setValue(trainingData.attribute(8), "Success");

			int result = (int) learntModel.classifyInstance(testInstance);

			return result;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return -1;

	}

}
