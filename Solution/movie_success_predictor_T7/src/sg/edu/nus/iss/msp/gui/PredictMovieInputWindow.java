package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.ComboItem;
import sg.edu.nus.iss.msp.model.Movie;
import weka.core.pmml.jaxbbindings.Item;

import java.awt.Color;

public class PredictMovieInputWindow extends JFrame {

	private MainWindow mainWindow;
	private PredictMovieResultWindow predictMovieResultWindow;
	private MovieService movieService;
	private Movie[] movies;
	private JButton btnPredict;
	private JComboBox comboBox_MainActorName;
	private JTextField txt_MainActorPopularity;
	private JComboBox comboBox_SecondActorName;
	private JTextField txt_SecondActorPopularity;
	private JComboBox comboBox_DirectorName;
	private JTextField txt_DirectorPopularity;
	private JComboBox comboBox_Genre1;
	private JComboBox comboBox_Genre2;
	private JComboBox comboBox_Genre3;
	private JComboBox comboBox_CountryOfOrigin;
	private JTextField txt_Budget;
	private JLabel lblMsg;

	private String mainActorName;
	private Double mainActorPopularity;
	private String secondActorName;
	private Double secondActorPopularity;
	private String directorName;
	private Double directorPopularity;
	private String genre1;
	private String genre2;
	private String genre3;
	private String countryOfOrigin;
	private Double budget;

	public PredictMovieInputWindow(MainWindow mainWindow, MovieService movieService) {

		this.mainWindow = mainWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();

		initialize();

	}

