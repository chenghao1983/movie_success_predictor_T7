package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;
import weka.gui.arffviewer.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManageMovieDataWindow extends JFrame {

	private MainWindow mainWindow;
	private MovieService movieService;
	private NewMovieInputWindow newMovieInputWindow;

	private Movie[] movies;

	private String[] columns = new String[] { "Main Actor Popularity", "Secondary Actor Popularity",
			"Director Popularity", "Genre1", "Genre2", "Genre3", "Country of Origin ", "Budget", "Result" };

	JScrollPane scrollPane;
	JTable table;
	JLabel lblTotalMovie;

	public ManageMovieDataWindow(MainWindow mainWindow, MovieService movieService) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mainWindow.setManageMovieDataWindow(null);
				if (getNewMovieInputWindow() != null) {
					getNewMovieInputWindow().dispose();
				}
				dispose();
			}
		});
		this.movieService = movieService;
		this.mainWindow = mainWindow;
		// this.movies = movieService.getMovies();
		initialize();
	}

	public void initialize() {
		this.movies = movieService.getMovies();

		setSize(1000, 600);
		setTitle("Movie List");

		getContentPane().removeAll();
		
		getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 960, 432);
		getContentPane().add(scrollPane);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 481, 960, 66);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(649, 4, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainWindow.setManageMovieDataWindow(null);
				if (getNewMovieInputWindow() != null) {
					getNewMovieInputWindow().dispose();
				}
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		JButton btnAddNewMovie = new JButton("Add New Movie");
		btnAddNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addNewMovie();

			}

		});
		btnAddNewMovie.setBounds(194, 4, 160, 55);
		buttonPanel.add(btnAddNewMovie);
		
		JButton btnDelete = new JButton("Delete Movie");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow == -1)
				{
					JOptionPane.showConfirmDialog(getContentPane(), "Please select a movie", "warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				else
				{
					int result = JOptionPane.showConfirmDialog(getContentPane(),
							"Confirm to delete the selected movie ?", "Confirm",
							0);
					if (result == 1) {
						return;
					}
					
				
					boolean movieAdded = movieService.DeleteMovie(selectedRow);

					if (movieAdded) {
						JOptionPane.showConfirmDialog(getContentPane(), "Movie has been deleted successfully !", "Success",
								JOptionPane.DEFAULT_OPTION);
						initialize();
					} else {
						JOptionPane.showConfirmDialog(getContentPane(), "Failed to delete Movie !", "Fail", JOptionPane.DEFAULT_OPTION);
					}
					
				}
			}
		});
		btnDelete.setBounds(416, 4, 160, 55);
		buttonPanel.add(btnDelete);

		lblTotalMovie = new JLabel("");
		lblTotalMovie.setBounds(10, 454, 267, 14);
		getContentPane().add(lblTotalMovie);

		populateMovieData();

	}

	public void populateMovieData() {
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		lblTotalMovie.setText("Total Number of Movies: " + movies.length);
		// jTable Data Display
		Object[][] data = new Object[movies.length][];

		for (int i = 0; i < movies.length; i++) {
			String[] values = new String[columns.length];
			values[0] = movies[i].getMainActorPopularity();
			values[1] = movies[i].getSecondActorPopularity();
			values[2] = movies[i].getDirectorPopularity();
			values[3] = movies[i].getGenre1();
			values[4] = movies[i].getGenre2();
			values[5] = movies[i].getGenre3();
			values[6] = movies[i].getCountryOfOrigin();
			values[7] = String.format("%1$,.0f", movies[i].getBudget());
			values[8] = movies[i].getResult();

			data[i] = values;
		}

		DefaultTableModel model = new DefaultTableModel(data, columns) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -1229371328085071411L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		model.isCellEditable(0, 0);
		table.setModel(model);

	}

	private void addNewMovie() {
		if (newMovieInputWindow == null) {
			setNewMovieInputWindow(new NewMovieInputWindow(this, movieService));
			getNewMovieInputWindow().setVisible(true);
			getNewMovieInputWindow().setLocation(getLocation());
		}

	}

	public NewMovieInputWindow getNewMovieInputWindow() {
		return newMovieInputWindow;
	}

	public void setNewMovieInputWindow(NewMovieInputWindow newMovieInputWindow) {
		this.newMovieInputWindow = newMovieInputWindow;
	}
}
