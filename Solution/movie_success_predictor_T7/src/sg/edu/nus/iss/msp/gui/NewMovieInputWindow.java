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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewMovieInputWindow extends JFrame {

	private ManageMovieDataWindow manageMovieDataWindow;
	private MovieService movieService;
	private Movie[] movies;
	private JButton btnSave;
	private JComboBox<ComboItem> comboBox_MainActorPopularity;
	private JComboBox<ComboItem> comboBox_SecondActorPopularity;
	private JComboBox<ComboItem> comboBox_DirectorPopularity;
	private JTextField txt_Genre1;
	private JTextField txt_Genre2;
	private JTextField txt_Genre3;
	private JTextField txt_CountryOfOrigin;
	private JTextField txt_Budget;
	private JComboBox comboBox_Result;
	private JLabel lblMsg;

	private String MainActorPopularity;
	private Double mainActorPopularity;
	private String SecondActorPopularity;
	private Double secondActorPopularity;
	private String DirectorPopularity;
	private Double directorPopularity;
	private String genre1;
	private String genre2;
	private String genre3;
	private String countryOfOrigin;
	private Double budget;
	private String result;

	public NewMovieInputWindow(ManageMovieDataWindow manageMovieDataWindow, MovieService movieService) {

		this.manageMovieDataWindow = manageMovieDataWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();

		initialize();

	}

	private void initialize() {
		setSize(800, 632);
		setTitle("Add New Movie");

		getContentPane().setLayout(null);
		JPanel intpuPane = new JPanel();
		intpuPane.setBounds(10, 11, 760, 461);
		getContentPane().add(intpuPane);
		intpuPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Main Actor Popularity");
		lblNewLabel.setBounds(162, 21, 147, 14);
		intpuPane.add(lblNewLabel);

		comboBox_MainActorPopularity = new JComboBox<ComboItem>();
		comboBox_MainActorPopularity.setBounds(331, 18, 291, 20);
		intpuPane.add(comboBox_MainActorPopularity);

		JLabel lblSecondActorPopularity = new JLabel("Second Actor Popularity");
		lblSecondActorPopularity.setBounds(162, 63, 147, 14);
		intpuPane.add(lblSecondActorPopularity);

		comboBox_SecondActorPopularity = new JComboBox<ComboItem>();
		comboBox_SecondActorPopularity.setBounds(331, 60, 291, 20);
		intpuPane.add(comboBox_SecondActorPopularity);

		JLabel lblDirectorPopularity = new JLabel("Director Popularity");
		lblDirectorPopularity.setBounds(162, 110, 147, 14);
		intpuPane.add(lblDirectorPopularity);

		comboBox_DirectorPopularity = new JComboBox<ComboItem>();
		comboBox_DirectorPopularity.setBounds(331, 107, 291, 20);
		intpuPane.add(comboBox_DirectorPopularity);

		JLabel lblGenre1 = new JLabel("Genre 1");
		lblGenre1.setBounds(162, 161, 137, 14);
		intpuPane.add(lblGenre1);

		txt_Genre1 = new JTextField();
		txt_Genre1.setBounds(331, 158, 291, 20);
		intpuPane.add(txt_Genre1);

		JLabel lblGenre2 = new JLabel("Genre 2");
		lblGenre2.setBounds(162, 213, 137, 14);
		intpuPane.add(lblGenre2);

		txt_Genre2 = new JTextField();
		txt_Genre2.setBounds(331, 210, 291, 20);
		intpuPane.add(txt_Genre2);

		JLabel lblGenre3 = new JLabel("Genre 3");
		lblGenre3.setBounds(162, 266, 137, 14);
		intpuPane.add(lblGenre3);

		txt_Genre3 = new JTextField();
		txt_Genre3.setBounds(331, 263, 291, 20);
		intpuPane.add(txt_Genre3);

		JLabel lblCountryOfOrigin = new JLabel("Country Of Origin");
		lblCountryOfOrigin.setBounds(162, 316, 137, 14);
		intpuPane.add(lblCountryOfOrigin);

		txt_CountryOfOrigin = new JTextField();
		txt_CountryOfOrigin.setBounds(331, 313, 291, 20);
		intpuPane.add(txt_CountryOfOrigin);

		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(162, 367, 137, 14);
		intpuPane.add(lblBudget);

		txt_Budget = new JTextField();
		txt_Budget.setColumns(10);
		txt_Budget.setBounds(331, 364, 291, 20);
		intpuPane.add(txt_Budget);

		lblMsg = new JLabel("");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(191, 449, 388, 14);
		intpuPane.add(lblMsg);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(162, 422, 46, 14);
		intpuPane.add(lblResult);

		comboBox_Result = new JComboBox();
		comboBox_Result.addItem(new ComboItem("Success", "Success"));
		comboBox_Result.addItem(new ComboItem("Fail", "Fail"));
		comboBox_Result.setBounds(331, 419, 291, 20);
		intpuPane.add(comboBox_Result);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 500, 760, 72);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(448, 13, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				manageMovieDataWindow.setNewMovieInputWindow(null);
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(154, 13, 160, 55);
		buttonPanel.add(btnSave);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				manageMovieDataWindow.setNewMovieInputWindow(null);
				dispose();
			}
		});

		populateComboBox();

	}

	private void populateComboBox() {

		comboBox_MainActorPopularity.addItem(new ComboItem("Amateur - Facebook like < 1000", "Amateur"));
		comboBox_MainActorPopularity.addItem(new ComboItem("Star - Facebook like between 1000 and 5000", "Star"));
		comboBox_MainActorPopularity.addItem(new ComboItem("Super Star - Facebook > 5000", "Super Star"));

		comboBox_SecondActorPopularity.addItem(new ComboItem("Amateur - Facebook like < 1000", "Amateur"));
		comboBox_SecondActorPopularity.addItem(new ComboItem("Star - Facebook like between 1000 and 5000", "Star"));
		comboBox_SecondActorPopularity.addItem(new ComboItem("Super Star - Facebook > 5000", "Super Star"));

		comboBox_DirectorPopularity.addItem(new ComboItem("Amateur - Facebook like < 100", "Amateur"));
		comboBox_DirectorPopularity.addItem(new ComboItem("Star - Facebook like between 100 and 1000", "Star"));
		comboBox_DirectorPopularity.addItem(new ComboItem("Super Star - Facebook > 1000", "Super Star"));

	}

	private void save() {
		lblMsg.setText("");
		if (validateForm()) {

			Movie newMovie = new Movie();
			newMovie.setMainActorPopularity(MainActorPopularity);
			newMovie.setSecondActorPopularity(SecondActorPopularity);
			newMovie.setDirectorPopularity(DirectorPopularity);
			newMovie.setGenre1(genre1);
			newMovie.setGenre2(genre2);
			newMovie.setGenre3(genre3);
			newMovie.setCountryOfOrigin(countryOfOrigin);
			newMovie.setBudget(budget);
			newMovie.setResult(result);

			boolean movieAdded = movieService.AddMovie(newMovie);

			if (movieAdded) {
				JOptionPane.showConfirmDialog(this, "New Movie has been added successfully !", "Success",
						JOptionPane.DEFAULT_OPTION);
				manageMovieDataWindow.initialize();
				manageMovieDataWindow.setNewMovieInputWindow(null);
				this.dispose();
			} else {
				JOptionPane.showConfirmDialog(this, "Failed to add New Movie !", "Fail", JOptionPane.DEFAULT_OPTION);
			}
		}

		else {
			lblMsg.setText("Invalid input");
		}
	}

	private Boolean validateForm() {
		MainActorPopularity = ((ComboItem) comboBox_MainActorPopularity.getSelectedItem()).getValue().trim();
		if (MainActorPopularity.length() == 0) {
			return false;
		}
		SecondActorPopularity = ((ComboItem) comboBox_SecondActorPopularity.getSelectedItem()).getValue().trim();
		if (SecondActorPopularity.length() == 0) {
			return false;
		}
		DirectorPopularity = ((ComboItem) comboBox_DirectorPopularity.getSelectedItem()).getValue().trim();
		if (DirectorPopularity.length() == 0) {
			return false;
		}
		genre1 = txt_Genre1.getText().trim();
		if (genre1.length() == 0) {
			return false;
		}
		genre2 = txt_Genre2.getText().trim();
		if (genre2.length() == 0) {
			return false;
		}
		genre3 = txt_Genre3.getText().trim();
		if (genre3.length() == 0) {
			return false;
		}
		countryOfOrigin = txt_CountryOfOrigin.getText().trim();
		if (countryOfOrigin.length() == 0) {
			return false;
		}
		try {
			budget = Double.parseDouble(txt_Budget.getText());
		} catch (Exception ex) {
			return false;
		}

		result = ((ComboItem) comboBox_Result.getSelectedItem()).getValue();
		return true;
	}

}
