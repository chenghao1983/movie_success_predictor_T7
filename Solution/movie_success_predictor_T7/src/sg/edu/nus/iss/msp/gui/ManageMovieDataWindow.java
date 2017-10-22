package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;
import weka.gui.arffviewer.*;

public class ManageMovieDataWindow extends JFrame {

	private MainWindow mainWindow;
	private MovieService movieService;

	private Movie[] movies;

	private String[] columns = new String[] { "Main Actor Name",  "Secondary Actor Name",
			"Director Name",  "Genre1", "Genre2", "Genre3", 
			"Country of Origin ", "Budget", "Result" };

	public ManageMovieDataWindow(MainWindow mainWindow, MovieService movieService) {
		this.movieService = movieService;
		this.mainWindow = mainWindow;
		this.movies = movieService.getMovies();
		initialize();
	}

	private void initialize() {
		setSize(1000, 600);
		setTitle("Movie List");

		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 960, 450);
		getContentPane().add(scrollPane);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 481, 960, 66);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(408, 0, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainWindow.setManageMovieDataWindow(null);
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		// jTable Data Display
		Object[][] data = new Object[movies.length][];

		for (int i = 0; i < movies.length; i++) {
			String[] values = new String[columns.length];
			values[0] = movies[i].getMainActorName();
			values[1] = movies[i].getSecondActorName();
			values[2] = movies[i].getDirectorName();
			values[3] = movies[i].getGenre1();
			values[4] = movies[i].getGenre2();
			values[5] = movies[i].getGenre3();
			values[6] = movies[i].getCountryOfOrigin();
			values[7] = String.format("%1$,.0f", movies[i].getBudget()); 
			values[8] = movies[i].getResult();
					
			data[i] = values;
		}

		DefaultTableModel model = new DefaultTableModel(data, columns) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		model.isCellEditable(0, 0);

		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

	}

}
