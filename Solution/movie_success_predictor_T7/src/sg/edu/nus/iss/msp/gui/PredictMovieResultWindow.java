package sg.edu.nus.iss.msp.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;

public class PredictMovieResultWindow extends JFrame {
	private PredictMovieInputWindow predictMovieInputWindow;
	private MovieService movieService;
	private Movie[] movies;
	private String predictionResult;
	private JLabel lblMsg;

	public PredictMovieResultWindow(PredictMovieInputWindow predictMovieInputWindow, MovieService movieService) {
		this.predictMovieInputWindow = predictMovieInputWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();
		this.predictionResult = movieService.getPredictionResult();
		initialize();

	}

	private void initialize() {
		setSize(800, 600);
		setTitle("Result");

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
		btnClose.setBounds(300, 5, 160, 55);
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				predictMovieInputWindow.setPredictMovieResultWindow(null);
				dispose();
			}

		});
		buttonPanel.add(btnClose);

		
		// TODO
		lblMsg = new JLabel("");
		lblMsg.setText(this.predictionResult);
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(191, 449, 388, 14);
		lblMsg.setVisible(true);
		scrollPane.add(lblMsg);

	}
}
