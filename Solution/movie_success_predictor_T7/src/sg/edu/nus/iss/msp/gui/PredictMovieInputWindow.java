package sg.edu.nus.iss.msp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;

public class PredictMovieInputWindow extends JFrame {
	
	private MainWindow mainWindow;
	private PredictMovieResultWindow predictMovieResultWindow;
	private MovieService movieService;
	private Movie[] movies;
	private JButton btnPredict;
	private JTextField Txt_MainActorName;
	private JTextField txt_MainActorPopularity;
	private JTextField txt_secondActorName;
	private JTextField txt_SecondActorPopularity;
	private JTextField txt_DirectorName;
	private JTextField txt_DirectorPopularity;
	private JTextField txt_Genre;
	private JTextField txt_IMDBScore;
	private JTextField txt_CountryOfOrigin;
	private JTextField txt_GrossProfit;
	private JTextField txt_Budget;

	public PredictMovieInputWindow(MainWindow mainWindow, MovieService movieService) {
		
		this.mainWindow = mainWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();

		initialize();

	}

	private void initialize() {
		setSize(800, 600);
		setTitle("Predict New Movie");
		
		getContentPane().setLayout(null);
		JPanel intpuPane = new JPanel();
		intpuPane.setBounds(10, 11, 760, 450);
		getContentPane().add(intpuPane);
		intpuPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main Actor Name");
		lblNewLabel.setBounds(191, 27, 81, 14);
		intpuPane.add(lblNewLabel);
		
		Txt_MainActorName = new JTextField();
		Txt_MainActorName.setBounds(331, 24, 248, 20);
		intpuPane.add(Txt_MainActorName);
		Txt_MainActorName.setColumns(10);
		
		JLabel lblMainActorPopularity = new JLabel("Main Actor Popularity");
		lblMainActorPopularity.setBounds(191, 62, 126, 14);
		intpuPane.add(lblMainActorPopularity);
		
		txt_MainActorPopularity = new JTextField();
		txt_MainActorPopularity.setColumns(10);
		txt_MainActorPopularity.setBounds(331, 59, 248, 20);
		intpuPane.add(txt_MainActorPopularity);
		
		JLabel lblSecondActorName = new JLabel("Second Actor Name");
		lblSecondActorName.setBounds(191, 98, 126, 14);
		intpuPane.add(lblSecondActorName);
		
		txt_secondActorName = new JTextField();
		txt_secondActorName.setColumns(10);
		txt_secondActorName.setBounds(331, 95, 248, 20);
		intpuPane.add(txt_secondActorName);
		
		JLabel lblSecondActorPopularity = new JLabel("Second Actor Popularity");
		lblSecondActorPopularity.setBounds(191, 135, 126, 14);
		intpuPane.add(lblSecondActorPopularity);
		
		txt_SecondActorPopularity = new JTextField();
		txt_SecondActorPopularity.setColumns(10);
		txt_SecondActorPopularity.setBounds(331, 132, 248, 20);
		intpuPane.add(txt_SecondActorPopularity);
		
		JLabel lblDirectorName = new JLabel("Director Name");
		lblDirectorName.setBounds(191, 176, 126, 14);
		intpuPane.add(lblDirectorName);
		
		txt_DirectorName = new JTextField();
		txt_DirectorName.setColumns(10);
		txt_DirectorName.setBounds(331, 173, 248, 20);
		intpuPane.add(txt_DirectorName);
		
		JLabel lblDirectorPopularity = new JLabel("Director Popularity");
		lblDirectorPopularity.setBounds(191, 213, 126, 14);
		intpuPane.add(lblDirectorPopularity);
		
		txt_DirectorPopularity = new JTextField();
		txt_DirectorPopularity.setColumns(10);
		txt_DirectorPopularity.setBounds(331, 210, 248, 20);
		intpuPane.add(txt_DirectorPopularity);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(191, 253, 126, 14);
		intpuPane.add(lblGenre);
		
		txt_Genre = new JTextField();
		txt_Genre.setColumns(10);
		txt_Genre.setBounds(331, 250, 248, 20);
		intpuPane.add(txt_Genre);
		
		JLabel lblImdbScore = new JLabel("IMDB Score");
		lblImdbScore.setBounds(191, 292, 126, 14);
		intpuPane.add(lblImdbScore);
		
		txt_IMDBScore = new JTextField();
		txt_IMDBScore.setColumns(10);
		txt_IMDBScore.setBounds(331, 289, 248, 20);
		intpuPane.add(txt_IMDBScore);
		
		JLabel lblCountryOfOrigin = new JLabel("Country Of Origin");
		lblCountryOfOrigin.setBounds(191, 329, 126, 14);
		intpuPane.add(lblCountryOfOrigin);
		
		txt_CountryOfOrigin = new JTextField();
		txt_CountryOfOrigin.setColumns(10);
		txt_CountryOfOrigin.setBounds(331, 326, 248, 20);
		intpuPane.add(txt_CountryOfOrigin);
		
		JLabel lblGrossProfit = new JLabel("Gross Profit");
		lblGrossProfit.setBounds(191, 364, 126, 14);
		intpuPane.add(lblGrossProfit);
		
		txt_GrossProfit = new JTextField();
		txt_GrossProfit.setColumns(10);
		txt_GrossProfit.setBounds(331, 361, 248, 20);
		intpuPane.add(txt_GrossProfit);
		
		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(191, 400, 126, 14);
		intpuPane.add(lblBudget);
		
		txt_Budget = new JTextField();
		txt_Budget.setColumns(10);
		txt_Budget.setBounds(331, 397, 248, 20);
		intpuPane.add(txt_Budget);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 481, 782, 66);
		getContentPane().add(buttonPanel);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(450, 5, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainWindow.setPredictMovieInputWindow(null);
				dispose();
			}

		});
		buttonPanel.add(btnClose);
		
		btnPredict = new JButton("Predict");
		btnPredict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				predict();
			}
		});
		btnPredict.setBounds(150, 5, 160, 55);
		buttonPanel.add(btnPredict);


	}

	private void predict() {
		// TODO Auto-generated method stub
		if(validateForm())
		{
			if(getPredictMovieResultWindow() ==null)
			{
			//MovieService.predict();
				predictMovieResultWindow = new PredictMovieResultWindow(this, movieService);
				predictMovieResultWindow.setVisible(true);
				predictMovieResultWindow.setLocation(getLocation());
			}
		}
	}
	private Boolean validateForm()
	{
		Boolean validated = true;
		
		return validated;
	}

	public PredictMovieResultWindow getPredictMovieResultWindow() {
		return predictMovieResultWindow;
	}

	public void setPredictMovieResultWindow(PredictMovieResultWindow predictMovieResultWindow) {
		this.predictMovieResultWindow = predictMovieResultWindow;
	}

}
