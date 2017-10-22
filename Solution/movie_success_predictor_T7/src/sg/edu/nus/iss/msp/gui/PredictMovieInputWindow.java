package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;
import java.awt.Color;

public class PredictMovieInputWindow extends JFrame {

	private MainWindow mainWindow;
	private PredictMovieResultWindow predictMovieResultWindow;
	private MovieService movieService;
	private Movie[] movies;
	private JButton btnPredict;
	private JTextField txt_MainActorName;
	private JTextField txt_MainActorPopularity;
	private JTextField txt_SecondActorName;
	private JTextField txt_SecondActorPopularity;
	private JTextField txt_DirectorName;
	private JTextField txt_DirectorPopularity;
	private JTextField txt_Genre1;
	private JTextField txt_CountryOfOrigin;
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
	private JTextField txt_Genre2;
	private JTextField txt_Genre3;

	public PredictMovieInputWindow(MainWindow mainWindow, MovieService movieService) {

		this.mainWindow = mainWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();

		initialize();

	}

	private void initialize() {
		setSize(800, 584);
		setTitle("Predict New Movie");

		getContentPane().setLayout(null);
		JPanel intpuPane = new JPanel();
		intpuPane.setBounds(10, 11, 760, 438);
		getContentPane().add(intpuPane);
		intpuPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Main Actor Name");
		lblNewLabel.setBounds(184, 21, 137, 14);
		intpuPane.add(lblNewLabel);

		txt_MainActorName = new JTextField();
		txt_MainActorName.setBounds(331, 18, 248, 20);
		intpuPane.add(txt_MainActorName);
		txt_MainActorName.setColumns(10);

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

		txt_SecondActorName = new JTextField();
		txt_SecondActorName.setColumns(10);
		txt_SecondActorName.setBounds(331, 89, 248, 20);
		intpuPane.add(txt_SecondActorName);

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

		txt_DirectorName = new JTextField();
		txt_DirectorName.setColumns(10);
		txt_DirectorName.setBounds(331, 167, 248, 20);
		intpuPane.add(txt_DirectorName);

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

		txt_Genre1 = new JTextField();
		txt_Genre1.setColumns(10);
		txt_Genre1.setBounds(331, 244, 248, 20);
		intpuPane.add(txt_Genre1);

		JLabel lblCountryOfOrigin = new JLabel("Country Of Origin");
		lblCountryOfOrigin.setBounds(184, 367, 137, 14);
		intpuPane.add(lblCountryOfOrigin);

		txt_CountryOfOrigin = new JTextField();
		txt_CountryOfOrigin.setColumns(10);
		txt_CountryOfOrigin.setBounds(331, 364, 248, 20);
		intpuPane.add(txt_CountryOfOrigin);

		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(184, 408, 137, 14);
		intpuPane.add(lblBudget);

		txt_Budget = new JTextField();
		txt_Budget.setColumns(10);
		txt_Budget.setBounds(331, 405, 248, 20);
		intpuPane.add(txt_Budget);

		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(191, 371, 388, 14);
		intpuPane.add(lblMsg);
		
		JLabel lblGenre2 = new JLabel("Genre 2");
		lblGenre2.setBounds(184, 290, 137, 14);
		intpuPane.add(lblGenre2);
		
		txt_Genre2 = new JTextField();
		txt_Genre2.setColumns(10);
		txt_Genre2.setBounds(331, 287, 248, 20);
		intpuPane.add(txt_Genre2);
		
		JLabel lblGenre3 = new JLabel("Genre 3");
		lblGenre3.setBounds(184, 327, 137, 14);
		intpuPane.add(lblGenre3);
		
		txt_Genre3 = new JTextField();
		txt_Genre3.setColumns(10);
		txt_Genre3.setBounds(331, 324, 248, 20);
		intpuPane.add(txt_Genre3);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 452, 760, 72);
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

	}

	private void predict() {
		// TODO Auto-generated method stub
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
		mainActorName = txt_MainActorName.getText();
		if (mainActorName == null || mainActorName.trim().isEmpty()) {
			return false;
		}
		try {
			mainActorPopularity = Double.parseDouble(txt_MainActorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		secondActorName = txt_SecondActorName.getText();
		if (secondActorName == null || secondActorName.trim().isEmpty()) {
			return false;
		}
		try {
			secondActorPopularity = Double.parseDouble(txt_SecondActorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		directorName = txt_DirectorName.getText();
		if (directorName == null || directorName.trim().isEmpty()) {
			return false;
		}
		try {
			directorPopularity = Double.parseDouble(txt_DirectorPopularity.getText());
		} catch (Exception ex) {
			return false;
		}
		genre1 = txt_Genre1.getText();
		if (genre1 == null || genre1.trim().isEmpty()) {
			return false;
		}
		genre2 = txt_Genre2.getText();
		if (genre1 == null || genre2.trim().isEmpty()) {
			return false;
		}
		genre3 = txt_Genre3.getText();
		if (genre3 == null || genre3.trim().isEmpty()) {
			return false;
		}
		countryOfOrigin = txt_CountryOfOrigin.getText();
		if (countryOfOrigin == null || countryOfOrigin.trim().isEmpty()) {
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
