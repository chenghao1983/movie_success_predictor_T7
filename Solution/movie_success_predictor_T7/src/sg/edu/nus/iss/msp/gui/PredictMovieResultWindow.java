package sg.edu.nus.iss.msp.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PredictMovieResultWindow extends JFrame {
	private PredictMovieInputWindow predictMovieInputWindow;
	private MovieService movieService;
	private Movie[] movies;
	private String predictionResult;
	private String outPutMsg;

	public PredictMovieResultWindow(PredictMovieInputWindow predictMovieInputWindow, MovieService movieService,
			String outPutMsg) {

		this.predictMovieInputWindow = predictMovieInputWindow;
		this.movieService = movieService;
		this.movies = movieService.getMovies();
		this.predictionResult = movieService.getPredictionResult();
		this.outPutMsg = outPutMsg;
		initialize();

	}

	private void initialize() {
		setSize(800, 600);
		setTitle("Result");

		getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 764, 459);
		textArea.setText(outPutMsg);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 11, 764, 459);
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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				predictMovieInputWindow.setPredictMovieResultWindow(null);
				dispose();
			}
		});

	}
}
