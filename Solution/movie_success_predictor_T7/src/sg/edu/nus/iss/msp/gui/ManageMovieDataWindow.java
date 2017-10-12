package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;

public class ManageMovieDataWindow extends JFrame {
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	private JTable table;
	private JButton btnImportMovie;
	private JButton btnClose;
	private DefaultTableModel model;

	private MovieService movieService;
	private Movie[] movies;

	private String[] columns = new String[] { "Main Actor popularity", "Secondary Actor popularity",
			"Director popularity", "Genre", "IMDB score", "Country of Origin ", "Gross Profit", "Budget", "Success"};

	public ManageMovieDataWindow(MovieService movieService) {
		this.movieService = movieService;
		this.movies = movieService.getMovies();
		initialize();
	}

	private void initialize() {
		setSize(821, 600);
		setTitle("Movie List");

		getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 11, 782, 459);
		getContentPane().add(scrollPane);
		buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 481, 782, 66);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);

		btnImportMovie = new JButton("Import Movie");
		btnImportMovie.setBounds(185, 5, 160, 55);
		btnImportMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importMovieData();
			}
		});
		buttonPanel.setLayout(null);
		buttonPanel.add(btnImportMovie);

		btnClose = new JButton("Close");
		btnClose.setBounds(424, 5, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		// jTable Data Display
		Object[][] data = new Object[movies.length][];
		model = new DefaultTableModel(data, columns) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.isCellEditable(0, 0);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

	}

	private void importMovieData() {
		// TODO

	}

}