	private void initialize() {
		setSize(800, 632);
		setTitle("Predict New Movie");

		getContentPane().setLayout(null);
		JPanel intpuPane = new JPanel();
		intpuPane.setBounds(10, 11, 760, 476);
		getContentPane().add(intpuPane);
		intpuPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Main Actor Name");
		lblNewLabel.setBounds(184, 21, 137, 14);
		intpuPane.add(lblNewLabel);

		comboBox_MainActorName = new JComboBox();
		comboBox_MainActorName.setBounds(331, 18, 248, 20);
		intpuPane.add(comboBox_MainActorName);

		JLabel lblMainActorPopularity = new JLabel("Main Actor Popularity");
		lblMainActorPopularity.setBounds(184, 56, 137, 14);
		intpuPane.add(lblMainActorPopularity);

		txt_MainActorPopularity = new JTextField();
		txt_MainActorPopularity.setColumns(10);
		txt_MainActorPopularity.setBounds(331, 53, 248, 20);
		intpuPane.add(txt_MainActorPopularity);

		JLabel lblSecondActorName = new JLabel("Second Actor Name");
		lblSecondActorName.setBounds(184, 92, 137, 14);
		intpuPane.add(lblSecondActorName);

		comboBox_SecondActorName = new JComboBox();
		comboBox_SecondActorName.setBounds(331, 89, 248, 20);
		intpuPane.add(comboBox_SecondActorName);

		JLabel lblSecondActorPopularity = new JLabel("Second Actor Popularity");
		lblSecondActorPopularity.setBounds(184, 129, 137, 14);
		intpuPane.add(lblSecondActorPopularity);

		txt_SecondActorPopularity = new JTextField();
		txt_SecondActorPopularity.setColumns(10);
		txt_SecondActorPopularity.setBounds(331, 126, 248, 20);
		intpuPane.add(txt_SecondActorPopularity);

		JLabel lblDirectorName = new JLabel("Director Name");
		lblDirectorName.setBounds(184, 170, 137, 14);
		intpuPane.add(lblDirectorName);

		comboBox_DirectorName = new JComboBox();
		comboBox_DirectorName.setBounds(331, 167, 248, 20);
		intpuPane.add(comboBox_DirectorName);

		JLabel lblDirectorPopularity = new JLabel("Director Popularity");
		lblDirectorPopularity.setBounds(184, 207, 137, 14);
		intpuPane.add(lblDirectorPopularity);

		txt_DirectorPopularity = new JTextField();
		txt_DirectorPopularity.setColumns(10);
		txt_DirectorPopularity.setBounds(331, 204, 248, 20);
		intpuPane.add(txt_DirectorPopularity);

		JLabel lblGenre1 = new JLabel("Genre 1");
		lblGenre1.setBounds(184, 247, 137, 14);
		intpuPane.add(lblGenre1);

		comboBox_Genre1 = new JComboBox();
		comboBox_Genre1.setBounds(331, 244, 248, 20);
		intpuPane.add(comboBox_Genre1);

		JLabel lblGenre2 = new JLabel("Genre 2");
		lblGenre2.setBounds(184, 290, 137, 14);
		intpuPane.add(lblGenre2);

		comboBox_Genre2 = new JComboBox();
		comboBox_Genre2.setBounds(331, 287, 248, 20);
		intpuPane.add(comboBox_Genre2);

		JLabel lblGenre3 = new JLabel("Genre 3");
		lblGenre3.setBounds(184, 327, 137, 14);
		intpuPane.add(lblGenre3);

		comboBox_Genre3 = new JComboBox();
		comboBox_Genre3.setBounds(331, 324, 248, 20);
		intpuPane.add(comboBox_Genre3);

		JLabel lblCountryOfOrigin = new JLabel("Country Of Origin");
		lblCountryOfOrigin.setBounds(184, 367, 137, 14);
		intpuPane.add(lblCountryOfOrigin);

		comboBox_CountryOfOrigin = new JComboBox();
		comboBox_CountryOfOrigin.setBounds(331, 364, 248, 20);
		intpuPane.add(comboBox_CountryOfOrigin);

		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(184, 408, 137, 14);
		intpuPane.add(lblBudget);

		txt_Budget = new JTextField();
		txt_Budget.setColumns(10);
		txt_Budget.setBounds(331, 405, 248, 20);
		intpuPane.add(txt_Budget);

		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(191, 449, 388, 14);
		intpuPane.add(lblMsg);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 500, 760, 72);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(448, 13, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainWindow.setPredictMovieInputWindow(null);
				if (predictMovieResultWindow != null) {
					predictMovieResultWindow.dispose();
				}
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		btnPredict = new JButton("Predict");
		btnPredict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				predict();
			}
		});
		btnPredict.setBounds(154, 13, 160, 55);
		buttonPanel.add(btnPredict);

		populateComboBox();
	}

	private void populateComboBox() {
		ComboItem itemMainActorName;
		ComboItem itemSeconActorName;
		ComboItem itemDirectorName;
		ComboItem itemGenre1;
		ComboItem itemGenre2;
		ComboItem itemGenre3;
		ComboItem itemCountryOfOrigin;

		ArrayList<String> listMainActorName = new ArrayList<String>();
		ArrayList<String> listSecondActorName = new ArrayList<String>();
		ArrayList<String> listDirectorName = new ArrayList<String>();
		ArrayList<String> listGenre1 = new ArrayList<String>();
		ArrayList<String> listGenre2 = new ArrayList<String>();
		ArrayList<String> listGenre3 = new ArrayList<String>();
		ArrayList<String> listCountryOfOrigin = new ArrayList<String>();
		

		for (Movie movie : movies) {
			if (!listMainActorName.contains(movie.getMainActorName())) {
				listMainActorName.add(movie.getMainActorName());
			}
			if (!listSecondActorName.contains(movie.getSecondActorName())) {
				listSecondActorName.add(movie.getSecondActorName());
			}
			if (!listDirectorName.contains(movie.getDirectorName())) {
				listDirectorName.add(movie.getDirectorName());
			}
			if (!listGenre1.contains(movie.getGenre1())) {
				listGenre1.add(movie.getGenre1());
			}
			if (!listGenre2.contains(movie.getGenre2())) {
				listGenre2.add(movie.getGenre2());
			}
			if (!listGenre3.contains(movie.getGenre3())) {
				listGenre3.add(movie.getGenre3());
			}
			if (!listCountryOfOrigin.contains(movie.getCountryOfOrigin())) {
				listCountryOfOrigin.add(movie.getCountryOfOrigin());
			}
		}

		Collections.sort(listMainActorName);
		Collections.sort(listSecondActorName);
		Collections.sort(listDirectorName);
		Collections.sort(listGenre1);
		Collections.sort(listGenre2);
		Collections.sort(listGenre3);
		Collections.sort(listCountryOfOrigin);
		
		comboBox_MainActorName.addItem(new ComboItem("NA", "NA"));
		for (String mainActorName : listMainActorName) {
			comboBox_MainActorName.addItem(new ComboItem(mainActorName, mainActorName));
		}

		comboBox_SecondActorName.addItem(new ComboItem("NA", "NA"));		
		for (String secondActorName : listSecondActorName) {
			comboBox_SecondActorName.addItem(new ComboItem(secondActorName, secondActorName));
		}

		comboBox_DirectorName.addItem(new ComboItem("NA", "NA"));		
		for (String directorName : listDirectorName) {
			comboBox_DirectorName.addItem(new ComboItem(directorName, directorName));
		}

		comboBox_Genre1.addItem(new ComboItem("NA", "NA"));
		for (String genre1 : listGenre1) {
			comboBox_Genre1.addItem(new ComboItem(genre1, genre1));
		}		
		
		comboBox_Genre2.addItem(new ComboItem("NA", "NA"));
		for (String genre2 : listGenre2) {
			comboBox_Genre2.addItem(new ComboItem(genre2, genre2));
		}			

		comboBox_Genre3.addItem(new ComboItem("NA", "NA"));
		for (String genre3 : listGenre3) {
			comboBox_Genre3.addItem(new ComboItem(genre3, genre3));
		}		

		comboBox_CountryOfOrigin.addItem(new ComboItem("NA", "NA"));
		for (String countryOfOrigin : listCountryOfOrigin) {
			comboBox_CountryOfOrigin.addItem(new ComboItem(countryOfOrigin, countryOfOrigin));
		}	

	}

	private void predict() {
		lblMsg.setText("");
		if (validateForm()) {
			if (getPredictMovieResultWindow() == null) {
				Movie newMovie = new Movie();
				newMovie.setMainActorName(mainActorName);
				newMovie.setMainActorPopularity(mainActorPopularity);
				newMovie.setSecondActorName(secondActorName);
				newMovie.setSecondActorPopularity(secondActorPopularity);
				newMovie.setDirectorName(directorName);
				newMovie.setDirectorPopularity(directorPopularity);
				newMovie.setDirectorPopularity(directorPopularity);
				newMovie.setGenre1(genre1);
				newMovie.setGenre2(genre2);
				newMovie.setGenre2(genre3);
				newMovie.setCountryOfOrigin(countryOfOrigin);
				newMovie.setBudget(budget);

				boolean movieSuccess = movieService.predictMovieSuccess(newMovie);

				predictMovieResultWindow = new PredictMovieResultWindow(this, movieService);
				predictMovieResultWindow.setVisible(true);
				predictMovieResultWindow.setLocation(getLocation());
			}
		} else {
			lblMsg.setText("Invalid input");
		}
	}

	private Boolean validateForm() {
		mainActorName = ((ComboItem) comboBox_MainActorName.getSelectedItem()).getValue();
		if (mainActorName == null) {
			return false;
		}
		try {
			mainActorPopularity = Double.parseDouble(txt_MainActorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		secondActorName = ((ComboItem) comboBox_SecondActorName.getSelectedItem()).getValue();
		if (secondActorName == null) {
			return false;
		}
		try {
			secondActorPopularity = Double.parseDouble(txt_SecondActorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		directorName = ((ComboItem) comboBox_DirectorName.getSelectedItem()).getValue();
		if (directorName == null) {
			return false;
		}
		try {
			directorPopularity = Double.parseDouble(txt_DirectorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		genre1 = ((ComboItem) comboBox_Genre1.getSelectedItem()).getValue();
		if (genre1 == null) {
			return false;
		}
		genre2 = ((ComboItem) comboBox_Genre2.getSelectedItem()).getValue();
		if (genre2 == null) {
			return false;
		}
		genre3 = ((ComboItem) comboBox_Genre3.getSelectedItem()).getValue();
		if (genre3 == null) {
			return false;
		}
		countryOfOrigin = ((ComboItem) comboBox_CountryOfOrigin.getSelectedItem()).getValue();
		if (countryOfOrigin == null) {
			return false;
		}
		try {
			budget = Double.parseDouble(txt_Budget.getText());
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	public PredictMovieResultWindow getPredictMovieResultWindow() {
		return predictMovieResultWindow;
	}

	public void setPredictMovieResultWindow(PredictMovieResultWindow predictMovieResultWindow) {
		this.predictMovieResultWindow = predictMovieResultWindow;
	}
}
