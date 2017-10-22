package sg.edu.nus.iss.msp.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.*;

public class DecisionTree {
	private Instances trainingData;

	public static void main(String[] args) throws Exception {

		DecisionTree decisionTree = new DecisionTree("data/moviedata.arff");
		J48 tree = decisionTree.trainTheTree();

		// Print the resulted tree
		System.out.println(tree.toString());

		// Test the tree
		Instance testInstance = decisionTree.prepareTestInstance();
		int result = (int) tree.classifyInstance(testInstance);

		String readableResult = decisionTree.trainingData.attribute(12).value(result);
		System.out.println(" ----------------------------------------- ");
		System.out.println("Test data               : " + testInstance);
		System.out.println("Test data classification: " + readableResult);
	}

	public DecisionTree(String fileName) {
		BufferedReader reader = null;
		try {
			// Read the training data
			reader = new BufferedReader(new FileReader(fileName));
			trainingData = new Instances(reader);

			// Setting class attribute
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private J48 trainTheTree() {
		J48 tree = new J48();

		String[] options = new String[2];
		// Use unpruned tree.
		options[0] = "-C";
		options[1] = "0.25";

		try {
			tree.setOptions(options);
			tree.buildClassifier(trainingData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tree;
	}

	private Instance prepareTestInstance() {
		Instance instance = new DenseInstance(13);
		instance.setDataset(trainingData);

//		instance.setValue(trainingData.attribute(0), "Johnny Depp");
//		instance.setValue(trainingData.attribute(1), 40000);
//		instance.setValue(trainingData.attribute(2), "Orlando Bloom");
//		
//		instance.setValue(trainingData.attribute(3), 5000);
//		instance.setValue(trainingData.attribute(4), "Gore Verbinski");
//		instance.setValue(trainingData.attribute(5), 563);
//		
//		instance.setValue(trainingData.attribute(6), "Action");
//		instance.setValue(trainingData.attribute(7), "Adventure");
//		instance.setValue(trainingData.attribute(8), "Fantasy");
//		
//		instance.setValue(trainingData.attribute(9), "USA");
		//instance.setValue(trainingData.attribute(10), 309404152);
		//instance.setValue(trainingData.attribute(11), 32500000);
		
		//instance.setValue(trainingData.attribute(12), 563);
		
		instance.setValue(trainingData.attribute(0), "CCH Pounder");
		instance.setValue(trainingData.attribute(1), 1000);
		instance.setValue(trainingData.attribute(2), "Joel David Moore");
		
		instance.setValue(trainingData.attribute(3), 936);
		instance.setValue(trainingData.attribute(4), "James Cameron");
		instance.setValue(trainingData.attribute(5), 0);
		
		instance.setValue(trainingData.attribute(6), "Action");
		instance.setValue(trainingData.attribute(7), "Adventure");
		instance.setValue(trainingData.attribute(8), "Fantasy");
		
		instance.setValue(trainingData.attribute(9), "USA");
		instance.setValue(trainingData.attribute(10), 760505847);
		instance.setValue(trainingData.attribute(11), 237000000);
		
		//instance.setValue(trainingData.attribute(12), 563);

		return instance;
	}
}