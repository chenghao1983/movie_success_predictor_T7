package sg.edu.nus.iss.msp.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;

public class MainWindow extends JFrame {

	private MovieService movieService;
	private Movie[] movies;

	private ManageMovieDataWindow manageMovieDataWindow;
	private PredictMovieInputWindow predictMovieInputWindow;

	public MainWindow(MovieService movieService) {
		this.movieService = movieService;
		initialize();

	}

	private void initialize() {
		this.setTitle("Movie Success Predictor T7");
		this.getContentPane().setLayout(null);

		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(800, 526);

		JPanel WelcomePanel = new JPanel();
		WelcomePanel.setBounds(5, 20, 780, 50);
		this.getContentPane().add(WelcomePanel);
		WelcomePanel.setLayout(null);

		JLabel Lbl_Welcome = new JLabel("Welcome !");
		Lbl_Welcome.setBounds(331, 11, 71, 17);
		Lbl_Welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		WelcomePanel.add(Lbl_Welcome);

		JPanel OptionPanel = new JPanel();
		OptionPanel.setBounds(5, 110, 780, 250);
		this.getContentPane().add(OptionPanel);
		OptionPanel.setLayout(null);

		JButton Btn_ManageMovieData = new JButton("View Movie Data");
		Btn_ManageMovieData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageMovieData();
			}
		});
		Btn_ManageMovieData.setBounds(72, 48, 250, 150);
		OptionPanel.add(Btn_ManageMovieData);

		JButton Btn_PredictNewMovie = new JButton("Predict New Movie");
		Btn_PredictNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PredictNewMovie();
			}
		});
		Btn_PredictNewMovie.setBounds(409, 48, 250, 150);
		OptionPanel.add(Btn_PredictNewMovie);

		JPanel FooterPanel = new JPanel();
		FooterPanel.setBounds(5, 409, 780, 60);
		this.getContentPane().add(FooterPanel);
		FooterPanel.setLayout(null);

		JButton Btn_Close = new JButton("Close");
		Btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Btn_Close.setBounds(246, 3, 250, 55);
		FooterPanel.add(Btn_Close);

	}

	private void ManageMovieData() {
		if (manageMovieDataWindow == null) {
			manageMovieDataWindow = new ManageMovieDataWindow(this, movieService);
			manageMovieDataWindow.setVisible(true);
			manageMovieDataWindow.setLocation(getLocation());
		}
	}

	private void PredictNewMovie() {
		if (predictMovieInputWindow == null) {
			predictMovieInputWindow = new PredictMovieInputWindow(this, movieService);
			predictMovieInputWindow.setVisible(true);
			predictMovieInputWindow.setLocation(getLocation());
		}
	}

	public ManageMovieDataWindow getManageMovieDataWindow() {
		return manageMovieDataWindow;
	}

	public void setManageMovieDataWindow(ManageMovieDataWindow manageMovieDataWindow) {
		this.manageMovieDataWindow = manageMovieDataWindow;
	}

	public PredictMovieInputWindow getPredictMovieInputWindow() {
		return predictMovieInputWindow;
	}

	public void setPredictMovieInputWindow(PredictMovieInputWindow predictMovieInputWindow) {
		this.predictMovieInputWindow = predictMovieInputWindow;
	}

}
