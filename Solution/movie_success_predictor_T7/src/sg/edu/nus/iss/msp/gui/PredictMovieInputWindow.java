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
	private JTextField txt_Genre;
	private JTextField txt_CountryOfOrigin;
	private JTextField txt_Budget;
	private JLabel lblMsg;

	private String mainActorName;
	private Double mainActorPopularity;
	private String secondActorName;
	private Double secondActorPopularity;
	private String directorName;
	private Double directorPopularity;
	private String genre;
	private String countryOfOrigin;
	private Double budget;

	public PredictMovieInputWindow(MainWindow mainWindow, MovieService movieService) {

		this.mainWindow = mainWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();

		initialize();

	}

	private void initialize() {
		setSize(800, 569);
		setTitle("Predict New Movie");

		getContentPane().setLayout(null);
		JPanel intpuPane = new JPanel();
		intpuPane.setBounds(10, 11, 760, 409);
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

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(184, 247, 137, 14);
		intpuPane.add(lblGenre);

		txt_Genre = new JTextField();
		txt_Genre.setColumns(10);
		txt_Genre.setBounds(331, 244, 248, 20);
		intpuPane.add(txt_Genre);

		JLabel lblCountryOfOrigin = new JLabel("Country Of Origin");
		lblCountryOfOrigin.setBounds(184, 287, 137, 14);
		intpuPane.add(lblCountryOfOrigin);

		txt_CountryOfOrigin = new JTextField();
		txt_CountryOfOrigin.setColumns(10);
		txt_CountryOfOrigin.setBounds(331, 284, 248, 20);
		intpuPane.add(txt_CountryOfOrigin);

		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(184, 328, 137, 14);
		intpuPane.add(lblBudget);

		txt_Budget = new JTextField();
		txt_Budget.setColumns(10);
		txt_Budget.setBounds(331, 325, 248, 20);
		intpuPane.add(txt_Budget);

		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(191, 371, 388, 14);
		intpuPane.add(lblMsg);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 431, 760, 86);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(449, 11, 160, 55);
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
		btnPredict.setBounds(149, 11, 160, 55);
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
				newMovie.setGenre(genre);
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
		genre = txt_Genre.getText();
		if (genre == null || genre.trim().isEmpty()) {
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
