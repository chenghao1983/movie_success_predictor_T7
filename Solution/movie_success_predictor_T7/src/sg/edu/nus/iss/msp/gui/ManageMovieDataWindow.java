package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;

public class ManageMovieDataWindow extends JFrame {

	private MainWindow mainWindow;
	private MovieService movieService;

	private Movie[] movies;

	private String[] columns = new String[] { "Main Actor Name", "Main Actor Popularity", "Secondary Actor Name",
			"Secondary Actor Popularity", "Director Name", "Director Popularity", "Genre", 
			"Country of Origin ", "Gross Profit", "Budget", "Result" };

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
		btnClose.setBounds(400, 5, 160, 55);
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
			values[1] = String.format("%1$,.0f", movies[i].getMainActorPopularity());  
			values[2] = movies[i].getSecondActorName();
			values[3] = String.format("%1$,.0f", movies[i].getSecondActorPopularity());  
			values[4] = movies[i].getDirectorName();
			values[5] = String.format("%1$,.0f", movies[i].getDirectorPopularity()); 
			values[6] = movies[i].getGenre();
			values[7] = movies[i].getCountryOfOrigin();
			values[8] = String.format("%1$,.0f", movies[i].getGrossProfit()); 
			values[9] = String.format("%1$,.0f", movies[i].getBudget()); 
			values[10] = movies[i].getResult();
					
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
